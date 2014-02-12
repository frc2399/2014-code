/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.parsing.IUtility;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author jallen
 */
public class CANJaguarPIDActuator implements LiveWindowSendable, IUtility {

    private double m_P;			// factor for "proportional" control
    private double m_I;			// factor for "integral" control
    private double m_D;			// factor for "derivative" control
    // private double m_F;                 // factor for feedforward term
    private boolean m_enabled = false; 			//is the pid controller enabled
    private double m_setpoint = 0.0;
    private CANJaguar m_jag;

    public CANJaguarPIDActuator(CANJaguar jag) {
        m_jag = jag;
    }

    private void readValues() {
        try {
            m_P = m_jag.getP();
            m_I = m_jag.getI();
            m_D = m_jag.getD();
            m_setpoint = m_jag.getX();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

    }

    private void writeValues() {
        try {
            m_jag.setPID(m_P, m_I, m_D);
            m_jag.setX(m_setpoint);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void setPID(double p, double i, double d) {
        m_P = p;
        m_I = i;
        m_D = d;
        writeValues();

        if (table != null) {
            table.putNumber("p", p);
            table.putNumber("i", i);
            table.putNumber("d", d);
        }
    }

    public synchronized void setSetpoint(double setpoint) {
        m_setpoint = setpoint;

        writeValues();

        // check to see if we exceed max or min by reading values back
        readValues();

        if (table != null) {
            table.putNumber("setpoint", m_setpoint);
        }
    }

    private ITableListener listener = new ITableListener() {
        public void valueChanged(ITable table, String key, Object value, boolean isNew) {
            if (key.equals("p") || key.equals("i") || key.equals("d") || key.equals("f")) {
                if (m_P != table.getNumber("p", 0.0) || m_I != table.getNumber("i", 0.0)
                        || m_D != table.getNumber("d", 0.0)) { // || m_F != table.getNumber("f", 0.0)) {
                    setPID(table.getNumber("p", 0.0), table.getNumber("i", 0.0), table.getNumber("d", 0.0)); //, table.getNumber("f", 0.0));
                }
            } else if (key.equals("setpoint")) {
                if (m_setpoint != ((Double) value).doubleValue()) {
                    setSetpoint(((Double) value).doubleValue());
                }
            } else if (key.equals("enabled")) {
                if (m_enabled != ((Boolean) value).booleanValue()) {
                    if (((Boolean) value).booleanValue()) {
                        enable();
                    } else {
                        disable();
                    }
                }
            }
        }
    };
    private ITable table;

    public void initTable(ITable table) {
        readValues();
        if (this.table != null) {
            this.table.removeTableListener(listener);
        }
        this.table = table;
        if (table != null) {
            table.putNumber("p", m_P);
            table.putNumber("i", m_I);
            table.putNumber("d", m_D);
            // table.putNumber("f", getF());
            table.putNumber("setpoint", m_setpoint);
            table.putBoolean("enabled", m_enabled);
            table.addTableListener(listener, false);
        }
    }

    public ITable getTable() {
        return table;
    }

    public String getSmartDashboardType() {
        // return "CANJaguarPIDActuator";
        return "PIDController";
    }

    public synchronized void enable() {
        m_enabled = true;
        try {
            m_jag.enableControl();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
            m_enabled = false;
        }

        if (table != null) {
            table.putBoolean("enabled", m_enabled);
        }
    }

    public synchronized void disable() {
        // m_pidOutput.pidWrite(0);
        m_enabled = false;
        try {
            m_jag.disableControl();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
            m_enabled = true;
        }

        if (table != null) {
            table.putBoolean("enabled", m_enabled);
        }
    }

    public void updateTable() {
    }

    public void startLiveWindowMode() {
        disable();
    }

    public void stopLiveWindowMode() {
    }

}
