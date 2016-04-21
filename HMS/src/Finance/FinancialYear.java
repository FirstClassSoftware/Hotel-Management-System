/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance;

import java.util.ArrayList;

/**
 *
 * @author Yeejkoob Thao
 */
public class FinancialYear {
    
    private ArrayList <Double> monthlyExpenses;
    private ArrayList <Double> monthlyRevenue;
    
    private double totalProfit;
    private double totalExpenses;
    private double totalRevenue;
    private int currentYear;
    public FinancialYear(ArrayList <Double>monthlyExpenses, ArrayList <Double>monthlyRevenue, int year) {
        this.currentYear = year;
        this.monthlyExpenses = monthlyExpenses;
        this.monthlyRevenue = monthlyRevenue;
        this.totalExpenses = calculateTotal(monthlyExpenses);
        this.totalRevenue = calculateTotal(monthlyRevenue);
        this.totalProfit = this.totalRevenue - this.totalExpenses;
    }
    
    public double calculateTotal(ArrayList <Double>monthlyRevenue) {
        double total = 0;
        for(int index = 0; index < monthlyRevenue.size(); index++) {
            total += monthlyRevenue.get(index);
        }
        return total;
    } // End of the calculateTotal method

    /**
     * @return the totalProfit
     */
    public double getTotalProfit() {
        return totalProfit;
    }

    /**
     * @param totalProfit the totalProfit to set
     */
    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    /**
     * @return the totalExpenses
     */
    public double getTotalExpenses() {
        return totalExpenses;
    }

    /**
     * @param totalExpenses the totalExpenses to set
     */
    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    /**
     * @return the totalRevenue
     */
    public double getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * @param totalRevenue the totalRevenue to set
     */
    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    /**
     * @return the monthlyExpenses
     */
    public ArrayList <Double> getMonthlyExpenses() {
        return monthlyExpenses;
    }

    /**
     * @param monthlyExpenses the monthlyExpenses to set
     */
    public void setMonthlyExpenses(ArrayList <Double> monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    /**
     * @return the monthlyRevenue
     */
    public ArrayList <Double> getMonthlyRevenue() {
        return monthlyRevenue;
    }

    /**
     * @param monthlyRevenue the monthlyRevenue to set
     */
    public void setMonthlyRevenue(ArrayList <Double> monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    /**
     * @return the currentYear
     */
    public int getCurrentYear() {
        return currentYear;
    }

    /**
     * @param currentYear the currentYear to set
     */
    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }
   
    
}
