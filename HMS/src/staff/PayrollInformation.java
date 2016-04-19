/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import java.io.Serializable;

/**
 *
 * @author Yeejkoob Thao
 */
public class PayrollInformation implements Serializable{
    ////////////////////////////////////////////////////////////////////////////
    private String payPeriod;
    private String clockIn;
    private String clockOut;
    private int hoursWorked;
    private double hourlyWage;
    private double dailyPay;
    ////////////////////////////////////////////////////////////////////////////

    /**
     * @return the payPeriod
     */
    public String getPayPeriod() {
        return this.payPeriod;
    }

    /**
     * @param payPeriod the payPeriod to set
     */
    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    /**
     * @return the clockIn
     */
    public String getClockIn() {
        return clockIn;
    }

    /**
     * @param clockIn the clockIn to set
     */
    public void setClockIn(String clockIn) {
        this.clockIn = clockIn;
    }

    /**
     * @return the clockOut
     */
    public String getClockOut() {
        return clockOut;
    }

    /**
     * @param clockOut the clockOut to set
     */
    public void setClockOut(String clockOut) {
        this.clockOut = clockOut;
    }

    /**
     * @return the hoursWorked
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * @param hoursWorked the hoursWorked to set
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * @return the hourlyWage
     */
    public double getHourlyWage() {
        return hourlyWage;
    }

    /**
     * @param hourlyWage the hourlyWage to set
     */
    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    /**
     * @return the dailyPay
     */
    public double getDailyPay() {
        dailyPay = hourlyWage * hoursWorked;
        return dailyPay;
    }

    /**
     * @param dailyPay the dailyPay to set
     */
    public void setDailyPay(double dailyPay) {
        this.dailyPay = dailyPay;
    }
}
