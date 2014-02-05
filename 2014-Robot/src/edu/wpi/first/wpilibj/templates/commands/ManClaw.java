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
public class ManClaw extends CommandBase{
    public ManClaw(){
        requires(claw);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(claw.clawLimitSwitchTop.get() == false && (oi.getDriveyStickY() > 0)){
            claw.setSpeed(oi.getDriveyStickY());
        } else if (claw.clawLimitSwitchBottom.get() == false && (oi.getDriveyStickY() < 0)){
            claw.setSpeed(oi.getDriveyStickY());
        }
        
        // if top switch is triggered only allow downward movement
        //if bottom switch is triggered only allow upward movement 
        
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
