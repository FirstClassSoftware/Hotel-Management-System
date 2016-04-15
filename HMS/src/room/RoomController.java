/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import AddNewRoomComponents.*;
import javax.swing.table.TableColumn;
/**
 *
 * @author Yeejkoob Thao
 */
public class RoomController {

    ///////////////////////////////////////////////////////////////////////////
    private RoomView roomView;
    private RoomModel roomModel;
    private RoomController roomController;

    ///////////////////////////////////////////////////////////////////////////
    public RoomController(RoomView currentRoomView, RoomModel currentRoomModel) {
        roomView = currentRoomView;
        roomModel = currentRoomModel;
        roomController = this;
        roomView.addHomeButtonListener(new HomeListener());
        roomView.addAddRoomButtonListener(new AddNewRoomListener());
        roomView.addAddFloorButtonListener(new AddNewFloorListener());
        roomView.addRemoveFloorButtonListener(new RemoveFloorListener());
        updateRoomTable();
    }

    class HomeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            roomView.goToHomeView();
        }

    } // End of the HomeListener class
   
    class AddNewRoomListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddNewRoomView addNewRoomView = new AddNewRoomView(roomController);
            AddNewRoomModel addNewRoomModel = new AddNewRoomModel();
            AddNewRoomController addNewRoomController = new AddNewRoomController(addNewRoomView, addNewRoomModel);
            addNewRoomView.setVisible(true);
        }
    
    }
    
    class AddNewFloorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
    }
    
    class RemoveFloorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
    }
    
    class MyTableModel extends DefaultTableModel {
        
        @Override
        public void setValueAt(Object value, int row, int col) {
            JTable roomTable = roomView.getRoomTable();
            String columnName = roomTable.getColumnName(col);
            int roomId = Integer.valueOf(roomTable.getValueAt(row, 0).toString());
            
            roomModel.updateRoomValue(columnName, roomId, value, row, col);
            updateRoomTable();
        }
        
        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 0) {
                // The first will be uneditable.
                return false;
            } else {
                return true;
            }
        }
    } // End of the MyTableModel class

    public void updateRoomTable() {

        ResultSet allUsers = roomModel.getAllRooms();

        ResultSetMetaData allUsersMetaData;
        int totalColumns;

        JTable userTable = roomView.getRoomTable();
        //DefaultTableModel userTableModel = new DefaultTableModel();
        MyTableModel userTableModel = new MyTableModel();
        // Add a new table model listener here too.
        //userTableModel.addTableModelListener(new TableEditListener());
        //////////////////////////////////////////////////////////////////////
        try {

            allUsersMetaData = allUsers.getMetaData();
            totalColumns = allUsersMetaData.getColumnCount();

            // Get all the column names from the meta data and add the column
            // names to the table model.
            for (int columnIndex = 1; columnIndex <= totalColumns; columnIndex++) {
                userTableModel.addColumn(allUsersMetaData.getColumnLabel(columnIndex));
            }

            Object[] row = new Object[totalColumns];

            while (allUsers.next()) {
                for (int currentColumn = 0; currentColumn < totalColumns; currentColumn++) {
                    row[currentColumn] = allUsers.getObject(currentColumn + 1);
                }
                userTableModel.addRow(row);
            }

            userTable.setModel(userTableModel);
            ////////////////////////////////////////////////////////////////////
            // Setup the rest of the table everytime the model is updated.
            // I believe the model resetting the model resets the columns. Thus,
            // The code lies here, but I have not tested this assumption.
            ////////////////////////////////////////////////////////////////////
            TableColumn roomTypeColumn = userTable.getColumnModel().getColumn(3);
            JComboBox  roomTypeOptions = new JComboBox();
            roomTypeOptions.addItem("Single");
            roomTypeOptions.addItem("Double");
            roomTypeOptions.addItem("King");
            roomTypeOptions.addItem("Ballroom/Conference");
            roomTypeColumn.setCellEditor(new DefaultCellEditor(roomTypeOptions));
            ////////////////////////////////////////////////////////////////////
        } catch (SQLException err) {

            //String noRowSelectedErrorMessage = err.getMessage();
            //userView.displayErrorMessage(noRowSelectedErrorMessage);
        }

    } // End of the updateRoomTable method

} // End of the AddNewEmployeeController class
