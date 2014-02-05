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
 * 
 * This class moves the claw from its current position into catching position, i.e. the very top of the robot. 
 * To do this, the claw moves backward until the top limit switch is triggered 
 * 
 * While this command only applies to one position at the moment; this could be used to move to the half way point, 
 * bottom, etc.
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
       
        if( claw.clawLimitSwitchTop.get() == false){
                    claw.setSpeed(-.25); //check to make sure this is negative 
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
