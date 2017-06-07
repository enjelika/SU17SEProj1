package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

public class MainMenuScreen extends JPanel
{
	/**
	 * Auto-generated Serialization ID
	 */
	private static final long serialVersionUID = -7354190704598226135L;
	
	private JButton adminMenuButton, customerMaintenanceButton, deliveryTicketButton, reportsButton, settingsButton, logoutButton;
	private JLabel imageFrame;
	private JPanel mainMenuContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController mainMenuController;
    
    public MainMenuScreen(ButtonController buttonController)
    {
    	mainMenuController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	mainMenuContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 300, 0, 300);
    	mainMenuContainer.setBorder(new CompoundBorder(margin, border));
    	mainMenuContainer.setAlignmentX(CENTER_ALIGNMENT);
    	mainMenuContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
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
    	// Admin Menu Button
    	Image adminMenuButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "adminMenuButton.png");
    	adminMenuButton = new JButton(new ImageIcon(adminMenuButtonIcon));   	
    	
    	// Customer Maintenance Button
    	Image customerMaintenanceButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "customerMaintenanceButton.png");
    	customerMaintenanceButton = new JButton(new ImageIcon(customerMaintenanceButtonIcon));     	
    	
    	// Delivery Ticket Button
    	Image deliveryTicketButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "deliveryTicketButton.png");
    	deliveryTicketButton = new JButton(new ImageIcon(deliveryTicketButtonIcon));      	
    	
    	// Reports Button
    	Image reportsButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "reportsButton.png");
    	reportsButton = new JButton(new ImageIcon(reportsButtonIcon));    	
    	
    	// Settings Button
    	Image settingsButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "settingsButton.png");
    	settingsButton = new JButton(new ImageIcon(settingsButtonIcon));
    	
    	// Logout Button
		Image logoutButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "logoutButton.png");
		logoutButton = new JButton(new ImageIcon(logoutButtonIcon));
    	
    	// Setup the View
    	SetUpView();
    }
    
    public void SetUpView()
    {
        /*
         *  Logo header
         */
        imgContainer = new JPanel();	
		imgContainer.setSize(new Dimension(75, 50));
		imageFrame = new JLabel();
		imageFrame = new JLabel(new ImageIcon(acmeCourierServiceLogo));
		imgContainer.add((Component)imageFrame);
		imgContainer.setBorder(new EmptyBorder(0, 10, 0, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		mainMenuContainer.setLayout(new BoxLayout(mainMenuContainer, BoxLayout.Y_AXIS));
		mainMenuContainer.setAlignmentX(CENTER_ALIGNMENT);
		mainMenuContainer.setAlignmentY(CENTER_ALIGNMENT);
		mainMenuContainer.setOpaque(false);
		
        // -- Admin Menu Button
		adminMenuButton.setName("adminMenuButton");
		adminMenuButton.setOpaque(false);
		adminMenuButton.setContentAreaFilled(false);
		adminMenuButton.setBorder(new EmptyBorder(15, 75, 0, 75));
		adminMenuButton.setVisible(true); //TODO:  This will need to be wired up to the Model for enable/disable by user role
		adminMenuButton.addActionListener(mainMenuController);
		mainMenuContainer.add(adminMenuButton);
		
        // -- Customer Maintenance Button
		customerMaintenanceButton.setName("customerMaintenanceButton");
		customerMaintenanceButton.setOpaque(false);
		customerMaintenanceButton.setContentAreaFilled(false);
		customerMaintenanceButton.setBorder(new EmptyBorder(5, 75, 0, 75));
		customerMaintenanceButton.addActionListener(mainMenuController);
		mainMenuContainer.add(customerMaintenanceButton);
		
        // -- Delivery Ticket Button
		deliveryTicketButton.setName("deliveryTicketButton");
		deliveryTicketButton.setOpaque(false);
		deliveryTicketButton.setContentAreaFilled(false);
		deliveryTicketButton.setBorder(new EmptyBorder(5, 75, 0, 75));
		deliveryTicketButton.addActionListener(mainMenuController);
		mainMenuContainer.add(deliveryTicketButton);
		
        // -- Reports Button
		reportsButton.setName("reportsButton");
		reportsButton.setOpaque(false);
		reportsButton.setContentAreaFilled(false);
		reportsButton.setBorder(new EmptyBorder(5, 75, 0, 75));
		reportsButton.addActionListener(mainMenuController);
		mainMenuContainer.add(reportsButton);
		
        // -- Settings Button
		settingsButton.setName("settingsButton");
		settingsButton.setOpaque(false);
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorder(new EmptyBorder(5, 75, 15, 75));
		settingsButton.addActionListener(mainMenuController);
		mainMenuContainer.add(settingsButton);
		
		// --- end of Box for Menu buttons
		
		mainPane.add(mainMenuContainer, BorderLayout.CENTER);
		
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(49, 215, 0, 0));
		logoutButton.addActionListener(mainMenuController);
		mainPane.add(logoutButton, BorderLayout.SOUTH);
		
		this.add(mainPane);
    }
}