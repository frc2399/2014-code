/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Amanda Merritt and Lauren Egts
 *
 */
public class ResetKicker1 extends CommandBase {

    Timer timer = new Timer();

    public ResetKicker1() {
        requires(kicker);

    }

    protected void initialize() {
        timer.reset();
        timer.start();

    }

    protected void execute() {
        //kicker.setSetpoint(kicker.topPoint);
        kicker.setPosition(.1); //change this TODO
        //.1 is at the bottom
    }

    protected boolean isFinished() {
        if (timer.get() >= .5) {
            return true;
        }
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }

}
