/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.commands.ManClaw;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.*;

/**
 *
 * @author Lauren 
 */
public class Grabber extends Subsystem {

    public Solenoid grabberSolenoid = new Solenoid(1);
    

    public Grabber() {
      

    }

    public void initDefaultCommand() {

    }
public void open(){
    grabberSolenoid.set(false);
}

public void close(){
    grabberSolenoid.set(true);
}
   

}
