/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.ReservationMenu;

import GUI.Command;


import HotelSystem.PanelOperations.MakePaymentOperation;

import HotelSystem.PanelOperations.MakeReservationOperation;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author New User
 */
public class AddServicesButton extends JButton implements Command {

    @Override
    public void execute() {
        try {
            MakeReservationOperation.makeReservation(ReservationMenuUI.getReservationMenuUIInstance());
            JOptionPane.showMessageDialog(null, "Reservation Made!"); 
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
