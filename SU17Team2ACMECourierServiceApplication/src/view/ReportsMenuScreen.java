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
public class ReportsMenuScreen extends JFrame
{
	private JButton coPerformanceReportButton, courierPerformanceReportButton, customerBillingReportButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel reportsMenuContainer, mainPane, imgContainer;
	
	private String title = "ACME Courier Service";
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController reportsMenuController;
    
    public ReportsMenuScreen(ButtonController buttonController)
    {
    	reportsMenuController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	reportsMenuContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 300, 0, 300);
    	reportsMenuContainer.setBorder(new CompoundBorder(margin, border));
    	reportsMenuContainer.setAlignmentX(CENTER_ALIGNMENT);
    	reportsMenuContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
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
    	Image coPerformanceReportButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "coPerformanceReportButton.png");
    	coPerformanceReportButton = new JButton(new ImageIcon(coPerformanceReportButtonIcon));     	
    	
    	// Edit a Ticket Button
    	Image courierPerformanceReportButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "courierPerformanceReportButton.png");
    	courierPerformanceReportButton = new JButton(new ImageIcon(courierPerformanceReportButtonIcon));      	
    	
    	// Cancel a Ticket Button
    	Image customerBillingReportButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "customerBillingReportButton.png");
    	customerBillingReportButton = new JButton(new ImageIcon(customerBillingReportButtonIcon));    	
    	
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
		reportsMenuContainer.setLayout(new BoxLayout(reportsMenuContainer, BoxLayout.Y_AXIS));
		reportsMenuContainer.setOpaque(false);
		reportsMenuContainer.setBounds(375, 400, 400, 175);
		
		// -- Reports Menu Label
		JLabel reportsMenuLabel = new JLabel();
		reportsMenuLabel.setText("Reports");
		reportsMenuLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		reportsMenuLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
		reportsMenuLabel.setAlignmentX(LEFT_ALIGNMENT);
		reportsMenuContainer.add(reportsMenuLabel);
		
        // -- Create a New Ticket Button
		coPerformanceReportButton.setName("coPerformanceReportButton");
		coPerformanceReportButton.setOpaque(false);
		coPerformanceReportButton.setContentAreaFilled(false);
		coPerformanceReportButton.setBorder(new EmptyBorder(5, 75, 0, 75));
		coPerformanceReportButton.addActionListener(reportsMenuController);
		reportsMenuContainer.add(coPerformanceReportButton);
		
        // -- Edit a Ticket Button
		courierPerformanceReportButton.setName("courierPerformanceReportButton");
		courierPerformanceReportButton.setOpaque(false);
		courierPerformanceReportButton.setContentAreaFilled(false);
		courierPerformanceReportButton.setBorder(new EmptyBorder(25, 75, 0, 75));
		courierPerformanceReportButton.addActionListener(reportsMenuController);
		reportsMenuContainer.add(courierPerformanceReportButton);
		
        // -- Cancel a Ticket Button
		customerBillingReportButton.setName("customerBillingReportButton");
		customerBillingReportButton.setOpaque(false);
		customerBillingReportButton.setContentAreaFilled(false);
		customerBillingReportButton.setBorder(new EmptyBorder(25, 75, 0, 75));
		customerBillingReportButton.addActionListener(reportsMenuController);
		reportsMenuContainer.add(customerBillingReportButton);
		
        // -- Back Button
		backButton.setName("backButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(25, 75, 25, 75));
		backButton.addActionListener(reportsMenuController);
		reportsMenuContainer.add(backButton);
		
		// --- end of Box for Menu buttons
		
		mainPane.add(reportsMenuContainer, BorderLayout.CENTER);
		
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 325, 0, 0));
		logoutButton.addActionListener(reportsMenuController);
		mainPane.add(logoutButton, BorderLayout.SOUTH);
		
		setContentPane(mainPane);
    }
}