/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 * this class is used for manual control of the claw
 *
 * We need to find PID values for limit for each end. This code will make sure
 * the claw stays within these limits
 *
 * @author Lauren
 */
public class ManClaw extends CommandBase {

    public ManClaw() {
        requires(clawPitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (clawPitch.getPosition() < clawPitch.MAX_POSITION && oi.getClawSpeed() > 0) {
            clawPitch.setSpeed(oi.getClawSpeed());
            //clawPitch.setSetpointRelative(oi.getClawSpeed());
        } else if (clawPitch.getPosition() > clawPitch.MIN_POSITION && oi.getClawSpeed() < 0) {
            clawPitch.setSpeed(oi.getClawSpeed());
            //clawPitch.setSetpointRelative(oi.getClawSpeed());
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
