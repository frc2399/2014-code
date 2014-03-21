/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class closes the claw using limit switches as reference for position The
 * current speed is set at .25, check this to make sure it is the best fit
 *
 * @author Lauren
 */
public class ClawClose extends CommandBase {

    public ClawClose() {
        requires(grabber);
    }

    protected void initialize() {

    }

    /**
     * Called repeatedly when this Command is scheduled to run close claw
     */
    protected void execute() {
        grabber.setSpeed(-1);
        SmartDashboard.putBoolean("closeLeft", grabber.clawLimitSwitchCloseLeftLimit.get());
        SmartDashboard.putBoolean("openLeft", grabber.clawLimitSwitchOpenLeftLimit.get());
        SmartDashboard.putBoolean("closeRight", grabber.clawLimitSwitchCloseRightLimit.get());
        SmartDashboard.putBoolean("openRight", grabber.clawLimitSwitchOpenRightLimit.get());
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
        if( oi.clawCloseButt.get() != true){
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
