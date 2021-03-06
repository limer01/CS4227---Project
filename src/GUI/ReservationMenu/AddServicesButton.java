/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.ReservationMenu;

import DatabaseManager.DatabaseOperations;
import GUI.Command;

import GUI.ServicesMenu.ServicesMenuUI;
import GUI.UserReservations.UserReservationsUI;
import GUI.PaymentUI.PaymentMenuUI;


import GUI.ServicesMenu.ServicesMenuUI;
import GUI.UserReservations.UserReservationsUI;

import GUI.PaymentUI.PaymentMenuUI;


import HotelSystem.PanelOperations.MakePaymentOperation;

import HotelSystem.PanelOperations.MakeReservationOperation;
import HotelSystem.PanelOperations.ViewReservationsOperation;
import HotelSystem.Entities.Receipt;
import HotelSystem.PanelOperations.AddServicesOperation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author New User
 */
public class AddServicesButton extends JButton implements Command {
    
    private Object[][] rowData;

    @Override
    public void execute() {
/*        
       try(DatabaseOperations dbOps = new DatabaseOperations()){
           
        rowData = dbOps.getServicesData();
        } catch(Exception ex){
            ex.printStackTrace();
        }
       
       ServicesMenuUI ui = new ServicesMenuUI(rowData);
       ui.makeVisible();
    }
    
}
*/
        try {
            MakeReservationOperation.makeReservation(ReservationMenuUI.getReservationMenuUIInstance());
            JOptionPane.showMessageDialog(null, "Reservation Made!"); 
            MakePaymentOperation makepaymentOp = new MakePaymentOperation();
            makepaymentOp.CalculateCost();
            rowData = AddServicesOperation.getServiceRowData();
            ServicesMenuUI ui = new ServicesMenuUI(rowData);
            ui.makeVisible();
            makepaymentOp.CalculateCost();
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
