/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Lauren
 */
public class ClawOpen extends CommandBase {


    public ClawOpen() {
        requires(grabber);
    }

    protected void initialize() {
       
    }

    /**
     * Called repeatedly when this Command is scheduled to run open claw
     */
    protected void execute() {
        grabber.open();
    
    }

   
    protected boolean isFinished() {

        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
