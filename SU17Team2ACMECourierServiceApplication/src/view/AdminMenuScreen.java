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
public class AdminMenuScreen extends JPanel
{
	private JButton coInfoMaintenanceButton, courierMaintenanceButton, staffMaintenanceButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel adminMenuContainer, mainPane, imgContainer;
	
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController adminMenuController;
    
    public AdminMenuScreen(ButtonController buttonController)
    {
    	adminMenuController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	adminMenuContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 300, 0, 300);
    	adminMenuContainer.setBorder(new CompoundBorder(margin, border));
    	adminMenuContainer.setAlignmentX(CENTER_ALIGNMENT);
    	adminMenuContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
		// Set the Logo image for the North part of the window
		try 
		{ 
			acmeCourierServiceLogo = ImageIO.read(new File(filePath + separator + "images" + separator + "acmeCourierServiceLogo.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
    	/*
    	 *  Setup the images for each button
    	 */
    	// Create a New Ticket Button
    	Image coInfoMaintenanceButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "coInfoMaintenanceButton.png");
    	coInfoMaintenanceButton = new JButton(new ImageIcon(coInfoMaintenanceButtonIcon));     	
    	
    	// Edit a Ticket Button
    	Image courierMaintenanceButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "courierMaintenanceButton.png");
    	courierMaintenanceButton = new JButton(new ImageIcon(courierMaintenanceButtonIcon));      	
    	
    	// Cancel a Ticket Button
    	Image staffMaintenanceButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "staffMaintenanceButton.png");
    	staffMaintenanceButton = new JButton(new ImageIcon(staffMaintenanceButtonIcon));    	
    	
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
		imgContainer.setBorder(new EmptyBorder(35, 10, 15, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		adminMenuContainer.setLayout(new BoxLayout(adminMenuContainer, BoxLayout.Y_AXIS));
		adminMenuContainer.setOpaque(false);
		adminMenuContainer.setBounds(375, 400, 400, 175);
		
		// -- Admin Menu Label
		JLabel adminMenuLabel = new JLabel();
		adminMenuLabel.setText("Admin Menu");
		adminMenuLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		adminMenuLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
		adminMenuLabel.setAlignmentX(LEFT_ALIGNMENT);
		adminMenuContainer.add(adminMenuLabel);
		
        // -- Create a New Ticket Button
		coInfoMaintenanceButton.setName("coInfoMaintenanceButton");
		coInfoMaintenanceButton.setOpaque(false);
		coInfoMaintenanceButton.setContentAreaFilled(false);
		coInfoMaintenanceButton.setBorder(new EmptyBorder(5, 75, 0, 75));
		coInfoMaintenanceButton.addActionListener(adminMenuController);
		adminMenuContainer.add(coInfoMaintenanceButton);
		
        // -- Edit a Ticket Button
		courierMaintenanceButton.setName("courierMaintenanceButton");
		courierMaintenanceButton.setOpaque(false);
		courierMaintenanceButton.setContentAreaFilled(false);
		courierMaintenanceButton.setBorder(new EmptyBorder(25, 75, 0, 75));
		courierMaintenanceButton.addActionListener(adminMenuController);
		adminMenuContainer.add(courierMaintenanceButton);
		
        // -- Cancel a Ticket Button
		staffMaintenanceButton.setName("staffMaintenanceButton");
		staffMaintenanceButton.setOpaque(false);
		staffMaintenanceButton.setContentAreaFilled(false);
		staffMaintenanceButton.setBorder(new EmptyBorder(25, 75, 0, 75));
		staffMaintenanceButton.addActionListener(adminMenuController);
		adminMenuContainer.add(staffMaintenanceButton);
		
        // -- Back Button
		backButton.setName("backButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(25, 75, 25, 75));
		backButton.addActionListener(adminMenuController);
		adminMenuContainer.add(backButton);
		
		// --- end of Box for Menu buttons
		
		mainPane.add(adminMenuContainer, BorderLayout.CENTER);
		
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 325, 0, 0));
		logoutButton.addActionListener(adminMenuController);
		mainPane.add(logoutButton, BorderLayout.SOUTH);
		this.add(mainPane);
    }
}
