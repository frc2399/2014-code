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
    // button.whenReleased(new ExampleCommand());
    
   
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(2);
    Joystick driveyStick = new Joystick(3);
    
    ManClaw manClaw = new ManClaw(); 
    ClawCatch clawCatch = new ClawCatch();
    JoystickDrive drive = new JoystickDrive();
    ClawOpen clawOpen = new ClawOpen();
    ClawClose clawClose = new ClawClose();
    ClawPickUp clawPickUp = new ClawPickUp();
     
    public static int clawCatchButtNum = 2; //will be changed 
    
    private final JoystickButton clawCatchButt = new JoystickButton(leftStick, clawCatchButtNum);
    private final JoystickButton clawOpenButt = new JoystickButton(driveyStick, 11);
    private final JoystickButton clawCloseButt = new JoystickButton(driveyStick, 12);
    private final JoystickButton manClawButt = new JoystickButton(driveyStick, 10);
    
    
    public OI(){
            clawCatchButt.whenPressed(clawCatch);
            clawOpenButt.whenPressed(clawOpen);
            clawCloseButt.whenPressed(clawClose);
            manClawButt.toggleWhenPressed(manClaw);
    }
      

    Button strafeButt = new JoystickButton(driveyStick, 3);//TODO- get actual button number
    //Button fieldOrientedButt = new JoystickButton(driveyStick, 11); // added button for field oriented drive
    
    public boolean shouldFOD = false;
    
    
    public double getForwardSpeed(){
        return driveyStick.getRawAxis(2);
    }
    
    public double getSideSpeed(){
        return driveyStick.getRawAxis(1);
    }
    
    public double getDriveyStickX(){
        return driveyStick.getX();
    }
    
    public double getDriveyStickY(){
        return driveyStick.getY();
    }
    
    public double getTwistSpeed(){
        return driveyStick.getRawAxis(3); 
    }

    public double getDriveyStickThrottle(){
        return driveyStick.getRawAxis(4);
    }
    
    public double getLeftStickThrottle(){
        return leftStick.getRawAxis(3);
    }
    
    public double getLeftStickY(){
        return leftStick.getY();
    }
    
    public double getLeftStickX(){
        return leftStick.getX();
    }
    
    public double getRightStickY(){
        return rightStick.getY();
    }
    
    public double getRightStickX(){
        return rightStick.getX();
    }
    
    public double getRightStickThrottle(){
        return rightStick.getRawAxis(3);
    }
    
    public boolean shouldStrafe() {
      if (strafeButt.get()==true)  {
          return true;
         
      } else {
          return false;
      }
    }
    
    /*
    public boolean changeFOD(){
        shouldFOD = !shouldFOD;
        return shouldFOD;
    }
    */
}
