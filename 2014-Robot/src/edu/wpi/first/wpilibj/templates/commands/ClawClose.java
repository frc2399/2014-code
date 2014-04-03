/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class closes the claw using limit switches as reference for position The
 * current speed is set at .25, check this to make sure it is the best fit
 *
 * @author Lauren
 */
public class ClawClose extends CommandBase {
    Timer timer;

    public ClawClose() {
        requires(grabber);
        timer = new Timer();
    }

    protected void initialize() {
       timer.reset();
       timer.start();

    }

    /**
     * Called repeatedly when this Command is scheduled to run close claw
     */
    protected void execute() {
     grabber.close();

    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return true if limit switch has been hit
     */
    protected boolean isFinished() {
        if (timer.get() > .5){
            return true;
        }
      return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
