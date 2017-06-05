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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import model.Utility;

@SuppressWarnings("serial")
public class AddCourierScreen extends JFrame
{
	private JButton saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel addCourierContainer, southButtonContainer, mainPane, imgContainer;
	
	private String title = "ACME Courier Service";
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController addCourierController;
    
    public AddCourierScreen(ButtonController buttonController)
    {
    	addCourierController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	addCourierContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 50, 0, 50);
    	addCourierContainer.setBorder(new CompoundBorder(margin, border));
    	addCourierContainer.setAlignmentX(CENTER_ALIGNMENT);
    	addCourierContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
    	southButtonContainer = new JPanel();
    	southButtonContainer.setBorder(new EmptyBorder(50, 5, 5, 5));
    	southButtonContainer.setLayout(new BoxLayout(southButtonContainer, BoxLayout.X_AXIS));
    	
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
    	// Save Button
    	Image saveButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "saveButton.png");
    	saveButton = new JButton(new ImageIcon(saveButtonIcon));     	
    	
    	// Back Button
    	Image backButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "backButton2.png");
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
		addCourierContainer.setLayout(new BoxLayout(addCourierContainer, BoxLayout.Y_AXIS));
		addCourierContainer.setOpaque(false);
		addCourierContainer.setBounds(375, 400, 400, 175);
		
		JPanel addCourierScreenTitle = new JPanel();
		addCourierScreenTitle.setLayout(new BoxLayout(addCourierScreenTitle, BoxLayout.X_AXIS));
		addCourierScreenTitle.setBorder(new EmptyBorder(15, 15, 0, 450));
		
		
		// -- Add Courier Screen Label
		JLabel addCourierScreenLabel = new JLabel();
		addCourierScreenLabel.setText("Add a Courier:");
		addCourierScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		addCourierScreenLabel.setBorder(new EmptyBorder(5, 5, 0, 500));
		addCourierScreenLabel.setAlignmentX(LEFT_ALIGNMENT);
		addCourierScreenTitle.add(addCourierScreenLabel);
		
		addCourierContainer.add(addCourierScreenTitle);
		
		/*
		 *  Inner first container for Courier ID field
		 */
		JPanel courierIdContainer = new JPanel();
		courierIdContainer.setLayout(new BoxLayout(courierIdContainer, BoxLayout.X_AXIS));
		courierIdContainer.setBorder(new EmptyBorder(75, 25, 10, 10));
		
			// -- Courier ID Label
			JLabel courierIdLabel = new JLabel();
			courierIdLabel.setText("Courier ID:");
			courierIdLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			courierIdLabel.setAlignmentX(LEFT_ALIGNMENT);
			courierIdContainer.add(courierIdLabel);
			
			// -- Courier ID TextField
			Border borderO1 = new LineBorder(Color.BLUE, 1);
	    	Border marginO2 = new EmptyBorder(0, 60, 0, 25);
	    	JTextField courierIdField = new JTextField();
			courierIdField.setHorizontalAlignment(JTextField.LEFT);
			courierIdField.setOpaque(false);
			courierIdField.setFont(new Font("Calibri", Font.PLAIN, 28));
			courierIdField.setBorder(new CompoundBorder(marginO2, borderO1));
			courierIdField.setEditable(false);
			courierIdContainer.add(courierIdField);
		
		// -- end of Courier ID Field
		addCourierContainer.add(courierIdContainer);
			
		/*
		 *  Inner second container for Courier Name field
		 */
		JPanel courierNameContainer = new JPanel();
		courierNameContainer.setLayout(new BoxLayout(courierNameContainer, BoxLayout.X_AXIS));
		courierNameContainer.setBorder(new EmptyBorder(15, 25, 5, 10));
		
			// -- Courier Name Label
			JLabel courierNameLabel = new JLabel();
			courierNameLabel.setText("Courier Name:");
			courierNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			courierNameLabel.setAlignmentX(LEFT_ALIGNMENT);
			courierNameContainer.add(courierNameLabel);
			
			// -- Courier Name TextField
			Border borderN1 = new LineBorder(Color.BLUE, 1);
	    	Border marginN2 = new EmptyBorder(0, 50, 0, 25);
	    	JTextField courierNameField = new JTextField();
	    	courierNameField.setHorizontalAlignment(JTextField.LEFT);
	    	courierNameField.setOpaque(false);
	    	courierNameField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	courierNameField.setBorder(new CompoundBorder(marginN2, borderN1));
			courierNameContainer.add(courierNameField);
		
		// -- end of 1st "New Password" Field
		addCourierContainer.add(courierNameContainer);
				
		JPanel saveButtonContainer = new JPanel();
		saveButtonContainer.setLayout(new BoxLayout(saveButtonContainer, BoxLayout.X_AXIS));
		saveButtonContainer.setBorder(new EmptyBorder(50, 0, 50, 0));
		
        // -- Save Button
		saveButton.setName("saveButton");
		saveButton.setOpaque(false);
		saveButton.setContentAreaFilled(false);
		saveButton.setBorder(new EmptyBorder(5, 0, 0, 0));
		saveButton.addActionListener(addCourierController);
		saveButtonContainer.add(saveButton, BorderLayout.CENTER);
		
		addCourierContainer.add(saveButtonContainer);

		// --- end of Box for Menu buttons
		
		mainPane.add(addCourierContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("backButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 270));
		backButton.addActionListener(addCourierController);
		southButtonContainer.add(backButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 270, 0, 0));
		logoutButton.addActionListener(addCourierController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		
		setContentPane(mainPane);
    }
}
