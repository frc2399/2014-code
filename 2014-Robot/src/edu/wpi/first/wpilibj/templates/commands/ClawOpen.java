/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Lauren
 */
public class ClawOpen extends CommandBase {
        Timer timer = new Timer();


    public ClawOpen() {
        requires(grabber);
    }

    protected void initialize() {
        timer.reset();
        timer.start();
    }

    /**
     * Called repeatedly when this Command is scheduled to run open claw
     */
    protected void execute() {
        if (grabber.clawLimitSwitchOpenRightLimit.get() != true && grabber.clawLimitSwitchOpenLeftLimit.get() != true) {
            return;
        }
        if(timer.get() <= .1){
            grabber.setSpeed(.9);
        } else{
            grabber.setSpeed(.5);
        }
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return true if open limit switch has been hit
     */
    protected boolean isFinished() {

        if (grabber.clawLimitSwitchOpenRightLimit.get() != true && grabber.clawLimitSwitchOpenLeftLimit.get() != true) {
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
