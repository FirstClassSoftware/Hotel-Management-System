/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomModule;

/**
 *
 * @author Whelan
 */
public class Room {
    
    private final int size = 6;
    
    private int id;
    private int number;
    private String type;
    private boolean reserved;
    private String reservationStart;
    private String reservationEnd;
    
    public Room(int id, int number, String type, boolean reserved, String reservationStart, String reservationEnd) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.reserved = reserved;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
    }
    
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(String reservationStart) {
        this.reservationStart = reservationStart;
    }

    public String getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(String reservationEnd) {
        this.reservationEnd = reservationEnd;
    }
    
    public void setValue(int column, Object value) {
        switch(column) {
            case 0:
                id = id;
            case 1:
                number = (Integer) value;
            case 2: 
                type = (String) value;
            case 3:
                String stringValue = (String) value;
                if(stringValue.equals("true")) {
                    reserved = true;
                }
                else if(stringValue.equals("false")) {
                    reserved = false;
                }
            case 4: 
                reservationStart = (String) value;
            case 5: 
                reservationEnd = (String) value;
        }
    }
        
        
        
        
        
        
        
        
    public Object get(int column) {
        switch(column) {
            case 0:
                return Integer.toString(id);
            case 1:
                return Integer.toString(number);
            case 2: 
                return type;
            case 3:
                return reserved;
            case 4: 
                return reservationStart;
            case 5: 
                return reservationEnd;
        }
        return null;
    }
    
}
