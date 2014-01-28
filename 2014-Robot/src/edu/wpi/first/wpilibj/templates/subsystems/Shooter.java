/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Lauren
 */
public class Shooter {
    //will probably have sensors for motor force and possibly for kicker height 
    
    public CANJaguar motor1;
    public CANJaguar motor2;
    
    Encoder testEncoder = new Encoder(2,3); //CHANGE NUMBERS NOT CORRECT

    
    
    public Shooter(){
        
        try{
        motor1 = new CANJaguar(RobotMap.shootmotor1);
        motor2 = new CANJaguar(RobotMap.shootmotor2);
        
        }catch(Exception e){
            System.out.println(e);
            System.out.println(motor1);
            System.out.println(motor2);
        }
    }
    
    
    public void initDefaultCommand() {
       
    }
}
