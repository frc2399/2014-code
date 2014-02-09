/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.commands.ManClaw;
import edu.wpi.first.wpilibj.*;

/**
 *
 * @author Lauren
 */
public class Grabber extends Subsystem{
    
    public CANJaguar grabMotor; 
    
    //Encoder testEncoder = new Encoder(RobotMap.clawEncoderA, RobotMap.clawEncoderB);
    //the encoder will most likley be plugged into the jag; therefore it does not need to be constructed
    //finalize with the mechies
     public DigitalInput clawLimitSwitchOpenLimit = new DigitalInput(RobotMap.clawLimitSwitchOpenLimit);
     public DigitalInput clawLimitSwitchCloseLimit = new DigitalInput(RobotMap.clawLimitSwitchCloseLimit);
         
    public Grabber(){
        try{
            grabMotor = new CANJaguar(RobotMap.grabMotor);
            
        }catch(Exception e){
            System.out.println(e);
            System.out.println(grabMotor);
        }
        
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ManClaw());
       
    }
    
    public void setSpeed(double speed){
        try{
            grabMotor.setX(speed);
        }
        catch( CANTimeoutException e){
        }
    }
    
}
    