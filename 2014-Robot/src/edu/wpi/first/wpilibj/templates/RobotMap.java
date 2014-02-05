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
    
    public static final int clawMotor = 5;  //change
    public static final int clawEncoderA = 9; //change
    public static final int clawEncoderB = 10; //change
    
    public static final int clawLimitSwitchTop = 4; //change
    public static final int clawLimitSwitchBottom = 4; //change

    
    public static final int manClawButt = 7;

    public static final int shootMotor1 = 11;
    public static final int shootMotor2 = 12;
}
