/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author lauren
 */
public class Ultrasonic {
    public static AnalogChannel ultrasonicSensor = new AnalogChannel(RobotMap.ultrasonic);
    public static double getDistance() {
<<<<<<< HEAD
    //return ultrasonicSensor.getVoltage() * 1000 / 4.9 / 2.54;  //converts volts to inches for the 300in range sensor
    return ultrasonicSensor.getVoltage() / .02480462;  //converts volts to inches for the 200in range sensor.  Here is the equation we used to get it: .0097656 V/mm * 10 mm/cm * 2.54 cm/in = .02480462
=======
    return ultrasonicSensor.getVoltage() * 1000 / 4.9 / 2.54;  //converts volts to inches
>>>>>>> e40aafa398ef31fda5687051b35618564dc96e54
}
}
