/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.templates.subsystems.Claw;
/**
 *
 * @author Lauren
 */
public class ClawCatch extends CommandBase{
    
    public ClawCatch(){
        requires(claw);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    /*
     * if the limit switch is not triggered move the claw backwards
     * if it is trigered do nothing 
     */
    protected void execute() {
       
        if( claw.clawLimitSwitch.get() == false){
                    claw.setSpeed(-.5); //check to make sure this is negative 
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
