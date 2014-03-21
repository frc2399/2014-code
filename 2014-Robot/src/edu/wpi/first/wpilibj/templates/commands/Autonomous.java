/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 *
 * @author Lauren
 */
public class Autonomous extends CommandGroup {

    public Autonomous(){
    ///look for target
    //if hot or past 5 seconds, shoot
                
    Timer timer = new Timer();
    timer.reset();
    timer.start();
    addSequential(new SetClawPitch(0.295), 1.5);
    addSequential( new ClawOpen(), 2);
    addSequential(new AutonomousKick(timer)); //shoot 
    addParallel(new ResetKicker2()); //this will execute and run in time with subsequent commands 
    addSequential(new DriveForward(), 2); //move forwrd
    
    }
    
}
