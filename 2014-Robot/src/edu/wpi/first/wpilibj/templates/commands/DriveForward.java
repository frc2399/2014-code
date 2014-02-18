/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Lauren
 */
public class DriveForward extends CommandBase {

    public DriveForward() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // robot-oriented
        //@param side speed, forward speed, twist speed, gyro
        driveTrain.drive.mecanumDrive_Cartesian(0, .5, 0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}
