/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 * @author Lauren
 */
public class DriveTrain2 {
  
    public CANJaguar leftFront;
    public CANJaguar leftBack;
    public CANJaguar rightFront;
    public CANJaguar rightBack;
    
    public RobotDrive drive;
    
    public DriveTrain2(){
    
        //leftFront = new CANJaguar(4);
        //leftBack = new CANJaguar(247);
        //rightFront = new CANJaguar(7);
        //rightBack = new CANJaguar(347);
        
        
        drive = new RobotDrive(leftFront, leftBack, rightFront, rightBack);
        
      
        
}
    
            
    public void initDefaultCommand() {
       
    }
    
    public void getTestEncoder() {
    }
    
    public void startTestEncoder() {
    }
    
    public void getGyroAngle(){
    }
    
    public void resetGyro(){
    }
}

