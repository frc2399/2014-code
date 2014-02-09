/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.commands.ManClaw;
import edu.wpi.first.wpilibj.*;
/**
 * This class control the up and down movement, i.e. the pitch of the claw subsystem 
 * It uses an encoder and PID to control movement 
 * 
 * @author Lauren
 */
public class ClawPitch extends PIDSubsystem{
    

    public CANJaguar clawPitchMotor; 
     
    AnalogChannel clawPitchEncoder = new AnalogChannel(RobotMap.clawPitchEncoder);//fix this port num
    
    public ClawPitch(){
        super("ClawPitch",0,0,0);
        try{
            clawPitchMotor = new CANJaguar(RobotMap.clawPitchMotor);
        }catch(Exception e){
            System.out.println(e);
            System.out.println(clawPitchMotor);
        }
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ManClaw());
    }
    
    public void setSpeed(double speed){
        try{
            clawPitchMotor.setX(speed);
        }
        catch( CANTimeoutException e){
        }
    }
    
    protected double returnPIDInput(){
        return clawPitchEncoder.getAverageVoltage();
    }
    
    /*
     * This method uses the setX method in the position control mode 
     * @param the position to move claw to 
     */
    protected void usePIDOutput(double output){
        try{
            clawPitchMotor.setX(output);
        } catch( CANTimeoutException e){
            System.out.println(e);
            System.out.println(clawPitchMotor);
        }
    }
    
}
    

