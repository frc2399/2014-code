package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.FieldOrientedDrive;

/**
 *
 * @author Lauren Dierker
 */
public class DriveTrain extends Subsystem {

    public CANJaguar leftFront;
    public CANJaguar leftRear;
    public CANJaguar rightFront;
    public CANJaguar rightRear;

    public Gyro gyro = new Gyro(RobotMap.gyro);

    public RobotDrive drive;

    public DriveTrain() {

        try {

            leftFront = new CANJaguar(RobotMap.driveLeftFront);
            leftRear = new CANJaguar(RobotMap.driveLeftRear);
            rightFront = new CANJaguar(RobotMap.driveRightFront);
            rightRear = new CANJaguar(RobotMap.driveRightRear);

            drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);

            // drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
            // drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
            drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
            drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

            System.out.println("Adding actuators for DriveTrain to LiveWIndow");
            LiveWindow.addActuator("DriveTrain", "leftFront", leftFront);
            LiveWindow.addActuator("DriveTrain", "leftRear", leftRear);
            LiveWindow.addActuator("DriveTrain", "rightFront", rightFront);
            LiveWindow.addActuator("DriveTrain", "rightRear", rightRear);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initDefaultCommand() {
        this.setDefaultCommand(new FieldOrientedDrive());

    }

    public double getGyroAngle() {
        SmartDashboard.putNumber("Gyro", -gyro.getAngle());
        return -gyro.getAngle();
    }

    public void resetGyro() {
        gyro.reset();
    }
}
