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
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * This class control the up and down movement, i.e. the pitch of the claw
 * subsystem It uses an encoder and PID to control movement
 *
 * @author Lauren
 */
public class ClawPitch extends PIDSubsystem {

    public CANJaguar clawPitchMotor;
    public final double maxPosition;
    public final double minPosition;

    //AnalogChannel clawPitchEncoder = new AnalogChannel(RobotMap.clawPitchEncoder);//fix this port num

    public ClawPitch() {
        super(0, 0, 0);
        maxPosition = 0;
        minPosition = 0;
        try {
            clawPitchMotor = new CANJaguar(RobotMap.clawPitchMotor);
            
            clawPitchMotor.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
            clawPitchMotor.configPotentiometerTurns(10);
            
            this.setAbsoluteTolerance(0.05);
            
            System.out.println("Adding actuators for ClawPitch to LiveWIndow");
            LiveWindow.addActuator("ClawPitch", "Motor", this.clawPitchMotor);
            LiveWindow.addActuator("ClawPitch", "PID Controller", this.getPIDController());
            //LiveWindow.addSensor("ClawPitch", "Encoder", this.clawPitchEncoder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ManClaw());
    }
    /*
    public void setSpeed(double speed) {
        try {
            clawPitchMotor.setX(output);
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }*/

    protected double returnPIDInput() {
        try {
            return clawPitchMotor.getPosition();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        } finally {
            return 0;
        }
    }

    /*
     * This method uses the setX method in the position control mode 
     * @param the position to move claw to 
     */
    protected void usePIDOutput(double output) {
        try {
            clawPitchMotor.setX(output);
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }

}
