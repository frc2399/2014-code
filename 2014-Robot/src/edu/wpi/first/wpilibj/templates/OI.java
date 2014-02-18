/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 *
 * class of buttons, button functions, and command objects
 */
public class OI {

    Joystick rightStick = new Joystick(1);
    Joystick leftStick = new Joystick(2);
    Joystick extremeStick = new Joystick(3);

    //comand objects
    AutoPosition autoPosition = new AutoPosition(72); //not final number
    ClawCatch clawCatch = new ClawCatch();
    ClawClose clawClose = new ClawClose();
    ClawOpen clawOpen = new ClawOpen();
    ClawPickUp clawPickUp = new ClawPickUp();
    FieldOrientedDrive fieldDrive = new FieldOrientedDrive();
    Fire fire = new Fire();
    GyroReset gyroReset = new GyroReset();
    JoystickDrive drive = new JoystickDrive();
    JoystickDrive robotDrive = new JoystickDrive();
    Kick kick = new Kick();
    ManClaw manClaw = new ManClaw();
    ManKicker manKickerForward = new ManKicker(3.5);
    ManKicker manKickerBackward = new ManKicker(-4);
    PiShutdown piShutdown = new PiShutdown();
    ResetKickerGroup resetKicker = new ResetKickerGroup();    
    SetDirection setDirectionLeft = new SetDirection(270);
    SetDirection setDirectionRight = new SetDirection(90);
    SetDirection setDirectionFront = new SetDirection(0);
    SetDirection setDirectionBack = new SetDirection(180);

    //claw buttons
    Button clawCatchButt = new JoystickButton(leftStick, 2);
    Button clawOpenButt = new JoystickButton(extremeStick, 11);
    Button clawCloseButt = new JoystickButton(extremeStick, 12);
    Button manButt = new JoystickButton(extremeStick, 10);

    //driving buttons
    Button strafeButt = new JoystickButton(leftStick, 3);
    Button turnLeftButt = new JoystickButton(rightStick, 4);
    Button turnRightButt = new JoystickButton(rightStick, 5);
    Button turnBackButt = new JoystickButton(rightStick, 2);
    Button turnFrontButt = new JoystickButton(rightStick, 3);
    Button fieldOrientButt = new JoystickButton(leftStick, 4);
    Button robotOrientButt = new JoystickButton(leftStick, 5);
    Button resetGyroButt = new JoystickButton(leftStick, 2);
    Button autoPositionButt = new JoystickButton(extremeStick, 9);

    //vision buttons
    Button shutdownButt = new JoystickButton(rightStick, 6);

    // kick butts
    Button kickButt = new JoystickButton(extremeStick, 4);//NOT THE RIGHT NUMBER!!!!!!!!!
    Button resetKickerButt = new JoystickButton(extremeStick, 2); //this will be in EXTREMESTICK
    Button fireButt = new JoystickButton(extremeStick, 1); //this will be ExtremeStick
    Button manKickerForwardButt = new JoystickButton(extremeStick, 3); //TODO actual values
    Button manKickerBackwardButt = new JoystickButton(extremeStick, 4); //TODO actual values
    
    public OI() {

        //driving buttons
        resetGyroButt.whenPressed(gyroReset);
        robotOrientButt.whenPressed(robotDrive);
        robotOrientButt.cancelWhenPressed(fieldDrive);
        fieldOrientButt.whenPressed(fieldDrive);
        fieldOrientButt.cancelWhenPressed(robotDrive);
        turnLeftButt.whenPressed(setDirectionLeft);
        turnRightButt.whenPressed(setDirectionRight);
        turnBackButt.whenPressed(setDirectionBack);
        turnFrontButt.whenPressed(setDirectionFront);
        autoPositionButt.whenPressed(autoPosition);

        //vision buttons
        shutdownButt.whenPressed(piShutdown);

        //claw buttons
        clawCatchButt.whenPressed(clawCatch);
        clawOpenButt.whenPressed(clawOpen);
        clawCloseButt.whenPressed(clawClose);
        manButt.toggleWhenPressed(manClaw);

        //kicker buttons
        resetKickerButt.whenPressed(resetKicker);
        fireButt.whenPressed(fire);
        manKickerForwardButt.whenPressed(manKickerForward);
        manKickerBackwardButt.whenPressed(manKickerBackward);
        
        
        SmartDashboard.putData("Reset Kicker", resetKicker);
        SmartDashboard.putData("Fire", fire);
        SmartDashboard.putNumber("kickVoltage", 8.0);
        SmartDashboard.putData("Kick", kick);
    }

    public double getClawSpeed() {
        return extremeStick.getRawAxis(2);
    }

    public double getForwardSpeed() {
        return leftStick.getY();
    }

    public double getSideSpeed() {
        return leftStick.getX();
    }

    public double getTwistSpeed() {
        double x = rightStick.getX();
        if (x > 0) {
            return x * x;
        } else {
            return -(x * x);
        }
    }

    public boolean shouldStrafe() {
        if (strafeButt.get() == true) {
            return true;

        } else {
            return false;
        }
    }

}
