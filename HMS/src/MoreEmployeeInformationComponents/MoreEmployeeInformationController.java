/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoreEmployeeInformationComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yeejkoob Thao
 */
public class MoreEmployeeInformationController {
    private MoreEmployeeInformationView moreEmployeeInfoView;
    private MoreEmployeeInformationModel moreEmployeeInfoModel;
    
    public MoreEmployeeInformationController(MoreEmployeeInformationView view, MoreEmployeeInformationModel model) {
        this.moreEmployeeInfoView = view;
        this.moreEmployeeInfoModel = model;
        this.moreEmployeeInfoView.addGoBackButtonListener(new GoBackListener());
    }
    
    class GoBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moreEmployeeInfoView.dispose();
        }
        
    }
}
