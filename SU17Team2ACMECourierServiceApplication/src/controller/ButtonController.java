package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.StreetMap;

public class ButtonController implements ActionListener
{
	JFrame mainFrame;
	JPanel previousScreen;
	
	public ButtonController() 
	{
//		this.mainFrame = mainFrame;
	}
	
	public void setMainFrame(JFrame mainFrame)
	{
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		JButton sender = (JButton) ae.getSource();
    	String buttonID = sender.getName();
		//previousScreen = (JPanel)mainFrame.getContentPane();
		
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
				System.out.println("Going to the Courier Maintenance Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.CourierMaintenanceMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
				break;
				
			case "staffMaintenanceButton":
				// TODO: Staff Maintenance Admin Menu action here
				System.out.println("Going to the Staff Maintenance Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.StaffMaintenanceMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
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
    			System.out.println("Going to the Admin Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.AdminMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		case "customerMaintenanceButton":
    			// TODO: Customer Maintenance Menu action here
    			System.out.println("Going to the Customer Maintenance Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.CustomerMaintenanceMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		case "deliveryTicketButton":
    			// TODO: Delivery Ticket Menu action here
    			System.out.println("Going to the Delivery Ticket Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.DeliveryTicketMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		case "reportsButton":
    			// TODO: Reports Menu action here
    			System.out.println("Going to the Reports Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.ReportsMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		case "settingsButton":
    			// TODO: Settings Menu action here
    			System.out.println("Going to the Settings Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.SettingsMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
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
   	   		case "resetButton":
   	   			// TODO: Reset Button action here
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
    			// TODO: Back action here - not quite working
    			System.out.println("Going back to the previous screen..."); // + previousScreen.toString());
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.MainMenuScreen(this)); //previousScreen); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;	
    			
    		/*
    		 * Login Screen Button
    		 */
    		case "loginButton":
    			// TODO: Login action here
    			System.out.println("To the Main Menu...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.MainMenuScreen(this));
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
				StreetMap.testMap();	// For testing purpose
    			break;
    			
    		/*
    		 * Logout Button
    		 */
    		case "logoutButton":
    			// TODO: Logout action here
    			System.out.println("Going back to the Login Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.LoginScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		/*
    		 * Default
    		 */
    		default:
    			break;
    	}
	}
}
