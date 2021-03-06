package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import model.Utility;

@SuppressWarnings("serial")
public class CustomerMaintenanceMenuScreen extends JPanel
{
	private JButton addCustomerButton, editCustomerButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel customerMenuContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController customerMenuController;
    
    public CustomerMaintenanceMenuScreen(ButtonController buttonController)
    {
    	customerMenuController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	customerMenuContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 300, 0, 300);
    	customerMenuContainer.setBorder(new CompoundBorder(margin, border));
    	customerMenuContainer.setAlignmentX(CENTER_ALIGNMENT);
    	customerMenuContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
		// Set the Logo image for the North part of the window
		try 
		{ 
			acmeCourierServiceLogo = ImageIO.read(new File(filePath + separator + "images" + separator + "smACMECourierServiceLogo.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
    	/*
    	 *  Setup the images for each button
    	 */
    	// Add a Customer Button
    	Image addCustomerButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "addCustomerButton.png");
    	addCustomerButton = new JButton(new ImageIcon(addCustomerButtonIcon));     	
    	
    	// Edit a Customer Button
    	Image editCustomerButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "editCustomerButton.png");
    	editCustomerButton = new JButton(new ImageIcon(editCustomerButtonIcon));      	
    	
    	// Back Button
    	Image backButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "backButton.png");
    	backButton = new JButton(new ImageIcon(backButtonIcon));
    	
    	// Logout Button
		Image logoutButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "logoutButton.png");
		logoutButton = new JButton(new ImageIcon(logoutButtonIcon));
    	
    	// Setup the View
    	SetUpView();      	
    }
    
    public void SetUpView()
    {
        /*
         *  Logo
         */
        imgContainer = new JPanel();	
		imgContainer.setSize(new Dimension(75, 50));
		imageFrame = new JLabel();
		imageFrame = new JLabel(new ImageIcon(acmeCourierServiceLogo));
		imgContainer.add((Component)imageFrame);
		imgContainer.setBorder(new EmptyBorder(0, 10, 30, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		customerMenuContainer.setLayout(new BoxLayout(customerMenuContainer, BoxLayout.Y_AXIS));
		customerMenuContainer.setOpaque(false);
		customerMenuContainer.setBounds(375, 400, 400, 175);
		
		// -- Courier Maintenance Menu Label
		JLabel courierMaintenanceMenuLabel = new JLabel();
		courierMaintenanceMenuLabel.setText("Customer Maintenance");
		courierMaintenanceMenuLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		courierMaintenanceMenuLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
		courierMaintenanceMenuLabel.setAlignmentX(LEFT_ALIGNMENT);
		customerMenuContainer.add(courierMaintenanceMenuLabel);
		
        // -- Add a Customer Button
		addCustomerButton.setName("addCustomerButton");
		addCustomerButton.setOpaque(false);
		addCustomerButton.setContentAreaFilled(false);
		addCustomerButton.setBorder(new EmptyBorder(5, 75, 0, 75));
		addCustomerButton.addActionListener(customerMenuController);
		customerMenuContainer.add(addCustomerButton);
		
        // -- Edit a Customer Button
		editCustomerButton.setName("editCustomerButton");
		editCustomerButton.setOpaque(false);
		editCustomerButton.setContentAreaFilled(false);
		editCustomerButton.setBorder(new EmptyBorder(0, 75, 0, 75));
		editCustomerButton.addActionListener(customerMenuController);
		customerMenuContainer.add(editCustomerButton);
		
        // -- Back Button
		backButton.setName("backButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 75, 0, 75));
		backButton.addActionListener(customerMenuController);
		customerMenuContainer.add(backButton);
		
		// --- end of Box for Menu buttons
		
		mainPane.add(customerMenuContainer, BorderLayout.CENTER);
		
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(105, 215, 0, 0));
		logoutButton.addActionListener(customerMenuController);
		mainPane.add(logoutButton, BorderLayout.SOUTH);
		this.add(mainPane);
    }
}
