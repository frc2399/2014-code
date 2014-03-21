/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Lauren
 */
public class ClawOpen extends CommandBase {

    public ClawOpen() {
        requires(grabber);
    }

    protected void initialize() {

    }

    /**
     * Called repeatedly when this Command is scheduled to run open claw
     */
    protected void execute() {
        grabber.setSpeed(0.8);
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return true if open limit switch has been hit
     */
    protected boolean isFinished() {
        //System.out.println(oi.clawOpenButt.get());
        System.out.println("Close: Left = " + grabber.clawLimitSwitchCloseLeftLimit.get() + " Right = " + grabber.clawLimitSwitchCloseRightLimit.get());
        System.out.println("Open: Left = " + grabber.clawLimitSwitchOpenLeftLimit.get() + " Right = " + grabber.clawLimitSwitchOpenRightLimit.get());

        if (grabber.clawLimitSwitchOpenRightLimit.get() != true && grabber.clawLimitSwitchOpenLeftLimit.get() != true) {
            return true;
        }
        if(oi.clawOpenButt.get() != true){
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
