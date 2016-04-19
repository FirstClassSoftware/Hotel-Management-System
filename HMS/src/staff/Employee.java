/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Yeejkoob Thao
 */
public class Employee implements Serializable {

    ////////////////////////////////////////////////////////////////////////////
    private String firstName;
    private String lastName;
    private int employeeId;
    private ArrayList<PayrollInformation> payroll;
    ////////////////////////////////////////////////////////////////////////////

    public String getFirstName() {
        return firstName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<PayrollInformation> getPayroll() {
        return payroll;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }
    
    public void setEmployeeid(int newEmployeeId) {
        this.employeeId = newEmployeeId;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void setPayroll(ArrayList<PayrollInformation> newPayroll) {
        this.payroll = newPayroll;
    }

    public void addToPayroll(PayrollInformation newPayroll) {
        this.payroll.add(newPayroll);
    }

}
