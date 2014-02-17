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
import edu.wpi.first.wpilibj.templates.CANJaguarPIDActuator;
import edu.wpi.first.wpilibj.templates.CANJaguarPositionSensor;
import edu.wpi.first.wpilibj.templates.CANJaguarSpeedSensor;

/**
 *
 * @author jallen
 */
public class Kicker extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public CANJaguar motor1;
    
    public Kicker(){
        try {
            motor1 = new CANJaguar(3);
            //TODO: Add to RobotMap
            motor1.changeControlMode(CANJaguar.ControlMode.kPosition);
            motor1.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
            motor1.setPID(2.0, 0, 0);
            // motor1.configEncoderCodesPerRev(4096);
            motor1.configPotentiometerTurns(1);
            LiveWindow.addActuator("Kicker", "PID", new CANJaguarPIDActuator(motor1));
            LiveWindow.addSensor("Kicker", "Position", new CANJaguarPositionSensor(motor1));
            LiveWindow.addSensor("Kicker", "Speed", new CANJaguarSpeedSensor(motor1));
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
