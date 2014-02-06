/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;



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
    }

    protected void execute() {
        //wait until timer is 2 seconds then do stuff
        if(timeLord.get()<=2000){
            
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
    
    }
    
    
    
    

