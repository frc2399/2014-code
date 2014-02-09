/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 * @author jallen
 */
public class Vision {

    private static final NetworkTable table = NetworkTable.getTable("Vision");
    
    public static void initialize() {
        // Initialize default values
        
        table.putBoolean("hot", false);
        table.putNumber("shutdown", 0);
        table.putNumber("distance", Double.NaN);
    }
    
    public static boolean isHot() {
        return table.getBoolean("hot");
    }

    public static double getDistance() {
        return table.getNumber("distance");
    }
    
    public static void shutdown() {
        table.putNumber("shutdown", 1);
    }
}
