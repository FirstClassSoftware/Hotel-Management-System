/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

/** 
 * 
 * @author Jessica Luu
 * 
 * The purpose of the item class is to create an object for each item that will
 * be included in the inventory management database.
 */
public class Item {
    
    // Instance Variables
    
    private int size = 6;
    
    private int id;
    private String itemName;
    private int currentAmount;
    private int maxAmount;
    private double itemCost;
    private double itemStatus;
    
    
    // Constructors
    
    /* This constructor initializes the item variables to null, 0, or 0.0
    */
    public Item() {
        this.id = 0;
        this.itemName = null;
        this.currentAmount = 0;
        this.maxAmount = 0;
        this.itemCost = 0.0;
        this.itemStatus = 0.0;
    }
    
    /* This constructor sets the item values to the specified parameters:
    id, itemName, currentAmount, maxAmount, itemCost
    */
    public Item(int id, String itemName, int currentAmount, int maxAmount, double
            itemCost, double itemStatus) {
        this.id = id;
        this.itemName = itemName;
        this.currentAmount = currentAmount;
        this.maxAmount = maxAmount;
        this.itemCost = itemCost;
        this.itemStatus = itemStatus;
    }

    
    // Instance Methods —- Getters
    
    public int getSize() {
        return this.size;
    }
    
    public int getID() {
        return this.id;
    }

    /* Returns the name of the item
    PRECONDITIONS: none
    POSTCONDITIONS: the item’s name will be returned to the user
    */
    public String getItemName() {
        return this.itemName;
    }

    /* Returns the current amount of the item
    PRECONDITIONS: none
    POSTCONDITIONS: the item’s current amount will be returned to the user
    */
    public int getCurrentAmount() {
        return this.currentAmount;
    }

    /* Returns the maximum amount of the item
    PRECONDITIONS: none
    POSTCONDITIONS: the item’s maximum amount will be returned to the user
    */
    public int getMaxAmount() {
        return this.maxAmount;
    }

    /* Returns the cost of the item
    PRECONDITIONS: none
    POSTCONDITIONS: the item’s cost will be returned to the user
    */
    public double getItemCost() {
        return this.itemCost;
    }
    
    /* Returns the status of the item
    PRECONDITIONS: none
    POSTCONDITIONS: the item's status will be returned to the user
    */
    public double getItemStatus() {
        return this.itemStatus;
    }
    
    public Object get(int column) {
        switch(column) {
            case 0:
                return id;
            case 1:
                return itemName;
            case 2:
                return currentAmount;
            case 3:
                return maxAmount;
            case 4:
                return itemCost;
            case 5:
                return itemStatus;
        }
        return null;
    }

    
    // Instance Methods — Setters
    
    public void setID(int newID) {
        this.id = newID;
    }

    /* Sets the name of the item
    PRECONDITIONS: itemName exists in the database
    POSTCONDITIONS: the item’s name will be changed and set to
    newItemName
    */
    public void setItemName(String newItemName) {
        this.itemName = newItemName;
    }

    /* Sets the current amount of the item
    PRECONDITIONS: currentAmount exists in the database
    POSTCONDITIONS: the item’s current amount will be changed and set to
    newCurrentAmount
    */
    public void setCurrentAmount(int newCurrentAmount) {
        this.currentAmount = newCurrentAmount;
    }

    /* Sets the maximum amount of the item
    PRECONDITIONS: maxAmount exists in the database
    POSTCONDITIONS: the item’s maximum amount will be changed and set to
    newMaxAmount
    */
    public void setMaxAmount(int newMaxAmount) {
        this.maxAmount = newMaxAmount;
    }

    /* Sets the cost of the item
    PRECONDITIONS: itemCost exists in the database
    POSTCONDITIONS: the item’s cost will be changed and set to
    newItemCost
    */
    public void setItemCost(double newItemCost) {
        this.itemCost = newItemCost;
    }
    
    /* Sets the status of the item
    PRECONDITIONS: itemStatus exists in the database
    POSTCONDITIONS: the item's status will be changed and set to newItemStatus
    */
    public void setItemStatus(double newItemStatus) {
        this.itemStatus = newItemStatus;
    }
    
    public void setValue(int column, Object value) {
        switch(column) {
            case 0:
                id = (Integer) value;
            case 1:
                itemName = (String) value;
            case 2:
                currentAmount = (Integer) value;
            case 3:
                maxAmount = (Integer) value;
            case 4:
                itemCost = (Double) value;
            case 5:
                itemStatus = (Double) value;
        }
    }

}
