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
    return ultrasonicSensor.getVoltage() * 1000 / 4.9 / 2.54;  //converts volts to inches
}
}
