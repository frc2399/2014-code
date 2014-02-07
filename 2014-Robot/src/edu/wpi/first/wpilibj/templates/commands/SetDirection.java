/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Arielle
 */
public class SetDirection extends CommandBase {

    double direction;

    public SetDirection(double targetDirection) {
        this.direction = targetDirection;
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double gyroAngle = driveTrain.getGyroAngle();
        if (direction > gyroAngle) {
            driveTrain.drive.mecanumDrive_Cartesian(0, 0, 0.5, 0);
        } else if (direction < gyroAngle) {
            driveTrain.drive.mecanumDrive_Cartesian(0, 0, -0.5, 0);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double gyroAngle = driveTrain.getGyroAngle();
        if (Math.abs(direction - gyroAngle) < 2) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
