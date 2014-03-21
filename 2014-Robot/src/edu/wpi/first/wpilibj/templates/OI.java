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
    
    Button clawCatchButt = new JoystickButton(extremeStick, 7);
    public Button clawOpenButt = new JoystickButton(extremeStick, 6);
    public Button clawCloseButt = new JoystickButton(extremeStick, 4);
    Button manButt = new JoystickButton(extremeStick, 10); //claw
    Button setKickPositionButt = new JoystickButton(extremeStick, 8);

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
    Button shutdownButt = new JoystickButton(rightStick, 10);
    
    //Button manGrabberOpenButt = new JoystickButton(extremeStick, 5);
    //Button manGrabberCloseButt = new JoystickButton(extremeStick, 3);
    
    //manGrabber manGrabberOpen = new manGrabber(.8, manGrabberOpenButt);
   // manGrabber manGrabberClose = new manGrabber(-.8, manGrabberCloseButt);

    // kick butts
    Button kickButt = new JoystickButton(extremeStick, 9);//NOT THE RIGHT NUMBER!!!!!!!!!
    Button resetKickerButt = new JoystickButton(extremeStick, 2); //this will be in EXTREMESTICK
    Button fireButt = new JoystickButton(extremeStick, 1); //this will be ExtremeStick
    Button manKickerForwardButt = new JoystickButton(extremeStick, 11); //TODO actual values
    Button manKickerBackwardButt = new JoystickButton(extremeStick, 12); //TODO actual values

    //comand objects
    AutoPosition autoPosition = new AutoPosition(113); //not final number
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
    SetClawPitch setKickPosition = new SetClawPitch( 0.295); //this is kick value
    //man kicker buttons are down there 
    PiShutdown piShutdown = new PiShutdown();
    ResetKickerGroup resetKicker = new ResetKickerGroup();    
    SetDirection setDirectionLeft = new SetDirection(270);
    SetDirection setDirectionRight = new SetDirection(90);
    SetDirection setDirectionFront = new SetDirection(0);
    SetDirection setDirectionBack = new SetDirection(180);

    //claw buttons
   
    
    ManKicker manKickerForward = new ManKicker(3.5, manKickerForwardButt);
    ManKicker manKickerBackward = new ManKicker(-4, manKickerBackwardButt);
    
    public OI() {

        //driving buttons
        resetGyroButt.whenPressed(gyroReset);
        robotOrientButt.whenPressed(robotDrive);
        robotOrientButt.cancelWhenPressed(fieldDrive);
        fieldOrientButt.whenPressed(fieldDrive);
        fieldOrientButt.cancelWhenPressed(robotDrive);
        //turnLeftButt.whenPressed(setDirectionLeft);
        //turnRightButt.whenPressed(setDirectionRight);
        //turnBackButt.whenPressed(setDirectionBack);
        //turnFrontButt.whenPressed(setDirectionFront);
        autoPositionButt.whenPressed(autoPosition);

        //vision buttons
        shutdownButt.whenPressed(piShutdown);

        //claw buttons
        clawCatchButt.whenPressed(clawCatch);
        clawOpenButt.whenPressed(clawOpen);
        clawCloseButt.whenPressed(clawClose);
        manButt.toggleWhenPressed(manClaw);
        setKickPositionButt.whenPressed(setKickPosition);
        
        //manGrabberOpenButt.whenPressed(manGrabberOpen);
        //manGrabberCloseButt.whenPressed(manGrabberClose);
        

        //kicker buttons
        resetKickerButt.whenPressed(resetKicker);
        fireButt.whenPressed(fire);
        manKickerForwardButt.whenPressed(manKickerForward);
        manKickerBackwardButt.whenPressed(manKickerBackward);
        kickButt.whenPressed(kick);
        
        
        SmartDashboard.putData("Reset Kicker", resetKicker);
        SmartDashboard.putData("Fire", fire);
        SmartDashboard.putNumber("kickVoltage", 8.0);
        SmartDashboard.putData("Kick", kick);
    }

    public double getClawSpeed() {
        return -extremeStick.getY();
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
