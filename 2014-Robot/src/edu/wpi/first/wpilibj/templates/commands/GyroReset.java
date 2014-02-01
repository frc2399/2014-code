/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Julia
 */
public class GyroReset extends CommandBase {
    
    public GyroReset() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // in the old code it says that this is true. What should I do?

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
