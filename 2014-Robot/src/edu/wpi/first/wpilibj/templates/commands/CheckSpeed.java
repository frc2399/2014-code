/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Arielle
 */
public class CheckSpeed extends CommandBase {

    double desiredSpeed;
    Timer timer;

    public CheckSpeed(double desiredSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // requires(shooterWheel);
        this.desiredSpeed = desiredSpeed;
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
        timer.start();
        //System.out.println("Reset Timer");
        // shooterWheel.enable();
        // shooterWheel.setSpeed(desiredSpeed);
        //System.out.println("Speed Set");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //System.out.println("Speed " + shooterWheel.getSpeed() + " Time " + timer.get());
        double currentSpeed = 0;
        // = shooterWheel.getSpeed();
        if (currentSpeed >= desiredSpeed) {
            timer.stop();
            System.out.println("Time = " + timer.get());
            SmartDashboard.putNumber("Time", timer.get());
            return true;
        }
        return false;

    }

    // Called once after isFinished returns true
    protected void end() {
        // shooterWheel.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
