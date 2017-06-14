package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityTransaction;
import javax.swing.JButton;
import javax.swing.JFrame;

import courierDAO.UserDAO;
import courierDAO.emDAO;
import courierPD.User;
import model.Model;
import model.StreetMap;
import view.AddUserScreen;
import view.LoginScreen;
import view.ViewListener;

public class ButtonController implements ActionListener
{
	JFrame mainFrame;
	public Model model;
	ViewListener viewListener;
	public User loggedInUser;
	
	public ButtonController(Model model) 
	{
		this.model = model;
	}
	
	public void setMainFrame(JFrame mainFrame)
	{
		this.mainFrame = mainFrame;
	}

	public void setViewListener(ViewListener listener)
	{

		this.viewListener = listener;
	}
	
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
				System.out.println("Going to the Company Information Maintenance Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.EditCompanyInfoScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
				break;
				
			case "courierMaintenanceButton":
				System.out.println("Going to the Courier Maintenance Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.CourierMaintenanceMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
				break;
				
			case "staffMaintenanceButton":
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
				System.out.println("Going to the Add a Courier Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.AddCourierScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
				break; 
				
			case "editCourierButton":
				System.out.println("Going to the Edit/Delete a Courier Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.EditCourierScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
				break;  
			
			/*
			 * Customer Maintenance Menu Buttons	
			 */
			case "addCustomerButton":
				System.out.println("Going to the Add a New Customer Screen...");
	    		mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.AddCustomerScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
				break; 
					
			case "editCustomerButton":
				System.out.println("Going to the Edit a Customer Screen...");
	    		mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.EditCustomerScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
				break;  
				
    		/*
    		 * Main Menu Buttons
    		 */
    		case "adminMenuButton":
    			// TODO: Admin Menu action here (Be sure to implement boolean for menu option)
    			System.out.println("Going to the Admin Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.AdminMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		case "customerMaintenanceButton":
    			System.out.println("Going to the Customer Maintenance Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.CustomerMaintenanceMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		case "deliveryTicketButton":
    			System.out.println("Going to the Delivery Ticket Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.DeliveryTicketMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		case "reportsButton":
    			System.out.println("Going to the Reports Menu Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.ReportsMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		case "settingsButton":
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
    			System.out.println("Going to Create a New Ticket Screen 1...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.CreateDeliveryTicketScreen1(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
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
   	   			if(viewListener.getClass().getName().contains("AddUserScreen"))
	   			{
	   	   			AddUserScreen addUserViewReset = (AddUserScreen)viewListener.GetView();
	   	   			addUserViewReset.Reset();
	   			}
   	   			System.out.println(buttonID + " was pressed");
   	   			break;
   	   				
   			/*
   			 *  Save Button
   			 */
   			case "saveButton":
   				// TODO: Save Button action here
   	   			if(viewListener.getClass().getName().contains("AddUserScreen"))
   	   			{
	   	   			AddUserScreen addUserView = (AddUserScreen)viewListener.GetView();
	   	   			String addUsername = addUserView.GetUserName();
	   	   			String addPassword1 = addUserView.GetPassword1();
	   	   			String addPassword2 = addUserView.GetPassword2();
	   	   			String addUserType = addUserView.GetUserType();
	   	   			if(addUsername.isEmpty() || addPassword1.isEmpty())
	   	   			{
	   	   				addUserView.SetSaveMessage("Username and password cannot be empty.");
	   	   			}
	   	   			else if(addPassword1.equals(addPassword2))
	   	   			{
	   	   				try
	   	   				{
		   	   			User user = new User(addUsername, addPassword1, addUserType, "Y");
						EntityTransaction userTransaction = emDAO.getEM().getTransaction();
						userTransaction.begin();
		   	   			UserDAO.addUser(user);
						userTransaction.commit();
		   	   			addUserView.SetSaveMessage("User was successfully added.");
	   	   				}
	   	   				catch(Exception e){
	   	   				addUserView.SetSaveMessage("Unable to add user. User already exists.");
	   	   				}
	   	   			}
	   	   			else
	   	   			{
	   	   				addUserView.SetSaveMessage("Passwords do not match");
	   	   			}
   	   			}
   				break;
   				
   			/*
   			 * Settings Menu Button
   			 */
   			case "updatePasswordButton":
   				System.out.println("Going to the Update Password screen..."); 
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.UpdatePasswordScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
   				break; 

    		/*
   	   		 * Staff Maintenance Menu Buttons	
   	   		 */
   	   		case "addUserButton":
    			System.out.println("Going to the Add a User screen..."); 
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.AddUserScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
   	   			break; 
   	    					
   	   		case "editUserButton":
	   	   		System.out.println("Going to the Edit a User screen..."); 
				mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.EditUserScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
   	   			break;  
   				
    		/*
    		 * Back Buttons
    		 */
    		case "adminBackButton":
    			System.out.println("Going back to the Admin Menu screen..."); 
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.AdminMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;	
    			
    		case "courierMaintBackButton":
    			System.out.println("Going back to the Courier Maintenance Menu screen..."); 
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.CourierMaintenanceMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;	
    			
    		case "customerMaintBackButton":
    			System.out.println("Going back to the Customer Maintenance Menu screen..."); 
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.CustomerMaintenanceMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;	
    			
    		case "backButton":
    			System.out.println("Going back to the Main Menu screen..."); 
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.MainMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;	
    			
    		case "settingsBackButton":
    			System.out.println("Going back to the Settings Menu screen...");
				mainFrame.setContentPane(new view.SettingsMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		case "staffMaintBackButton":
    			System.out.println("Going back to the Staff Maintenance Menu screen..."); 
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.StaffMaintenanceMenuScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;	
    			
    		/*
    		 * Login Screen Button
    		 */
    		case "loginButton":
    			LoginScreen view = (LoginScreen)viewListener.GetView();
    			String username = view.GetUserName();
    			String password = view.GetPassword();
    			loggedInUser = UserDAO.findUser(username, password);
    			if(loggedInUser == null)
    			{
    				view.SetLoginMessage("Unable to validate Login. Please try again.");
    			}
    			else
    			{
	    			System.out.println("To the Main Menu...");
	    			mainFrame.getContentPane().removeAll();
					mainFrame.setContentPane(new view.MainMenuScreen(this));
					mainFrame.getContentPane().invalidate();
					mainFrame.getContentPane().revalidate();
					mainFrame.getContentPane().repaint();
    			}
				
				//Testing purpose
				StreetMap streetMap = new StreetMap();
				final String companyAddress = "4th Ave and D Street";
				final String startIntersection = "7th Ave and G Street";
				final String endIntersection = "1st Ave and A Street";
				streetMap.Dijkstra(companyAddress);
				streetMap.GetDirection(startIntersection, "From company to pickup location");
				streetMap.Dijkstra(startIntersection);
				streetMap.GetDirection(endIntersection, "From pickup location to delivery location");
				streetMap.Dijkstra(endIntersection);
				streetMap.GetDirection(companyAddress, "From delivery location to office");
				System.out.println("Total Distance: " + streetMap.TotalDistance + " blocks");
				System.out.println(streetMap.Direction);

    			break;
    			
    		/*
    		 * Logout Button
    		 */
    		case "logoutButton":
    			// TODO: Logout action here (wire up to the Model for the logic)
    			System.out.println("Going back to the Login Screen...");
    			mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(new view.LoginScreen(this)); 
				mainFrame.getContentPane().invalidate();
				mainFrame.getContentPane().revalidate();
				mainFrame.getContentPane().repaint();
    			break;
    			
    		/*
    		 * Default - do nothing
    		 */
    		default:
    			break;
    	}
	}
}
