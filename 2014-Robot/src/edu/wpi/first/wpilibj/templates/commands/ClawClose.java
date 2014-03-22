/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class closes the claw using limit switches as reference for position The
 * current speed is set at .25, check this to make sure it is the best fit
 *
 * @author Lauren
 */
public class ClawClose extends CommandBase {
    
    Timer timer = new Timer();

    public ClawClose() {
        requires(grabber);
    }

    protected void initialize() {
        timer.reset();
        timer.start();

    }

    /**
     * Called repeatedly when this Command is scheduled to run close claw
     */
    protected void execute() {
        if (grabber.clawLimitSwitchCloseRightLimit.get() != true && grabber.clawLimitSwitchCloseLeftLimit.get() != true) {
            return;
        }
        if(timer.get() <= .1){
            grabber.setSpeed(-.9);
        } else {
            grabber.setSpeed(-.5);
        }

    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return true if limit switch has been hit
     */
    protected boolean isFinished() {
        System.out.println("Close: Left = " + grabber.clawLimitSwitchCloseLeftLimit.get() + " Right = " + grabber.clawLimitSwitchCloseRightLimit.get());
        System.out.println("Open: Left = " + grabber.clawLimitSwitchOpenLeftLimit.get() + " Right = " + grabber.clawLimitSwitchOpenRightLimit.get());
        if (grabber.clawLimitSwitchCloseRightLimit.get() != true && grabber.clawLimitSwitchCloseLeftLimit.get() != true) {
            return true;
        }
        if( timer.get() > .75){
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        grabber.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
