/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

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

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       
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
