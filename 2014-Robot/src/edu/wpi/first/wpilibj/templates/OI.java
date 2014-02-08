/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 *
 * class of buttons, button functions, and command objects
 */
public class OI {
     //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());\
    
    Joystick rightStick = new Joystick(1);
    Joystick leftStick = new Joystick(2);
    Joystick extremeStick = new Joystick(3);

    ManClaw manClaw = new ManClaw();
    ClawCatch clawCatch = new ClawCatch();
    JoystickDrive drive = new JoystickDrive();
    ClawOpen clawOpen = new ClawOpen();
    ClawClose clawClose = new ClawClose();
    ClawPickUp clawPickUp = new ClawPickUp();
    AutoPosition autoPosition = new AutoPosition(72); //not final number
    Kick kick = new Kick();
    ResetKicker resetKicker = new ResetKicker();

     
    public static int clawCatchButtNum = 2; //will be changed 
    
    private final JoystickButton clawCatchButt = new JoystickButton(leftStick, clawCatchButtNum);
    private final JoystickButton clawOpenButt = new JoystickButton(extremeStick, 11);
    private final JoystickButton clawCloseButt = new JoystickButton(extremeStick, 12);
    private final JoystickButton manButt = new JoystickButton(extremeStick, 10);

    JoystickDrive robotDrive = new JoystickDrive();
    FieldOrientedDrive fieldDrive = new FieldOrientedDrive();
    GyroReset gyroReset = new GyroReset();
    SetDirection setDirectionLeft = new SetDirection(270);
    SetDirection setDirectionRight = new SetDirection(90);
    SetDirection setDirectionFront = new SetDirection(0);
    SetDirection setDirectionBack = new SetDirection(180);
    PiShutdown piShutdown = new PiShutdown();

    Button strafeButt = new JoystickButton(leftStick, 3);
    Button kickButt = new JoystickButton(extremeStick, 4);//NOT THE RIGHT NUMBER!!!!!!!!!
    Button resetKickerButt = new JoystickButton(extremeStick, 2); //this will be in EXTREMESTICK

    Button turnLeftButt = new JoystickButton(rightStick, 4);
    Button turnRightButt = new JoystickButton(rightStick, 5);
    Button turnBackButt = new JoystickButton(rightStick, 2);
    Button turnFrontButt = new JoystickButton(rightStick, 3);

    Button fieldOrientButt = new JoystickButton(leftStick, 4);
    Button robotOrientButt = new JoystickButton(leftStick, 5);
    Button resetGyroButt = new JoystickButton(leftStick, 2);
    Button autoPositionButt = new JoystickButton (extremeStick, 9);
   
    
    Button shutdownButt = new JoystickButton(rightStick, 6);

    public OI() {

        resetGyroButt.whenPressed(gyroReset);

        robotOrientButt.whenPressed(robotDrive);
        robotOrientButt.cancelWhenPressed(fieldDrive);
        fieldOrientButt.whenPressed(fieldDrive);
        fieldOrientButt.cancelWhenPressed(robotDrive);

        turnLeftButt.whenPressed(setDirectionLeft);
        turnRightButt.whenPressed(setDirectionRight);
        turnBackButt.whenPressed(setDirectionBack);
        turnFrontButt.whenPressed(setDirectionFront);

        shutdownButt.whenPressed(piShutdown);
        clawCatchButt.whenPressed(clawCatch);
        clawOpenButt.whenPressed(clawOpen);
        clawCloseButt.whenPressed(clawClose);
        manButt.toggleWhenPressed(manClaw);
        
        autoPositionButt.whenPressed(autoPosition);
        
        kickButt.whenPressed(kick);//lauren the Elder will fix this later
        resetKickerButt.whenPressed(resetKicker);
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
