/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Vision;

/**
 *
 * @author jallen
 */
public class AutoPosition extends CommandBase {
    
    final double TOLERANCE = 15.0; // acceptable tolerance, in inches
    
    double targetDistance;
    
    public AutoPosition(double desiredDistance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        targetDistance = desiredDistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double travelDistance;
        // use Vision.getDistance() to retrieve the current distance in inches
        travelDistance = (Vision.getDistance() - targetDistance);
        if (travelDistance > 0) {
            driveTrain.drive.mecanumDrive_Cartesian(0, -0.2, 0, 0);
        } else if (travelDistance < 0) {
            driveTrain.drive.mecanumDrive_Cartesian(0, 0.2, 0, 0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Vision.getDistance() < (targetDistance + TOLERANCE) && Vision.getDistance() > (targetDistance - TOLERANCE)){
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
