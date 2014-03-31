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

       public static final int driveLeftFront = 9;
    public static final int driveLeftRear = 8;
    public static final int driveRightFront = 6;
    public static final int driveRightRear = 7;

    //NOT RIGHT NUMBERS!!!!!!!!!!1
    public static final int gyro = 1;

    //claw Pitch ports
    public static final int clawPitchMotor = 4;  //otto value

    //kicker ports 
    public static final int shootMotor1 = 10;
    public static final int shootMotor2 = 2;

    //shooter wheel
    //public static final int shooterWheelMotor = 9;
    
    //solenoid port
    public static int grabberSolenoid1= 1;
    public static int grabberSolenoid2 = 2;
    
    //compressor spike port (compressor output port)
    public static int spikeRelay = 1;
    
    //compressor pressure switch (compressor input port)
    public static int pressureSwitch = 2;


}
