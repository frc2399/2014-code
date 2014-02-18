/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 * @author Lauren
 */
public class Fire extends CommandGroup{
    
    public Fire(){
        
        addSequential(new ClawOpen());
        addSequential(new Kick());
        
    }
    
}
