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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import model.Utility;

@SuppressWarnings("serial")
public class CourierMaintenanceMenuScreen extends JFrame
{
	private JButton addCourierButton, editCourierButton, deleteCourierButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel courierMenuContainer, mainPane, imgContainer;
	
	private String title = "ACME Courier Service";
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController courierMenuController;
    
    public CourierMaintenanceMenuScreen(ButtonController buttonController)
    {
    	courierMenuController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	courierMenuContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 300, 0, 300);
    	courierMenuContainer.setBorder(new CompoundBorder(margin, border));
    	courierMenuContainer.setAlignmentX(CENTER_ALIGNMENT);
    	courierMenuContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
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
    	Image addCourierButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "addCourierButton.png");
    	addCourierButton = new JButton(new ImageIcon(addCourierButtonIcon));     	
    	
    	// Edit a Ticket Button
    	Image editCourierButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "editCourierButton.png");
    	editCourierButton = new JButton(new ImageIcon(editCourierButtonIcon));      	
    	
    	// Cancel a Ticket Button
    	Image deleteCourierButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "deleteCourierButton.png");
    	deleteCourierButton = new JButton(new ImageIcon(deleteCourierButtonIcon));    	
    	
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
        setTitle(title);
        setSize(1000, 900);
        setLocationRelativeTo(null);
        JFrame.setDefaultLookAndFeelDecorated(true); 
        
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
		courierMenuContainer.setLayout(new BoxLayout(courierMenuContainer, BoxLayout.Y_AXIS));
		courierMenuContainer.setOpaque(false);
		courierMenuContainer.setBounds(375, 400, 400, 175);
		
		// -- Delivery Ticket Label
		JLabel courierMaintenanceMenuLabel = new JLabel();
		courierMaintenanceMenuLabel.setText("Courier Maintenance");
		courierMaintenanceMenuLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		courierMaintenanceMenuLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
		courierMaintenanceMenuLabel.setAlignmentX(LEFT_ALIGNMENT);
		courierMenuContainer.add(courierMaintenanceMenuLabel);
		
        // -- Create a New Ticket Button
		addCourierButton.setName("addCourierButton");
		addCourierButton.setOpaque(false);
		addCourierButton.setContentAreaFilled(false);
		addCourierButton.setBorder(new EmptyBorder(5, 75, 0, 75));
		addCourierButton.addActionListener(courierMenuController);
		courierMenuContainer.add(addCourierButton);
		
        // -- Edit a Ticket Button
		editCourierButton.setName("editCourierButton");
		editCourierButton.setOpaque(false);
		editCourierButton.setContentAreaFilled(false);
		editCourierButton.setBorder(new EmptyBorder(25, 75, 0, 75));
		editCourierButton.addActionListener(courierMenuController);
		courierMenuContainer.add(editCourierButton);
		
        // -- Cancel a Ticket Button
		deleteCourierButton.setName("deleteCourierButton");
		deleteCourierButton.setOpaque(false);
		deleteCourierButton.setContentAreaFilled(false);
		deleteCourierButton.setBorder(new EmptyBorder(25, 75, 0, 75));
		deleteCourierButton.addActionListener(courierMenuController);
		courierMenuContainer.add(deleteCourierButton);
		
        // -- Back Button
		backButton.setName("backButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(25, 75, 25, 75));
		backButton.addActionListener(courierMenuController);
		courierMenuContainer.add(backButton);
		
		// --- end of Box for Menu buttons
		
		mainPane.add(courierMenuContainer, BorderLayout.CENTER);
		
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 325, 0, 0));
		logoutButton.addActionListener(courierMenuController);
		mainPane.add(logoutButton, BorderLayout.SOUTH);
		
		setContentPane(mainPane);
    }
}
