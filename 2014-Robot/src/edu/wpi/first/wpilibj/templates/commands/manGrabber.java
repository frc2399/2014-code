/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author Lauren
 */
public class manGrabber extends CommandBase {
    
    double voltage; 
    Button myButton;
    
    public manGrabber(double voltage, Button myButton) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(grabber);
        this.voltage = voltage;
        this.myButton = myButton;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        grabber.setSpeed(voltage);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(myButton.get()){
            return false;
        }
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        grabber.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}