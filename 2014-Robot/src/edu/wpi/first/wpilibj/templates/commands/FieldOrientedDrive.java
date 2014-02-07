/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.templates.OI;
/**
 *
 * @author Arielle
 */
public class FieldOrientedDrive extends JoystickDrive {
    
   
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
         if (oi.shouldStrafe()) {
            // gyro-based
            driveTrain.drive.mecanumDrive_Cartesian(oi.getSideSpeed(), 0, oi.getTwistSpeed(), driveTrain.getGyroAngle());
        } else {
            // robot-oriented
            //@param side speed, forward speed, twist speed, gyro
            driveTrain.drive.mecanumDrive_Cartesian(oi.getSideSpeed(), oi.getForwardSpeed(), oi.getTwistSpeed(), driveTrain.getGyroAngle());

            // field-oriented
            // driveTrain.drive.mecanumDrive_Cartesian(oi.getSideSpeed(), oi.getForwardSpeed(), oi.getTwistSpeed(), driveTrain.getGyroAngle());
        
         }
    }
  
}
