/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.commands.ManClaw;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.CANJaguarPositionSensor;
import edu.wpi.first.wpilibj.templates.CANJaguarPIDActuator;

/**
 * This class control the up and down movement, i.e. the pitch of the claw
 * subsystem It uses an encoder and PID to control movement
 *
 * @author Lauren
 */
public class ClawPitch extends Subsystem {

    public CANJaguar clawPitchMotor;
    // encoder is connected through the CAN
    
    //CANJaguarPIDActuator pidActuator;
    

    public final double maxPosition;
    public final double minPosition;

    //AnalogChannel clawPitchEncoder = new AnalogChannel(RobotMap.clawPitchEncoder);//fix this port num
    public ClawPitch() {
        // super(0, 0, 0);
        maxPosition = 0;
        minPosition = 0;
        try {
            clawPitchMotor = new CANJaguar(RobotMap.clawPitchMotor);
            // pidActuator = new CANJaguarPIDActuator(clawPitchMotor);
            setPositionControl();

            System.out.println("Adding actuators for ClawPitch to LiveWIndow");
            LiveWindow.addActuator("ClawPitch", "CanJaguarPID", new CANJaguarPIDActuator(clawPitchMotor));
            LiveWindow.addSensor("ClawPitch", "CanJaguarEncoder", new CANJaguarPositionSensor(clawPitchMotor));
            // LiveWindow.addActuator("ClawPitch", "Motor", clawPitchMotor);
            //LiveWindow.addActuator("ClawPitch", "PID Controller", getPIDController());
            //LiveWindow.addSensor("ClawPitch", "Encoder", clawPitchEncoder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ManClaw());
    }

    public void setSpeedControl() throws CANTimeoutException {
        if (clawPitchMotor.getControlMode() != CANJaguar.ControlMode.kSpeed) {
            clawPitchMotor.changeControlMode(CANJaguar.ControlMode.kSpeed);
            clawPitchMotor.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
            clawPitchMotor.configPotentiometerTurns(10);
            clawPitchMotor.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            // TODO: add PID constants
            clawPitchMotor.enableControl();
        }
    }

    public void setPositionControl() throws CANTimeoutException {
        if (clawPitchMotor.getControlMode() != CANJaguar.ControlMode.kPosition) {
            clawPitchMotor.changeControlMode(CANJaguar.ControlMode.kPosition);
            clawPitchMotor.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
            clawPitchMotor.configPotentiometerTurns(10);
            clawPitchMotor.configNeutralMode(CANJaguar.NeutralMode.kBrake);
            // TODO: add PID constants
            clawPitchMotor.setPID(2, 0, 0);
            clawPitchMotor.enableControl();
        }
    }

    public double getPosition() {
        try {
            return clawPitchMotor.getPosition();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        } finally {
            return 0;
        }
    }

    public double getSpeed() {
        try {
            return clawPitchMotor.getSpeed();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        } finally {
            return 0;
        }
    }

    public void setSpeed(double speed) {
        try {
            setSpeedControl();
            clawPitchMotor.setX(speed);
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }

    public void setPosition(double position) {
        try {
            setPositionControl();
            clawPitchMotor.setX(position);
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }
    

    /*
     protected double returnPIDInput() {
     try {
     return clawPitchMotor.getPosition();
     } catch (CANTimeoutException ex) {
     ex.printStackTrace();
     } finally {
     return 0;
     }
     }*/

    /*
     * This method uses the setX method in the position control mode 
     * @param the position to move claw to 
     */
//    protected void usePIDOutput(double output) {
//        try {
//            clawPitchMotor.setX(output);
//        } catch (CANTimeoutException e) {
//            e.printStackTrace();
//        }
//    }
}
