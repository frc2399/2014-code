/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author Lauren
 */
public class PIDResetKicker extends CommandBase{
    
    //set PID in CANJag
    //position reference in CANJag
    //config/disable soft position limits in CANJag
    //get position 
    //setX -- in position mode in rotations

    public PIDResetKicker() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(kicker);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        try{
            kicker.motor1.enableControl();
            kicker.motor2.enableControl();
            
            //this sets the P, I, and D values 
            kicker.motor1.setPID(0.0, 0.0, 0.0);//NOT CORRECT NUMBERS 
            kicker.motor2.setPID(0.0, 0.0, 0.0);//NOT CORRECT NUMBERS
            
        } catch( CANTimeoutException e){
            System.out.println(e);
            System.out.println(kicker.motor1);
            System.out.println(kicker.motor2);
        }

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try{
            kicker.motor1.setX(0); //sets position 
            kicker.motor2.setX(0); //sets position 

        } catch( CANTimeoutException e){
            System.out.println(e);
            System.out.println(kicker.motor1);
            System.out.println(kicker.motor2);
        }
       
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return pitch.onTarget();
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}
