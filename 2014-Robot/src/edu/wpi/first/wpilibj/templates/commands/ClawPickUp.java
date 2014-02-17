/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Lauren
 */
public class ClawPickUp extends CommandBase{
    
    public ClawPickUp(){
        requires(clawPitch);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if( clawPitch.getPosition() < clawPitch.MAX_POSITION){
            clawPitch.setPosition(clawPitch.MAX_POSITION);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if( clawPitch.getPosition() >= clawPitch.MAX_POSITION - clawPitch.TOLERANCE){
            return true;
        }
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
