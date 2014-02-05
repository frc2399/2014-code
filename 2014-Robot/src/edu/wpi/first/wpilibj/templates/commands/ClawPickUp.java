/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.templates.subsystems.Claw;


/**
 *
 * @author Lauren
 */
public class ClawPickUp extends CommandBase{
    
    public ClawPickUp(){
        requires(claw);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    /*
     * if the limit switch is not triggered move the claw backwards
     * if it is trigered do nothing 
     * 
     * @author Arielle
     */
    protected void execute() {
           if(claw.clawLimitSwitchBottom.get() == false) {
               claw.setSpeed(0.25);
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
