/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**

 * This class moves the claw from its current position into catching position, i.e. the very top of the robot. 
 * To do this, the claw moves backward until it reaches the minimum position defined in the claw Pitch subsystem 
 * @author Lauren
 */
public class ClawCatch extends CommandBase{
    
    public ClawCatch(){
        requires(clawPitch);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * if the position is greater than or equal to the minimum position 
     * set position to Minimum position
     */
    protected void execute() {
        if( clawPitch.getPosition() > clawPitch.MIN_POSITION){
            clawPitch.setPosition(clawPitch.MIN_POSITION);
        }

    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     * @return true if position is within tolerance 
     */
    protected boolean isFinished() {
        if( clawPitch.getPosition() <= clawPitch.MIN_POSITION + clawPitch.TOLERANCE){
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
