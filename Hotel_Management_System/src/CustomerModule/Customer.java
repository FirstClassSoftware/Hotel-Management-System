/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

/**
 *
 * @author WhelanMyPC
 */
public class Customer {
    
    private final int size = 11;
    
    private int id;
    private String firstName;
    private String lastName;
    private String numOfOccupants;
    private String occupationDate;
    private String address;
    private String tab;
    private String lastRoomNum;
    private String phoneNum;
    private String email;
    private String paymentMethod;

    // Initialize all values as null
    public Customer() {
		
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.numOfOccupants = null;
        this.occupationDate = null;
        this.address = null;
        this.tab = null;
        this.lastRoomNum = null;
        this.phoneNum = null;
        this.email = null;
        this.paymentMethod = null;
	
    }
	
    public Customer(int id, String firstName, String lastName, String numOfOccupants, 
            String occupationDate, String address, String tab, 
        String lastRoomNum, String phoneNum, String email, String paymentMethod) {
		
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numOfOccupants = numOfOccupants;
        this.occupationDate = occupationDate;
        this.address = address;
        this.tab = tab;
        this.lastRoomNum = lastRoomNum;
        this.phoneNum = phoneNum;
        this.email = email;
        this.paymentMethod = paymentMethod;
	
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setID(int newID) {
        this.id = newID;
    }
	
    // returns firstName value of Customer
    public String getFirstName() {
        return this.firstName;
    }
	
    // sets firstName value to newFirstName
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }
	
    // returns lastName value of Customer
    public String getLastName() {
        return this.lastName;
    }
	
    // sets lastName value to newLastName
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }
	
    // returns the numOfOccupants of Customer
    public String getNumOfOccupants() {
        return this.numOfOccupants;
    }
	
    // 
    public void setNumOfOccupants(String newNumOfOccupants) {
        this.numOfOccupants = newNumOfOccupants;
    }
	
    public String getOccupationDate() {
        return this.occupationDate;
    }
	
    public void setOccupationDate(String newOccupationDate) {
        this.occupationDate = newOccupationDate;
    }
	
    public String getAddress() {
        return this.address;
    }
	
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }
	
    public String getTab() {
        return this.tab;
    }
	
    public void setTab(String newTab) {
        this.tab = newTab;
    }
	
    public String getLastRoomNum() {
        return this.lastRoomNum;
    }
	
    public void setLastRoomNum(String newLastRoomNum) {
        this.lastRoomNum = newLastRoomNum;
    }
	
    public String getPhoneNum() {
        return this.phoneNum;
    }
	
    public void setPhoneNum(String newPhoneNum) {
        this.phoneNum = newPhoneNum;
    }
	
    public String getEmail() {
        return this.email;
    }
	
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
	
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
	
    public void setPaymentMethod(String newPaymentMethod) {
        this.paymentMethod = newPaymentMethod;
    }
    
    
    
    public void setValue(int column, Object value) {
        switch(column) {
            case 0:
                id = id;
            case 1:
                firstName = (String) value;
            case 2: 
                lastName = (String) value;
            case 3:
                numOfOccupants = (String) value;
            case 4: 
                occupationDate = (String) value;
            case 5: 
                address = (String) value;
            case 6:
                tab = (String) value;
            case 7:
                lastRoomNum = (String) value;
            case 8:
                phoneNum = (String) value;
            case 9:
                email = (String) value;
            case 10:
                paymentMethod = (String) value;
        }
    }
        
        
        
        
        
        
        
        
    public Object get(int column) {
        switch(column) {
            case 0:
                return Integer.toString(id);
            case 1:
                return firstName;
            case 2: 
                return lastName;
            case 3:
                return numOfOccupants;
            case 4: 
                return occupationDate;
            case 5: 
                return address;
            case 6:
                return tab;
            case 7:
                return lastRoomNum;
            case 8:
                return phoneNum;
            case 9:
                return email;
            case 10:
                return paymentMethod;
        }
        return null;
    }
    
    
    /*
                      "FIRST_NAME VARCHAR(255),"
                    + "LAST_NAME VARCHAR(255),"
                    + "NUMBER_OF_OCCUPANTS VARCHAR(255),"
                    + "OCCUPATION_DATE VARCHAR(255),"
                    + "ADDRESS VARCHAR(255),"
                    + "TAB VARCHAR(255),"
                    + "PREVIOUS_ROOM_NUM VARCHAR(255),"
                    + "PHONE_NUM VARCHAR(255)"
                    + "EMAIL VARCHAR(255)"
                    + "PAYMENT_METHOD VARCHAR(255))";
    */
}
