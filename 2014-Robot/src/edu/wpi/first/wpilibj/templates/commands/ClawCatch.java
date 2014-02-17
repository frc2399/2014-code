/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.CANJaguar;
/**
 *
 * @author Lauren
 * 
 * This class moves the claw from its current position into catching position, i.e. the very top of the robot. 
 * To do this, the claw moves backward until the top limit switch is triggered 
 * 
 * While this command only applies to one position at the moment; this could be used to move to the half way point, 
 * bottom, etc.
 */
public class ClawCatch extends CommandBase{
    
    public ClawCatch(){
        requires(clawPitch);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if( clawPitch.getPosition() > clawPitch.minPosition){
            clawPitch.setPosition(clawPitch.minPosition);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if( clawPitch.getPosition() <= clawPitch.maxPosition + clawPitch.TOLERANCE){
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
