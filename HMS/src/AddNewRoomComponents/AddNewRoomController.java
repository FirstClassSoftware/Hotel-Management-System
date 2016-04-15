/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddNewRoomComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yeejkoob Thao
 */
public class AddNewRoomController {

    private AddNewRoomView addNewRoomView;
    private AddNewRoomModel addNewRoomModel;
    
    public AddNewRoomController(AddNewRoomView view, AddNewRoomModel model) {
        addNewRoomView = view;
        addNewRoomModel = model;
        addNewRoomView.addSubtmitButtonListener(new SubmitListener());
        
    }
    
    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////
            String successMessage;
            String errorMessage;
            String floorNumber;
            String roomNumber;
            String roomType;
            String roomPrice;
            boolean isFloorNumberValid;
            boolean isRoomNumberValid;
            boolean isRoomPriceValid;
            ///////////////////////////////////////////////////////////////////
            successMessage = "Successfuly added a new room.";
            floorNumber = addNewRoomView.getFloorNumber();
            roomNumber = addNewRoomView.getRoomNumber();
            roomType = addNewRoomView.getRoomType();
            roomPrice = addNewRoomView.getRoomPrice();
            isFloorNumberValid = addNewRoomModel.validateFloorNumber(floorNumber);
            isRoomNumberValid = addNewRoomModel.validateRoomNumber(roomNumber);
            isRoomPriceValid = addNewRoomModel.validateRoomPrice(roomPrice);
            ///////////////////////////////////////////////////////////////////
            // finish declaring your variables you are going to use in this action performed.
            // initialize the variables above.
            // validate the user input.
            // display any pop up errors that occur
            // update the database with this valid information
            // Set up some if and else statements and display errors accordingly
            if(isFloorNumberValid == false) {
                errorMessage = "An incorrect value was entered for floor number.";
                addNewRoomView.displayErrorMessage(errorMessage);
            }
            if(isRoomNumberValid == false) {
                errorMessage = "An incorrect value was entered for room number.";
                addNewRoomView.displayErrorMessage(errorMessage);
            }
            if(isRoomPriceValid == false) {
                errorMessage = "An incorrect value was entered for room price.";
                addNewRoomView.displayErrorMessage(errorMessage);
            }
            if(isFloorNumberValid && isRoomNumberValid && isRoomPriceValid) {
                // Convert string values into integers
                int roomFloorNumberIntVersion = Integer.parseInt(floorNumber);
                int roomNumberIntVersion = Integer.parseInt(roomNumber);
                int roomPriceIntVersion = Integer.parseInt(roomPrice);
                addNewRoomModel.addNewRoom(roomFloorNumberIntVersion, roomNumberIntVersion, roomType, roomPriceIntVersion);
                addNewRoomView.getAssociatedRoomController().updateRoomTable();
                addNewRoomView.displayErrorMessage(successMessage);
                addNewRoomView.dispose();
            }
        }
    
    }
}
