/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;

/**
 *
 * @author jessicaluu
 * 
 * The purpose of the employee class is to create an object for each employee
 * that will exist in the staff management database
 */
public class Employee {
    
    // Instance Variables
    
    private int size = 14;
    
    private int id;
    private String employeeID;
    private String firstName;
    private String lastName;
    private String employeeStatus;
    private String clockIn;
    private String clockOut;
    private int hoursWorked;
    private double hourlyWage;
    private double dailyPay;
    private double deductions;
    private double bonus;
    private double tax;
    private double totalPay;
    
    
    // Constructors
    
    /* This constructor initializes the employee parameters to null, 0, or 0.0
    */
    public Employee() {
        this.id = 0;
        this.employeeID = null;
        this.firstName = null;
        this.lastName = null;
        this.employeeStatus = null;
        this.clockIn = null;
        this.clockOut = null;
        this.hoursWorked = 0;
        this.hourlyWage = 0.0;
        this.dailyPay = 0.0;
        this.deductions = 0.0;
        this.bonus = 0.0;
        this.tax = 0.0;
        this.totalPay = 0.0;
    }
    
    /* This constructor sets the employee values to the specified parameters:
    id, employeeID, firstName, lastName, employeeSTatus, clockIn, clockOut,
    hoursWorked, hourlyWage, dailyPay, deductions, bonus, tax, totalPay
    */
    public Employee(int id, String employeeID, String firstName, String lastName,
            String employeeStatus, String clockIn, String clockOut, int hoursWorked,
            double hourlyWage, double dailyPay, double deductions, double bonus,
            double tax, double totalPay) {
        this.id = id;
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeStatus = employeeStatus;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
        this.dailyPay = dailyPay;
        this.deductions = deductions;
        this.bonus = bonus;
        this.tax = tax;
        this.totalPay = totalPay;
    }
    
    
    // Instance Methods -- Getters
    
    public int getSize() {
        return this.size;
    }
    
    public int getID() {
        return this.id;
    }
    
    /* Returns unique ID of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's ID will be returned to the user
    */
    public String getEmployeeID() {
        return this.employeeID;
    }
    
    /* Returns first name of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's first name will be returned to the user
    */
    public String getFirstName() {
        return this.firstName;
    }
    
    /* Returns last name of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's last name will be returned to the user
    */
    public String getLastName() {
        return this.lastName;
    }
    
    /* Returns status of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's status will be returned to the user
    */
    public String getEmployeeStatus() {
        return this.employeeStatus;
    }
    
    /* Returns clock in of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's clock in time will be returned to the user
    */
    public String getClockIn() {
        return this.clockIn;
    }
    
    /* Returns clock out of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's clock out time will be returned to the user
    */
    public String getClockOut() {
        return this.clockOut;
    }
    
    /* Returns hours worked of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's number of hours worked will be returned to
    the user
    */
    public int getHoursWorked() {
        return this.hoursWorked;
    }
    
    /* Returns hourly wage of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's hourly wage will be returned to the user
    */
    public double getHourlyWage() {
        return this.hourlyWage;
    }
    
    /* Returns daily pay of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's daily pay will be returned to the user
    */
    public double getDailyPay() {
        return this.dailyPay;
    }
    
    /* Returns deductions amount of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's deduction amount will be returned to the user
    */
    public double getDeductions() {
        return this.deductions;
    }
    
    /* Returns bonus amount of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's bonus amount will be returned to the user
    */
    public double getBonus() {
        return this.bonus;
    }
    
    /* Returns tax amount of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's tax amount will be returned to the user
    */
    public double getTax() {
        return this.tax;
    }
    
    /* Returns total pay of employee
    PRECONDITIONS: none
    POSTCONDITIONS: the employee's total pay will be returned to the user
    */
    public double getTotalPay() {
        return this.totalPay;
    }
    
    public Object get(int column) {
        switch(column) {
            case 0:
                return employeeID;
            case 1:
                return firstName;
            case 2:
                return lastName;
            case 3:
                return employeeStatus;
            case 4:
                return clockIn;
            case 5:
                return clockOut;
            case 6:
                return hoursWorked;
            case 7:
                return hourlyWage;
            case 8:
                return dailyPay;
            case 9:
                return deductions;
            case 10:
                return bonus;
            case 11:
                return tax;
            case 12:
                return totalPay;
        }
        return null;
    }
    
    
    // Instance Methods -- Setters
    
