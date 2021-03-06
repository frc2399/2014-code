/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Ultrasonic;

/**
 * This class automatically moves the robot to the distance specified in the
 * constructor using vision code
 *
 * @author jallen
 */
public class AutoPosition extends CommandBase {

    final double TOLERANCE = 5.0; // acceptable tolerance, in inches TODO 

    double targetDistance; //distance to move robot to 

    /**
     * @param desiredDistance the distance from the target that the robot will
     * be moved to
     */
    public AutoPosition(double desiredDistance) {
        requires(driveTrain);
        targetDistance = desiredDistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run Execute gets the
     * distance from the vision code and moves the robot forward or backwards
     * accordingly
     */
    protected void execute() {
        double travelDistance;
        // use Vision.getDistance() to retrieve the current distance in inches
        travelDistance = (Ultrasonic.getDistance() - targetDistance);
        // TODO: what if we overshoot?
        if (travelDistance > 0) {
            double dist = -power((travelDistance/60), 1.5) * .8;
            driveTrain.drive.mecanumDrive_Cartesian(0, dist, 0, 0);
        } else{
            driveTrain.drive.mecanumDrive_Cartesian(0, 0, 0, 0);
        }
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return true if the robot is at the desired distance or within alloted
     * tolerance
     */
    protected boolean isFinished() {
        if (Ultrasonic.getDistance() < (targetDistance + TOLERANCE) && Ultrasonic.getDistance() > (targetDistance - TOLERANCE)) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private double calcSpeed(){
        double distance = Ultrasonic.getDistance();
        double speed = (distance/60)*(distance/60);
        return speed;
    }
    
    private double power(final double a, final double b){
        final int x = (int) (Double.doubleToLongBits(a) >> 32);
        final int y = (int) (b*(x- 1072632447) + 1072632447);
        double dist = Double.longBitsToDouble(((long) y) << 32);
        if( dist > 0){
            return dist;
        }
        return 0;
    }
}
