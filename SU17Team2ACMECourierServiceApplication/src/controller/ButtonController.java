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
    		 * Admin Menu Buttons
    		 */
			case "coInfoMaintenanceButton":
				// TODO: Co Info Maintenance Admin Menu action here
				System.out.println(buttonID + " was pressed");
				break;
				
			case "courierMaintenanceButton":
				// TODO: Courier Maintenance Admin Menu action here
				System.out.println(buttonID + " was pressed");
				break;
				
			case "staffMaintenanceButton":
				// TODO: Staff Maintenance Admin Menu action here
				System.out.println(buttonID + " was pressed");
				break;    	
			
			/*
			 * Courier Maintenance Menu Buttons	
			 */
			case "addCourierButton":
				// TODO: Add a Courier Courier Maintenance Menu action here
				System.out.println(buttonID + " was pressed");
				break; 
				
			case "editCourierButton":
				// TODO: Edit a Courier Courier Maintenance Menu action here
				System.out.println(buttonID + " was pressed");
				break;  
				
			case "deleteCourierButton":
				// TODO: Delete a Courier Courier Maintenance Menu action here
				System.out.println(buttonID + " was pressed");
				break;  
			
			/*
			 * Customer Maintenance Menu Buttons	
			 */
				case "addCustomerButton":
					// TODO: Add a Customer Customer Maintenance Menu action here
					System.out.println(buttonID + " was pressed");
					break; 
					
				case "editCustomerButton":
					// TODO: Edit a Customer Customer Maintenance Menu action here
					System.out.println(buttonID + " was pressed");
					break;  
					
				case "deleteCustomerButton":
					// TODO: Delete a Customer Customer Maintenance Menu action here
					System.out.println(buttonID + " was pressed");
					break;  
				
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
    		 * Delivery Ticket Menu Buttons
    		 */
    		case "createNewTicketButton":
    			// TODO: Create a New Ticket action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
    		case "editTicketButton":
    			// TODO: Edit a Ticket action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
    		case "cancelTicketButton":
    			// TODO: Cancel a Ticket action here
    			System.out.println(buttonID + " was pressed");
    			break;
    			
   			/*
   			 * Customer Maintenance Menu Buttons	
   			 */
   			case "coPerformanceReportButton":
   				// TODO: Company Performance Report Reports Menu action here
   				System.out.println(buttonID + " was pressed");
   				break; 
    					
   			case "courierPerformanceReportButton":
   				// TODO: Courier Performance Report Reports Menu action here
   				System.out.println(buttonID + " was pressed");
   				break;  
    					
   			case "customerBillingReportButton":
   				// TODO: Customer Billing Report Reports Menu action here
   				System.out.println(buttonID + " was pressed");
   				break;  
    		
   			/*
   			 *  Save Button
   			 */
   			case "saveButton":
   				// TODO: Save Button action here
   				System.out.println(buttonID + " was pressed");
   				break;
   				
   			/*
   			 * Settings Menu Button
   			 */
   			case "updatePasswordButton":
   				// TODO: Update Password Settings Menu action here
   				System.out.println(buttonID + " was pressed");
   				break; 

    		/*
   	   		 * Staff Maintenance Menu Buttons	
   	   		 */
   	   		case "addUserButton":
   	   			// TODO: Add a User Staff Maintenance Menu action here
   	   			System.out.println(buttonID + " was pressed");
   	   			break; 
   	    					
   	   		case "editUserButton":
   	   			// TODO: Edit a User Staff Maintenance Menu action here
   	   			System.out.println(buttonID + " was pressed");
   	   			break;  
   	    					
   	   		case "deleteUserButton":
   	   			// TODO: Delete a User Staff Maintenance Menu action here
   	   			System.out.println(buttonID + " was pressed");
   	   			break; 
   				
    		/*
    		 * Back Button
    		 */
    		case "backButton":
    			// TODO: Back action here
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
