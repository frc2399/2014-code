/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Lauren
 */
public class JoystickDrive extends CommandBase {

    public JoystickDrive() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.shouldStrafe()) {
            // gyro-based
            driveTrain.drive.mecanumDrive_Cartesian(oi.getRightStickX(), 0, oi.getTwistSpeed(), driveTrain.getGyroAngle());
        } else {
            // robot-oriented
            //@param side speed, forward speed, twist speed, gyro
            driveTrain.drive.mecanumDrive_Cartesian(oi.getRightStickX(), oi.getRightStickY(), oi.getLeftStickX(), 0);

            // field-oriented
            // driveTrain.drive.mecanumDrive_Cartesian(oi.getSideSpeed(), oi.getForwardSpeed(), oi.getTwistSpeed(), driveTrain.getGyroAngle());
        }
        
        /*
        if (oi.getForwardSpeed() > 0.15) {
            System.out.println("backward");
        }
        if (oi.getForwardSpeed() < -0.15) {
            System.out.println("foreward");
        }
        if (oi.getSideSpeed() > 0.15) {
            System.out.println("strafe rt");
        }
        if (oi.getSideSpeed() < -0.15) {
            System.out.println("strafe lt");
        }
        
        System.out.println("gyro: " + driveTrain.getGyroAngle());
        System.out.println("X: " + oi.getSideSpeed()  + "\t Y: " + oi.getForwardSpeed() + "\tZ: " + oi.getTwistSpeed());
        */

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
