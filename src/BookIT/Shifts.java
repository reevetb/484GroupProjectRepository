/*
Author: Kyle Porter - D.M.O.
Date: 7/5/17
Assignment: CIS 484 Group Project 
Purpose: Shift entity class to keep track of employee shifts
 */
package BookIT;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author KP
 */
public class Shifts {
    private int instanceID;
    private Date workDate;
    private Time clockIn;
    private Time clockOut;
    private double hours;
    private double otHours;
    
    public static int shiftCount = 0;
    
    // constructor
    public Shifts(Date workDate, Time clockIn)
    {
        this.workDate = workDate;
        this.clockIn = clockIn;
        this.instanceID = shiftCount++;
    }
    
    // getters & setters
    public int getInstanceID()
    {
        return this.instanceID;
    }
    
    public void setInstanceID(int ID)
    {
        this.instanceID = ID;
    }
    
    public Date getWorkDate()
    {
        return this.workDate;
    }
    
    public void setWorkDate(Date date)
    {
        this.workDate = date;
    }
    
    public Time getClockIn()
    {
        return this.clockIn;
    }
    
    public void setClockIn(Time time)
    {
        this.clockIn = time;
    }
    
    public Time getClockOut()
    {
        return this.clockOut;
    }
    
    public void setClockOut(Time time)
    {
        this.clockOut = time;
    }
    
    public double getHours()
    {
        return this.hours;
    }
    
    public void setHours(int hours)
    {
        this.hours = hours;
    }
    
    public double getOTHours()
    {
        return this.otHours;
    }
    
    public void setOTHours(double ot)
    {
        this.otHours = ot;
    }
    
}
