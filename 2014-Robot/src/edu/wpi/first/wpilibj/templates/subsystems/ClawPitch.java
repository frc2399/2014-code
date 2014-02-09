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
    
    protected void usePIDOutput(double output){
        try{
            clawPitchMotor.setX(output);
        } catch( CANTimeoutException e){
            System.out.println(e);
            System.out.println(clawPitchMotor);
        }
    }
    
}
    

