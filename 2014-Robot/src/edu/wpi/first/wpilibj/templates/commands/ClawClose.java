/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;


/**
 * This class closes the claw using limit switches as reference for position 
 * The current speed is set at .25, check this to make sure it is the best fit 
 * @author Lauren
 */
public class ClawClose extends CommandBase{
    
    public ClawClose(){
        requires(grabber);
    }
    
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if(grabber.clawLimitSwitchCloseLimit.get() == false){
            grabber.setSpeed(-0.25);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(grabber.clawLimitSwitchCloseLimit.get() == true){
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
