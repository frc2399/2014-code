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
public class WaitForHotTarget extends CommandBase{
    
    Timer timer;
    
    public WaitForHotTarget(Timer timer){
        //requires(kicker); i think kicker exists in other branch
        this.timer = timer;
    }
    
    protected void initialize() {
     }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        /*if(Vision.isHot() || timer.get() >= 5){
            timer.stop();
            double time = timer.get();
            if(timer2.get() < time + 2){
                    kicker.setSpeed(.95); //this exists in al
                }
        }*/
        //TODO go through this again 
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Vision.isHot() || timer.get() >= 5) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
