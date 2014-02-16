/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.CANJaguarPositionSensor;
import edu.wpi.first.wpilibj.templates.CANJaguarSpeedSensor;
import edu.wpi.first.wpilibj.templates.CANJaguarPIDActuator;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Arielle
 */
public class ShooterWheel extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    CANJaguar shooterWheelMotor;
    
    public ShooterWheel() {
        try {
            shooterWheelMotor = new CANJaguar(RobotMap.shooterWheelMotor); 
            shooterWheelMotor.changeControlMode(CANJaguar.ControlMode.kSpeed);
            shooterWheelMotor.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
            shooterWheelMotor.setPID(2.0, 0.1, 0);
            shooterWheelMotor.configEncoderCodesPerRev(256);
            
            LiveWindow.addActuator("ShooterWheel", "CanJaguarPID", new CANJaguarPIDActuator(shooterWheelMotor));
            LiveWindow.addSensor("ShooterWheel", "Position", new CANJaguarPositionSensor(shooterWheelMotor));
            LiveWindow.addSensor("ShooterWheel", "Speed", new CANJaguarSpeedSensor(shooterWheelMotor));
            //LiveWindow.addActuator("ShooterWheel", "ShooterWheelMotor", shooterWheelMotor);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
