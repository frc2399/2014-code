/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

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
        //kicker.setSetpoint(kicker.topPoint);
        kicker.setPosition(.33); //change this TODO
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
    
}
