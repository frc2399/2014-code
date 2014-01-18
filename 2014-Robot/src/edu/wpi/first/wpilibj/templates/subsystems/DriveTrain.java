package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANJaguar;
/**
 *
 * @author Lauren Dierker 
 */
public class DriveTrain extends Subsystem{
    
    public CANJaguar leftFront; 
    public CANJaguar leftRear; 
    public CANJaguar rightFront; 
    public CANJaguar rightRear; 
   
    
    Encoder testEncoder = new Encoder(RobotMap.testEncoderA, RobotMap.testEncoderB);
    public Gyro gyro = new Gyro(RobotMap.gyro);
    
    public RobotDrive drive;

    public DriveTrain(){
        
       try{
                        
        leftFront = new CANJaguar(RobotMap.driveLeftFront);//change these numbers
        leftRear = new CANJaguar(RobotMap.driveLeftRear);
        rightFront = new CANJaguar(RobotMap.driveRightFront);
        rightRear = new CANJaguar(RobotMap.driveRightRear);
        
        drive = new RobotDrive(leftFront, leftRear , rightFront, rightRear);
        
         }catch(Exception e){
            System.out.println(e);
            System.out.println(leftFront);
            System.out.println(leftRear);
            System.out.println(rightFront);
            System.out.println(rightRear);
        }
        
    }
    public void initDefaultCommand() {
       
    }
    
    public double getTestEncoder() {
        return testEncoder.getDistance();
    }
    
    public void startTestEncoder() {
        testEncoder.start();
    }
    
    public double getGyroAngle(){
        return gyro.getAngle();
    }
    
    public void resetGyro(){
        gyro.reset();
    }
}

