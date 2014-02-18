/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CANJaguar.ControlMode;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.CANJaguarPositionSensor;
import edu.wpi.first.wpilibj.templates.CANJaguarPIDActuator;
import edu.wpi.first.wpilibj.templates.CANJaguarSpeedSensor;

/**
 *
 * @author Lauren
 * 
 * This class if for our Kicker. The kicker uses two SIM motors, controlled by Jaguars
 * This class is controlled by a PID using a magnetic encoder
 * 
 */
public class Kicker extends Subsystem{
    //will probably have sensors for motor force and possibly for kicker height 
    
    public CANJaguar motor1;
    public CANJaguar motor2;
    //TODO add 3rd motor 

    public static final double topPoint = 4;
    
    public Kicker(){
        try{
            motor1 = new CANJaguar(RobotMap.shootMotor1);
            setPositionControl();
            motor1.disableControl();
            motor2 = new CANJaguar(RobotMap.shootMotor2);
            motor2.changeControlMode(ControlMode.kVoltage);
            motor1.setPID(2.0, 0.0, 0.0);
            LiveWindow.addActuator("Kicker", "CanJaguarPID", new CANJaguarPIDActuator(motor1));
            LiveWindow.addSensor("Kicker", "PIDPosition", new CANJaguarPositionSensor(motor1));
            LiveWindow.addSensor("Kicker", "PIDSpeed", new CANJaguarSpeedSensor(motor1));
        }catch(Exception e){
            System.out.println(e);
            System.out.println(motor1);
            System.out.println(motor2);
        }
    }
    
    public void initDefaultCommand() {
    }
    
     private void setSpeedControl() throws CANTimeoutException {
        if (motor1.getControlMode() != CANJaguar.ControlMode.kSpeed) {
            motor1.changeControlMode(CANJaguar.ControlMode.kSpeed);
            motor1.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
            motor1.configEncoderCodesPerRev(4096);
            motor1.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            motor1.setPID(2, 0, 0);
            // TODO: add PID constants
            motor1.enableControl();
        }
    }

    private void setPositionControl() throws CANTimeoutException {
        if (motor1.getControlMode() != CANJaguar.ControlMode.kPosition) {
            motor1.changeControlMode(CANJaguar.ControlMode.kPosition);
            motor1.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
            motor1.configPotentiometerTurns(1);
            motor1.configNeutralMode(CANJaguar.NeutralMode.kBrake);
            // TODO: add PID constants
            motor1.setPID(-220, -0.007, -0.2);
            motor1.enableControl();
            // values only good for going from bottom to top (around the back)
        }
    }
    
    private void setVoltageControl() throws CANTimeoutException {
        if(motor1.getControlMode() != CANJaguar.ControlMode.kVoltage){
            motor1.changeControlMode(CANJaguar.ControlMode.kVoltage);
            motor2.changeControlMode(CANJaguar.ControlMode.kVoltage);
            motor1.enableControl();
            motor2.enableControl();
        }
    }
    
     public double getPosition() {
        try {
            setPositionControl();
            return motor1.getPosition();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        } finally {
            return 0;
        }
    }

    public double getSpeed() {
        try {
            setSpeedControl();
            return motor1.getSpeed();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        } finally {
            return 0;
        }
    }

    public void setSpeed(double speed) {
        try {
            setSpeedControl();
            motor1.setX(speed);
            motor2.setX(motor1.getOutputVoltage());
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }

    public void setPosition(double position) {
        try {
            setPositionControl();
            motor1.setX(position);
            motor2.setX(motor1.getOutputVoltage());
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }
    
    public void setVoltage(double voltage){
        try {
            setVoltageControl();
            motor1.setX(voltage);
            motor2.setX(voltage);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void stop(){
        try {
            motor1.disableControl();
            motor2.disableControl();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
}