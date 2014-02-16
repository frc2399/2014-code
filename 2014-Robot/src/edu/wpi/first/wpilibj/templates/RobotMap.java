/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * port numbers for motors and sensors 
 */
public class RobotMap {
    
    //driveTrain motors
    //NOT RIGHT NUMBERS!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static final int driveLeftFront = 7;
    public static final int driveLeftRear = 8;
    public static final int driveRightFront = 6;
    public static final int driveRightRear = 5;
    //NOT RIGHT NUMBERS!!!!!!!
    
    //NOT RIGHT NUMBERS!!!!!!!!!!
    public static final int testEncoderA = 1;
    public static final int testEncoderB = 2;
    public static final int gyro = 1;
    
    //claw Pitch ports
    public static final int clawPitchMotor = 3;  //otto value
    public static final int clawPitchEncoder = 3; //otto value

    //grabber ports
    public static final int clawLimitSwitchOpenLimit = 4; //change
    public static final int clawLimitSwitchCloseLimit= 5; //change
    public static final int grabMotor = 7; //change
    
    //kicker ports 
    public static final int shootMotor1 = 11;
    public static final int shootMotor2 = 12;
    
    //shooter wheel
    public static final int shooterWheelMotor = 9;
    
}
