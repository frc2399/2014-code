/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.can.CANTimeoutException;



/**
 *
 * @author Lauren
 */
public class Claw extends Subsystem{
    
    public CANJaguar clawMotor; 
    
    //Encoder testEncoder = new Encoder(RobotMap.clawEncoderA, RobotMap.clawEncoderB);
    //the encoder will most likley be plugged into the jag; therefore it does not need to be constructed
    //finalize with the mechies

    
    public Claw(){
        try{
            clawMotor = new CANJaguar(RobotMap.clawMotor);
            
        }catch(Exception e){
            System.out.println(e);
            System.out.println(clawMotor);
        }
        
    }
    
    public void initDefaultCommand() {
       
    }
    
    public void setSpeed(double speed){
        try{
            clawMotor.setX(speed);
        }
        catch( CANTimeoutException e){
        }
    }
    
}
    
