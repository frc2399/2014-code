/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Lauren
 */
public class JoystickDrive extends CommandBase{
    
    
    public JoystickDrive(){
        requires(driveTrain);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
       
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.shouldStrafe()) {
            // TODO make this use gyro?
            driveTrain.drive.mecanumDrive_Cartesian(oi.getSideSpeed(),0, oi.getTwistSpeed(), 0);     
        } else {
            driveTrain.drive.mecanumDrive_Cartesian(oi.getSideSpeed(), oi.getForwardSpeed(), oi.getTwistSpeed(), 0);
        }
        
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
