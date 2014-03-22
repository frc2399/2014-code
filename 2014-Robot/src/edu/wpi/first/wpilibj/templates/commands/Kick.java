/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.subsystems.Kicker;


/**
 *
 * @author Amanda Merritt and Lauren Egts
 */
public class Kick extends CommandBase{
    Timer timeLord = new Timer();
    public Kick() {
        requires(kicker);
        
    }

    protected void initialize() {
       timeLord.reset();
       timeLord.start(); 
    }

    protected void execute() {
        kicker.setVoltage(11); // this value is NO LONGER taken from the smart dashboard  
        //kicker.setVoltage(10);
    }

    protected boolean isFinished() {
        if(timeLord.get() >= .3){ //seconds, test 
            return true;
        }
        return false;
    }

    protected void end() {
        kicker.stop();
    }

    protected void interrupted() {
        
    }
    
    
    }
    
    
    
    
