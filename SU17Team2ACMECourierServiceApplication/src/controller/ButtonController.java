package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityTransaction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import courierDAO.CompanyInfoDAO;
import courierDAO.CourierDAO;
import courierDAO.CustomerDAO;
import courierDAO.UserDAO;
import courierDAO.emDAO;
import courierPD.Courier;
import courierPD.Customer;
import courierPD.User;
import model.Model;
import model.StreetMap;
import view.AddCourierScreen;
import view.AddCustomerScreen;
import view.AddUserScreen;
import view.EditCompanyInfoScreen;
import view.EditCourierScreen;
import view.EditCustomerScreen;
import view.EditUserScreen;
import view.LoginScreen;
import view.UpdatePasswordScreen;
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
				
			case "findCustomerButton":
				System.out.println("findCustomerButton war pressed");
				EditCustomerScreen editCustomerScreen = (EditCustomerScreen)viewListener.GetView();
	   			try
   				{
	   				String customerId = editCustomerScreen.customerIdField.getText();
	   				String customerName = editCustomerScreen.customerNameField.getText();
	   				Customer customer;
	   				if(customerId.isEmpty() && customerName.isEmpty()) 
	   				{
						JOptionPane.showMessageDialog(null, "Please enter id or name to find a customer.", "Edit Customer Screen", JOptionPane.INFORMATION_MESSAGE);
	   				}
	   				else 
	   				{
	   					if(customerName.isEmpty()) // Find customer in db by Id
	   					{
	   						customer = CustomerDAO.findCustomerById(Long.parseLong(customerId));
	   					}
	   					else if (customerId.isEmpty())	// Find customer in db using name
	   					{
	   						customer = CustomerDAO.findCustomerByName(customerName);
	   					}
	   					else // If the user enter both name and id, only find customer using Id 
   						{
	   						customer = CustomerDAO.findCustomerById(Long.parseLong(customerId));
   						}	  
	   					editCustomerScreen.customer = customer;
	   					editCustomerScreen.UpdateText();
	   				}
   				}
   				catch(Exception e)
	   			{
   					JOptionPane.showMessageDialog(null, "Invalid input! Please re-verify the customer id and customer name.", "Edit Customer Screen", JOptionPane.INFORMATION_MESSAGE);
   					System.out.println(e);
	   			}
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
   	   		 *  Reset Button
   	   		 */
   	   		case "resetButton":
   	   			// TODO: Reset Button action here
   	   			if(viewListener.getClass().getName().contains("AddUserScreen"))
	   			{
	   	   			AddUserScreen addUserViewReset = (AddUserScreen)viewListener.GetView();
	   	   			addUserViewReset.Reset();
	   			}
   	   			else if(viewListener.getClass().getName().contains("EditCompanyInfoScreen"))
	   			{
	   	   			EditCompanyInfoScreen editCompanyInfoScreen = (EditCompanyInfoScreen)viewListener.GetView();
	   	   			editCompanyInfoScreen.companyInfo = CompanyInfoDAO.findCompanyInfo("ACME Courier Service");
	   	   			editCompanyInfoScreen.UpdateText();
	   	   			JOptionPane.showMessageDialog(null, "Company Info is reset!", "Edit Company Info Screen", JOptionPane.INFORMATION_MESSAGE);
	   			}
	   	   		else if(viewListener.getClass().getName().contains("EditCustomerScreen"))
	   			{
	   	   			editCustomerScreen = (EditCustomerScreen)viewListener.GetView();
	   	   			editCustomerScreen.ClearText();
	   			}
   	   			System.out.println(buttonID + " was pressed");
   	   			break;
   	   				
   			/*
   			 *  Save Button
   			 */
   			case "saveButton":
   				// TODO: Save Button action here
   				
   				// Save for Add User Screen
   	   			if(viewListener.getClass().getName().contains("AddUserScreen"))
   	   			{
	   	   			AddUserScreen addUserView = (AddUserScreen)viewListener.GetView();
	   	   			String addUsername = addUserView.GetUserName();
	   	   			String addPassword1 = addUserView.GetPassword1();
	   	   			String addPassword2 = addUserView.GetPassword2();
	   	   			String addUserType = addUserView.GetUserType();
	   	   			if(addUsername.isEmpty() || addPassword1.isEmpty())
	   	   			{
	   	   				JOptionPane.showMessageDialog(null, "Username and password cannot be empty.", "Add User", JOptionPane.INFORMATION_MESSAGE);
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
							JOptionPane.showMessageDialog(null, "User was successfully added.", "Add User", JOptionPane.INFORMATION_MESSAGE);
	   	   				}
	   	   				catch(Exception e)
	   	   				{
	   	   				JOptionPane.showMessageDialog(null, "Unable to add user. User already exists.", "Add User", JOptionPane.INFORMATION_MESSAGE);
	   	   				}
	   	   			}
	   	   			else
	   	   			{
	   	   				JOptionPane.showMessageDialog(null, "Passwords do not match.", "Add User", JOptionPane.INFORMATION_MESSAGE);
	   	   			}
   	   			}
   	   			// Save for Edit Company Info Screen
	   	   		else if(viewListener.getClass().getName().contains("EditCompanyInfoScreen"))
	   			{
	   				EditCompanyInfoScreen editCompanyInfoView = (EditCompanyInfoScreen)viewListener.GetView();
		   			try
	   				{
		   				if(editCompanyInfoView.companyAddressField.getText().isEmpty()
		   						|| editCompanyInfoView.billRateField.getText().isEmpty()
		   						|| editCompanyInfoView.costPerBlockField.getText().isEmpty()
		   		    			|| editCompanyInfoView.courierSpeedField.getText().isEmpty() 
		   		    			|| editCompanyInfoView.blocksToMileField.getText().isEmpty()
		   		    			|| editCompanyInfoView.bonusOnTimeField.getText().isEmpty() 
		   		    			|| editCompanyInfoView.pickUpTimeField.getText().isEmpty() 
		   		    			|| editCompanyInfoView.bonusTimeVarianceField.getText().isEmpty()
		   		    			|| editCompanyInfoView.deliveryTimeField.getText().isEmpty() ) 
		   				{
		   					JOptionPane.showMessageDialog(null, "Invalid input! Text fields cannot be blank.", "Edit Company Info Screen", JOptionPane.INFORMATION_MESSAGE);
		   				}
		   				else 
		   				{
		   					editCompanyInfoView.SaveCompany();
							EntityTransaction companyInfoTransaction = emDAO.getEM().getTransaction();
							companyInfoTransaction.begin();
							CompanyInfoDAO.updateCompanyInfo(editCompanyInfoView.companyInfo);
							companyInfoTransaction.commit();
							JOptionPane.showMessageDialog(null, "Company Info is updated!", "Edit Company Info Screen", JOptionPane.INFORMATION_MESSAGE);
		   				}
	   				}
	   				catch(Exception e)
		   			{
	   					JOptionPane.showMessageDialog(null, "Invalid input! The data is reset", "Invalid Input", JOptionPane.INFORMATION_MESSAGE);
	   					editCompanyInfoView.UpdateText();
		   			}
	   			}   
   	   			// Save for Update Password Screen
   	   			else if(viewListener.getClass().getName().contains("UpdatePasswordScreen"))
   	   			{
	   	   			UpdatePasswordScreen updatePass = (UpdatePasswordScreen)viewListener.GetView();
	   	   			String newPassword1 = updatePass.GetNewPassword1();
	   	   			String newPassword2 = updatePass.GetNewPassword2();
	   	   			if(newPassword1.isEmpty() && newPassword2.isEmpty())
	   	   			{
	   	   				JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Add User", JOptionPane.INFORMATION_MESSAGE);
	   	   			}
	   	   			else if(newPassword1.equals(newPassword2))
	   	   			{
	   	   				try
	   	   				{
	   	   				loggedInUser.setPassword(newPassword1);
						EntityTransaction userTransaction = emDAO.getEM().getTransaction();
						userTransaction.begin();
		   	   			UserDAO.saveUser(loggedInUser);
						userTransaction.commit();
						JOptionPane.showMessageDialog(null, "Password was updated.", "Add User", JOptionPane.INFORMATION_MESSAGE);
	   	   				}
	   	   				catch(Exception e){
	   	   					JOptionPane.showMessageDialog(null, "Unable to update password.", "Add User", JOptionPane.INFORMATION_MESSAGE);
	   	   				}
	   	   			}
	   	   			else
	   	   			{
	   	   				JOptionPane.showMessageDialog(null, "Passwords do not match.", "Add User", JOptionPane.INFORMATION_MESSAGE);
	   	   			}
   	   			}
   	   			// Save for Edit User Screen
   	   			else if(viewListener.getClass().getName().contains("EditUserScreen"))
   	   			{
   	   				EditUserScreen editUser = (EditUserScreen)viewListener.GetView();
   	   				User edittedUser = editUser.GetCurrentlySelectedUser();
	   	   			String editNewPassword1 = editUser.GetNewPassword1();
	   	   			String editNewPassword2 = editUser.GetNewPassword2();
	   	   			if(editNewPassword1.isEmpty() && editNewPassword2.isEmpty())
	   	   			{
	   	   				JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Edit User", JOptionPane.INFORMATION_MESSAGE);
	   	   			}
		   	   		else if(editNewPassword1.equals(editNewPassword2))
	   	   			{
		   	   			edittedUser.setPassword(editNewPassword1);
						EntityTransaction userTransaction = emDAO.getEM().getTransaction();
						userTransaction.begin();
		   	   			UserDAO.saveUser(edittedUser);
						userTransaction.commit();
						JOptionPane.showMessageDialog(null, "User was Updated.", "Edit User", JOptionPane.INFORMATION_MESSAGE);
	   	   			}
			   	   	else
	   	   			{
			   	   		JOptionPane.showMessageDialog(null, "Passwords do not match.", "Add User", JOptionPane.INFORMATION_MESSAGE);
	   	   			}
   	   			}
	   	   		else if(viewListener.getClass().getName().contains("AddCustomerScreen"))
	   			{
	   				AddCustomerScreen addCustomerScreen = (AddCustomerScreen)viewListener.GetView();
		   			try
	   				{
		   				String customerName = addCustomerScreen.customerNameField.getText();
		   				String customerAddress = addCustomerScreen.customerAddressField.getText();
		   				if(customerName.isEmpty() || customerAddress.isEmpty())
		   				{
		   					JOptionPane.showMessageDialog(null, "Invalid input! Customer's name and address cannot be blank.", "Add Customer Screen", JOptionPane.INFORMATION_MESSAGE);
		   				}
		   				else
		   				{
		   					Customer customer = new Customer(customerName, customerAddress, "Y");
							EntityTransaction addCustomerTransaction = emDAO.getEM().getTransaction();
							addCustomerTransaction.begin();
							CustomerDAO.addCustomer(customer);
							addCustomerTransaction.commit();
							addCustomerScreen.ClearText();
							JOptionPane.showMessageDialog(null, "Customer is created!", "Add Customer Screen", JOptionPane.INFORMATION_MESSAGE);
		   				}
	   				}
	   				catch(Exception e)
		   			{
	   					JOptionPane.showMessageDialog(null, "Invalid input! The data is reset", "Invalid Input", JOptionPane.INFORMATION_MESSAGE);
	   					addCustomerScreen.ClearText();
		   			}
	   			}
   	   			// Save for Edit Customer Screen ====== STILL WORKING ON THIS ONE
   	   			else if(viewListener.getClass().getName().contains("EditCustomerScreen"))
	   			{
   	   				EditCustomerScreen editCustomerView = (EditCustomerScreen)viewListener.GetView();
		   			try
	   				{
		   				String customerId = editCustomerView.customerIdField.getText();
		   				String customerName = editCustomerView.customerNameField.getText();
		   				String customerAddress = editCustomerView.addressField.getText();
		   				if(customerId.isEmpty() || customerName.isEmpty() || customerAddress.isEmpty()) 
		   				{
							JOptionPane.showMessageDialog(null, "The text fields can not be blank!", "Edit Customer Screen", JOptionPane.INFORMATION_MESSAGE);
		   				}
		   				else 
		   				{
		   					editCustomerView.SaveCustomer();
							EntityTransaction customerTransaction = emDAO.getEM().getTransaction();
							customerTransaction.begin();
							CustomerDAO.updateCustomer(editCustomerView.customer);
							customerTransaction.commit();
							editCustomerView.ClearText();
							JOptionPane.showMessageDialog(null, "Customer is updated!", "Edit Customer Screen", JOptionPane.INFORMATION_MESSAGE);
		   				}
	   				}
	   				catch(Exception e)
		   			{
	   					JOptionPane.showMessageDialog(null, "Invalid input! Please re-verify the customer id and customer name.", "Edit Customer Screen", JOptionPane.INFORMATION_MESSAGE);
	   					System.out.println(e);
		   			}
	   			} else if(viewListener.getClass().getName().contains("AddCourierScreen"))
   	   			{
	   				AddCourierScreen addCourierView = (AddCourierScreen)viewListener.GetView();
	   	   			String addCourierName = addCourierView.GetCourierName();
	   	   			if(addCourierName.isEmpty())
	   	   			{
	   	   				JOptionPane.showMessageDialog(null, "Courier name cannot be empty.", "Add Courier", JOptionPane.INFORMATION_MESSAGE);
	   	   			}
	   	   			else
	   	   			{
	   	   				try
	   	   				{
			   	   			Courier courier = new Courier(addCourierName, "Y");
							EntityTransaction userTransaction = emDAO.getEM().getTransaction();
							userTransaction.begin();
			   	   			CourierDAO.addCourier(courier);
							userTransaction.commit();
							JOptionPane.showMessageDialog(null, "Courier was successfully added.", "Add Courier", JOptionPane.INFORMATION_MESSAGE);
	   	   				}
	   	   				catch(Exception e)
	   	   				{
	   	   				JOptionPane.showMessageDialog(null, "Unable to add Courier. Courier already exists.", "Add Courier", JOptionPane.INFORMATION_MESSAGE);
	   	   				}
	   	   			}
   	   			}
	   			else if(viewListener.getClass().getName().contains("EditCourierScreen"))
   	   			{
	   				EditCourierScreen editCourierScreen = (EditCourierScreen)viewListener.GetView();
   	   				Courier editCourier = editCourierScreen.GetCurrentlySelectedCourier();
	   	   			if(editCourier.getName().isEmpty())
	   	   			{
	   	   				JOptionPane.showMessageDialog(null, "Courier name cannot be empty.", "Edit Courier", JOptionPane.INFORMATION_MESSAGE);
	   	   			}
		   	   		else
	   	   			{
						EntityTransaction userTransaction = emDAO.getEM().getTransaction();
						userTransaction.begin();
		   	   			CourierDAO.saveCourier(editCourier);
						userTransaction.commit();
						JOptionPane.showMessageDialog(null, "Courier was Updated.", "Edit Courier", JOptionPane.INFORMATION_MESSAGE);
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
    				JOptionPane.showMessageDialog(null, "Unable to validate Login. Please try again.", "Login Screen", JOptionPane.INFORMATION_MESSAGE);
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
