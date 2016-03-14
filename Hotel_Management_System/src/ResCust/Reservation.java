/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResCust;

/**
 *
 * @author WhelanMyPC
 */
public class Reservation {
    
    private int size = 9;
    
    private int id;
    private String floorNum;
    private String roomNum;
    private String startDate;
    private String endDate;
    private String custNameFirst;
    private String custNameLast;
    private String roomType;
    private double cost;

    public Reservation() {
		
		// Initialize all values as null
		
        this.id = 0;
	this.floorNum = null;
	this.roomNum = null;
	this.startDate = null;
	this.endDate = null;
	this.custNameFirst = null;
        this.custNameLast = null;
	this.roomType = null;
	this.cost = 0;
	
	}
	
	public Reservation(int id, String floorNum, String roomNum, String startDate, String endDate, String custNameFirst, String custNameLast,
						String roomType, double cost) {
		
                this.id = id;
		this.floorNum = floorNum;
		this.roomNum = roomNum;
		this.startDate = startDate;
		this.endDate = endDate;
		this.custNameFirst = custNameFirst;
                this.custNameLast = custNameLast;
		this.roomType = roomType;
		this.cost = cost;
	
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
	
	public String getFloorNum() {
		return this.floorNum;
	}
	
	public void setFloorNum(String newNum) {
		this.floorNum = newNum;
	}
	
	public String getRoomNum() {
		return this.roomNum;
	}
	
	public void setRoomNum(String newNum) {
		this.roomNum = newNum;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(String newStartDate) {
		this.startDate = newStartDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(String newEndDate) {
		this.endDate = newEndDate;
	}
	
	public String getcustNameFirst() {
		return this.custNameFirst;
	}
	
	public void setcustNameFirst(String newcustNameFirst) {
		this.custNameFirst = newcustNameFirst;
	}
        
        public String getcustNameLast() {
		return this.custNameLast;
	}
	
	public void setcustNameLast(String newcustNameLast) {
		this.custNameLast = newcustNameLast;
	}
	
	public String getRoomType() {
		return this.roomType;
	}
	
	public void setRoomType(String newRoomType) {
		this.roomType = newRoomType;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public void setCost(double newCost) {
		this.cost = newCost;
	}
        
        public void setValue(int column, Object value) {
            Object oldValue = get(column);
            oldValue = value;
        }
        
        
        
        
        
        
        
        
        public Object get(int column) {
            switch(column) {
                case 0:
                    return id;
                case 1: 
                    return floorNum;
                case 2:
                    return roomNum;
                case 3: 
                    return startDate;
                case 4: 
                    return endDate;
                case 5:
                    return custNameFirst;
                case 6:
                    return custNameLast;
                case 7:
                    return roomType;
                case 8:
                    return cost;
            }
            return null;
        }
    
}
