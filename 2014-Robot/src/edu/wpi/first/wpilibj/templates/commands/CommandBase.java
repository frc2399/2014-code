package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.Vision;
import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Lauren Dierker
 */
public abstract class CommandBase extends Command {

    // Create a single static instance of all of your subsystems
    public static OI oi;
    public static DriveTrain driveTrain;
    public static Shooter shooter;
    public static ClawPitch clawPitch;
    public static Grabber grabber;

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.

        driveTrain = new DriveTrain();
        //shooter = new Shooter();
        clawPitch = new ClawPitch();
        grabber = new Grabber();

        Vision.initialize();

        //leave oi at the bottom and apart from the other initialized things
        //if it is initialized before the subsytems, it throws some null pointer exceptions
        //those are not fun
        //please leave it here
        oi = new OI();

        SmartDashboard.putData("DriveTrain", driveTrain);
        SmartDashboard.putData("ClawPitch", clawPitch);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