    public void setID(int newID) {
        this.id = newID;
    }
    
    /* Sets the employee's ID
    PRECONDITIONS: employeeID exists in the database
    POSTCONDITIONS: the employee's ID will be changed and set to newEmployeeID
    */
    public void setEmployeeID(String newEmployeeID) {
        this.employeeID = newEmployeeID;
    }
    
    /* Sets the employee's first name
    PRECONDITIONS: employee's firstName exists in the database
    POSTCONDITIONS: the employee's first name will be changed and set to
    newFirstName
    */
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }
    
    /* Sets the employee's last name
    PRECONDITIONS: employee's lastName exists in the database
    POSTCONDITIONS: the employee's last name will be changed and set to
    newLastName
    */
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }
    
    /* Sets the employee's status
    PRECONDITIONS: employee status exists in the database
    POSTCONDITIONS: the employee's status will be changed and set to
    newEmployeeStatus
    */
    public void setEmployeeStatus(String newEmployeeStatus) {
        this.employeeStatus = newEmployeeStatus;
    }
    
    /* Sets the employee's clock in time
    PRECONDITIONS: employee clock in time exists in the database
    POSTCONDITIONS: the employee's clock in time will be changed and set to
    newClockIn
    */
    public void setClockIn(String newClockIn) {
        this.clockIn = newClockIn;
    }
    
    /* Sets the employee's clock out time
    PRECONDITIONS: employee clock out time exists in the database
    POSTCONDITIONS: the employee's clock out time will be changed and set to
    newClockOut
    */
    public void setClockOut(String newClockOut) {
        this.clockOut = newClockOut;
    }
    
    /* Sets the employee's amount of hours worked
    PRECONDITIONS: employee's amount of hours worked exists in the database
    POSTCONDITIONS: the employee's amount of hours worked will be changed and
    set to newHoursWorked
    */
    public void setHoursWorked(int newHoursWorked) {
        this.hoursWorked = newHoursWorked;
    }
    
    /* Sets the employee's hourly wage
    PRECONDITIONS: hourly wage of employee exists in the database
    POSTCONDITIONS: the employee's hourly wage will be changed and set to
    newHourlyWage
    */
    public void setHourlyWage(double newHourlyWage) {
        this.hourlyWage = newHourlyWage;
    }
    
    /* Sets the employee's daily pay
    PRECONDITIONS: daily pay of employee exists in the database
    POSTCONDITIONS: the employee's daily pay will be changed and set to
    newDailyPay
    */
    public void setDailyPay(double newDailyPay) {
        this.dailyPay = newDailyPay;
    }
    
    /* Sets the employee's deduction amount
    PRECONDITIONS: deductions of employee exists in the database
    POSTCONDITIONS: the employee's deduction amount will be changed and set to
    newDeductions
    */
    public void setDeduction(double newDeductions) {
        this.deductions = newDeductions;
    }
    
    /* Sets the employee's bonus amount
    PRECONDITIONS: bonus amount of employee exists in the database
    POSTCONDITIONS: the employee's bonus amount will be changed and set to
    newBonus
    */
    public void setBonus(double newBonus) {
        this.bonus = newBonus;
    }
    
    /* Sets the employee's tax amount
    PRECONDITIONS: tax amount of employee exists in the database
    POSTCONDITIONS: the employee's tax amount will be changed and set to
    newTax
    */
    public void setTax(double newTax) {
        this.tax = newTax;
    }
    
    /* Sets the employee's total pay
    PRECONDITIONS: total pay of employee exists in the database
    POSTCONDITIONS: the employee's total pay will be changed and set to
    newTotalPay
    */
    public void setTotalPay(double newTotalPay) {
        this.totalPay = newTotalPay;
    }
    
    public void setValue(int  column, Object value) {
        switch(column) {
            case 0:
                employeeID = (String) value;
            case 1:
                firstName = (String) value;
            case 2:
                lastName = (String) value;
            case 3:
                employeeStatus = (String) value;
            case 4:
                clockIn = (String) value;
            case 5:
                clockOut = (String) value;
            case 6:
                hoursWorked = (Integer) value;
            case 7:
                hourlyWage = (Double) value;
            case 8:
                dailyPay = (Double) value;
            case 9:
                deductions = (Double) value;
            case 10:
                bonus = (Double) value;
            case 11:
                tax = (Double) value;
            case 12:
                totalPay = (Double) value;
        }
    }
    
}
