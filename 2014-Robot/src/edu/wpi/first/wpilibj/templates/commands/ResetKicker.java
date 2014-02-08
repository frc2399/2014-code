/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Amanda Merritt and Lauren Egts
 * 
 */
public class ResetKicker extends CommandBase {
    
    public ResetKicker() {
        requires(kicker);
    }
    
    
    
    protected void initialize() {
       
    }

    protected void execute() {
        kicker.usePIDOutput(0); //placeholder number 
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
    
}
