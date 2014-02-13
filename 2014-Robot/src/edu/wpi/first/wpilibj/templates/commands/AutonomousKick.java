/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.Vision;
/**
 *
 * @author Lauren
 */
public class AutonomousKick extends CommandBase{
    
    Timer timer;
    Timer timer2;
    boolean isDone = false;
    
    public AutonomousKick(Timer timer){
        //requires(kicker); i think kicker exists in other branch
        this.timer = timer;
        this.timer2 = new Timer();
    }
    
    protected void initialize() {
        timer.reset();
        timer2.reset();
     }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if(Vision.isHot() || timer.get() >= 5){
            if(timer2.get() < 2){
                    kicker.setSpeed(); //this exists in al
                }
            isDone = true;
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
