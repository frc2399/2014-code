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
public class AutonomousKick {
    
    Timer timer;
    
    public AutonomousKick(Timer timer){
        //requires(kicker); i think kicker exists in other branch
        this.timer = timer;
    }
    
    protected void initialize() {

     }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        while(timer.get() <= 5){
            if( Vision.isHot()){ //look for target, if past 5 seconds shoot 
            //addSequential(new Kick());
                break;
            }
        }
        if( Vision.isHot()){ //look for target, if past 5 seconds shoot 
          //addSequential(new Kick());
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
