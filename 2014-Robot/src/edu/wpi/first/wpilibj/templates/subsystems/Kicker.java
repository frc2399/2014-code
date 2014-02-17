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
    
    //TODO do we want this to not be a pidsubsystem 
    public CANJaguar motor1;
    public CANJaguar motor2;
    //TODO add 3rd motor 

    public static final double topPoint = 4;
    
    public Kicker(){
        try{
            motor1 = new CANJaguar(RobotMap.shootMotor1);
            motor2 = new CANJaguar(RobotMap.shootMotor2);
            motor2.changeControlMode(ControlMode.kVoltage);
        }catch(Exception e){
            System.out.println(e);
            System.out.println(motor1);
            System.out.println(motor2);
        }
    }
    
    public void initDefaultCommand() {
       //TODO add default command 
    }
    
     private void setSpeedControl() throws CANTimeoutException {
        if (motor1.getControlMode() != CANJaguar.ControlMode.kSpeed) {
            motor1.changeControlMode(CANJaguar.ControlMode.kSpeed);
            motor1.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
            motor1.configPotentiometerTurns(10);
            motor1.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            // TODO: add PID constants
            motor1.enableControl();
        }
    }

    private void setPositionControl() throws CANTimeoutException {
        if (motor1.getControlMode() != CANJaguar.ControlMode.kPosition) {
            motor1.changeControlMode(CANJaguar.ControlMode.kPosition);
            motor1.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
            motor1.configPotentiometerTurns(10);
            motor1.configNeutralMode(CANJaguar.NeutralMode.kBrake);
            // TODO: add PID constants
            motor1.setPID(2, 0, 0);
            motor1.enableControl();
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
    
}
