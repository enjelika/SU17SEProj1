package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonController implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		JButton sender = (JButton) ae.getSource();
    	String buttonID = sender.getName();

    	switch(buttonID)
    	{
    		/*
    		 * Main Menu Buttons
    		 */
    		case "adminMenuButton":
    			// TODO: Admin Menu action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
    		case "customerMaintenanceButton":
    			// TODO: Customer Maintenance Menu action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
    		case "deliveryTicketButton":
    			// TODO: Delivery Ticket Menu action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
    		case "reportsButton":
    			// TODO: Reports Menu action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
    		case "settingsButton":
    			// TODO: Settings Menu action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
    		/*
    		 * Login Screen Button
    		 */
    		case "loginButton":
    			// TODO: Login action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
    		/*
    		 * Logout Button
    		 */
    		case "logoutButton":
    			// TODO: Logout action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
    		/*
    		 * Default
    		 */
    		default:
    			break;
    	}
	}
}
