/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *command group will make sure claw is open before kicking.
 * will use this command for kicking in game
 * 
 * @author Lauren
 */
public class Fire extends CommandGroup{
    
    public Fire(){
        
        if(CommandBase.grabber.clawLimitSwitchOpenLeftLimit.get() && CommandBase.grabber.clawLimitSwitchOpenRightLimit.get()){
            addSequential(new Kick());
        }
        
    }
    
}