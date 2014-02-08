/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
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
public class Kicker extends PIDSubsystem{
    //will probably have sensors for motor force and possibly for kicker height 
    
    public CANJaguar motor1;
    public CANJaguar motor2;
    
    
    public Kicker(){
        
        super("Kicker", 0, 0, 0); //use these to set P, I, and Ds
        
        try{
        motor1 = new CANJaguar(RobotMap.shootMotor1);
        motor2 = new CANJaguar(RobotMap.shootMotor2);
        
        }catch(Exception e){
            System.out.println(e);
            System.out.println(motor1);
            System.out.println(motor2);
        }
    }
    
    public void initDefaultCommand() {
       
    }
    
    public void setSpeed(double speed) {
        
        try{
            motor1.changeControlMode( CANJaguar.ControlMode.kSpeed );
            motor2.changeControlMode( CANJaguar.ControlMode.kSpeed );
            
            motor1.enableControl();
            motor2.enableControl();

            motor1.setX(speed); //numbers might change
            motor2.setX(speed); //numbers might change
        }
        
        catch(CANTimeoutException e){
            System.out.println(e);
            System.out.println(motor1);
            System.out.println(motor2);
        }
    }
    
    protected double returnPIDInput(){
        return channel.getAverageVoltage();
    }
    
    public void usePIDOutput(double output){
        try{
            motor1.changeControlMode( CANJaguar.ControlMode.kPosition );
            motor2.changeControlMode( CANJaguar.ControlMode.kPosition );
            
            motor1.enableControl();
            motor2.enableControl();
            //setX is the same as pidWrite (depricated)
            motor1.setX(output);
            motor2.setX(output);
        
        } catch(CANTimeoutException e){
            System.out.println(e);
            System.out.println(motor1);
            System.out.println(motor2);
        }
    }
}
