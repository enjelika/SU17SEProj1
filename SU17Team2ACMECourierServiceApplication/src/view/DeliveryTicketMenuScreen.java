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
public class DeliveryTicketMenuScreen extends JPanel
{
	private JButton createNewTicketButton, editTicketButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel ticketMenuContainer, mainPane, imgContainer;
	
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController ticketController;
    
    public DeliveryTicketMenuScreen(ButtonController buttonController)
    {
    	ticketController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	ticketMenuContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 300, 0, 300);
    	ticketMenuContainer.setBorder(new CompoundBorder(margin, border));
    	ticketMenuContainer.setAlignmentX(CENTER_ALIGNMENT);
    	ticketMenuContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
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
    	// Create a New Ticket Button
    	Image createNewTicketButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "createNewTicketButton.png");
    	createNewTicketButton = new JButton(new ImageIcon(createNewTicketButtonIcon));     	
    	
    	// Edit a Ticket Button
    	Image editTicketButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "editTicketButton.png");
    	editTicketButton = new JButton(new ImageIcon(editTicketButtonIcon));      	
    	
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
		imgContainer.setBorder(new EmptyBorder(0, 10, 20, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		ticketMenuContainer.setLayout(new BoxLayout(ticketMenuContainer, BoxLayout.Y_AXIS));
		ticketMenuContainer.setOpaque(false);
		
		// -- Delivery Ticket Label
		JLabel deliveryTicketLabel = new JLabel();
		deliveryTicketLabel.setText("Delivery Ticket");
		deliveryTicketLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		deliveryTicketLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
		deliveryTicketLabel.setAlignmentX(LEFT_ALIGNMENT);
		ticketMenuContainer.add(deliveryTicketLabel);
		
        // -- Create a New Ticket Button
		createNewTicketButton.setName("createNewTicketButton");
		createNewTicketButton.setOpaque(false);
		createNewTicketButton.setContentAreaFilled(false);
		createNewTicketButton.setBorder(new EmptyBorder(0, 75, 0, 75));
		createNewTicketButton.addActionListener(ticketController);
		ticketMenuContainer.add(createNewTicketButton);
		
        // -- Edit a Ticket Button
		editTicketButton.setName("editTicketButton");
		editTicketButton.setOpaque(false);
		editTicketButton.setContentAreaFilled(false);
		editTicketButton.setBorder(new EmptyBorder(0, 75, 0, 75));
		editTicketButton.addActionListener(ticketController);
		ticketMenuContainer.add(editTicketButton);
		
        // -- Back Button
		backButton.setName("backButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 75, 10, 75));
		backButton.addActionListener(ticketController);
		ticketMenuContainer.add(backButton);
		
		// --- end of Box for Menu buttons
		
		mainPane.add(ticketMenuContainer, BorderLayout.CENTER);
		
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 215, 0, 0));
		logoutButton.addActionListener(ticketController);
		mainPane.add(logoutButton, BorderLayout.SOUTH);
		this.add(mainPane);
    }
}
