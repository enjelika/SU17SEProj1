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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import model.Utility;

@SuppressWarnings("serial")
public class AddUserScreen extends JPanel
{
	private JButton resetButton, saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel addNewUserContainer, southButtonContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController addCourierController;
    
    public AddUserScreen(ButtonController buttonController)
    {
    	addCourierController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	addNewUserContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 50, 0, 50);
    	addNewUserContainer.setBorder(new CompoundBorder(margin, border));
    	addNewUserContainer.setAlignmentX(CENTER_ALIGNMENT);
    	addNewUserContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
    	southButtonContainer = new JPanel();
    	southButtonContainer.setBorder(new EmptyBorder(55, 5, 5, 5));
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
    	// Reset Button
    	Image resetButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "resetButton.png");
    	resetButton = new JButton(new ImageIcon(resetButtonIcon)); 
    	
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
		addNewUserContainer.setLayout(new BoxLayout(addNewUserContainer, BoxLayout.Y_AXIS));
		addNewUserContainer.setOpaque(false);
		addNewUserContainer.setBounds(375, 400, 400, 175);
		
		JPanel addCourierScreenTitle = new JPanel();
		addCourierScreenTitle.setLayout(new BoxLayout(addCourierScreenTitle, BoxLayout.X_AXIS));
		addCourierScreenTitle.setBorder(new EmptyBorder(15, 15, 0, 450));
		
		
		// -- Add a New User Screen Label
		JLabel addNewUserScreenLabel = new JLabel();
		addNewUserScreenLabel.setText("Add a New User:");
		addNewUserScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		addNewUserScreenLabel.setBorder(new EmptyBorder(5, 5, 0, 500));
		addNewUserScreenLabel.setAlignmentX(LEFT_ALIGNMENT);
		addCourierScreenTitle.add(addNewUserScreenLabel);
		
		addNewUserContainer.add(addCourierScreenTitle);
		
		/*
		 *  Inner first container for User ID field
		 */
		JPanel userIdContainer = new JPanel();
		userIdContainer.setLayout(new BoxLayout(userIdContainer, BoxLayout.X_AXIS));
		userIdContainer.setBorder(new EmptyBorder(25, 25, 10, 10));
		
			// -- User ID Label
			JLabel userIdLabel = new JLabel();
			userIdLabel.setText("User ID:");
			userIdLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			userIdLabel.setAlignmentX(LEFT_ALIGNMENT);
			userIdContainer.add(userIdLabel);
			
			// -- User ID TextField
			Border borderO1 = new LineBorder(Color.BLUE, 1);
	    	Border marginO2 = new EmptyBorder(0, 60, 0, 25);
	    	JTextField userIdField = new JTextField();
			userIdField.setHorizontalAlignment(JTextField.LEFT);
			userIdField.setOpaque(false);
			userIdField.setFont(new Font("Calibri", Font.PLAIN, 28));
			userIdField.setBorder(new CompoundBorder(marginO2, borderO1));
			userIdField.setEditable(false);
			userIdContainer.add(userIdField);
		
		// -- end of User ID Field
		addNewUserContainer.add(userIdContainer);
			
		/*
		 *  Inner second container for User Name field
		 */
		JPanel userNameContainer = new JPanel();
		userNameContainer.setLayout(new BoxLayout(userNameContainer, BoxLayout.X_AXIS));
		userNameContainer.setBorder(new EmptyBorder(15, 25, 10, 10));
		
			// -- User Name Label
			JLabel userNameLabel = new JLabel();
			userNameLabel.setText("User Name:");
			userNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			userNameLabel.setAlignmentX(LEFT_ALIGNMENT);
			userNameContainer.add(userNameLabel);
			
			// -- User Name TextField
			Border borderN1 = new LineBorder(Color.BLUE, 1);
	    	Border marginN2 = new EmptyBorder(0, 50, 0, 25);
	    	JTextField userNameField = new JTextField();
	    	userNameField.setHorizontalAlignment(JTextField.LEFT);
	    	userNameField.setOpaque(false);
	    	userNameField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	userNameField.setBorder(new CompoundBorder(marginN2, borderN1));
			userNameContainer.add(userNameField);
		
		// -- end of 1st "New Password" Field
		addNewUserContainer.add(userNameContainer);
			
		/*
		 *  Inner second container for 1st "Password" field
		 */
		JPanel password1Container = new JPanel();
		password1Container.setLayout(new BoxLayout(password1Container, BoxLayout.X_AXIS));
		password1Container.setBorder(new EmptyBorder(5, 25, 10, 10));
		
			// -- 1st New Password Label
			JLabel passwordLabel1 = new JLabel();
			passwordLabel1.setText("Password:");
			passwordLabel1.setFont(new Font("Calibri", Font.PLAIN, 24));
			passwordLabel1.setAlignmentX(LEFT_ALIGNMENT);
			password1Container.add(passwordLabel1);
			
			// -- 1st New Password TextField
			Border borderP1 = new LineBorder(Color.BLUE, 1);
	    	Border marginP2 = new EmptyBorder(0, 50, 0, 25);
	    	JPasswordField newPasswordField1 = new JPasswordField();
	    	newPasswordField1.setEchoChar('*');
	    	newPasswordField1.setHorizontalAlignment(JTextField.LEFT);
	    	newPasswordField1.setOpaque(false);
	    	newPasswordField1.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	newPasswordField1.setBorder(new CompoundBorder(marginP2, borderP1));
			password1Container.add(newPasswordField1);
		
		// -- end of 1st "Password" Field
		addNewUserContainer.add(password1Container);
		
		/*
		 *  Inner third container for Retyping of "Password" field
		 */
		JPanel passwordContainer2 = new JPanel();
		passwordContainer2.setLayout(new BoxLayout(passwordContainer2, BoxLayout.X_AXIS));
		passwordContainer2.setBorder(new EmptyBorder(10, 25, 0, 10));
		
			// -- 2nd New Password Label
			JLabel newPasswordLabel2 = new JLabel();
			newPasswordLabel2.setText("Retype Password:");
			newPasswordLabel2.setFont(new Font("Calibri", Font.PLAIN, 24));
			newPasswordLabel2.setAlignmentX(LEFT_ALIGNMENT);
			passwordContainer2.add(newPasswordLabel2);
			
			// -- 2nd New Password TextField
			Border borderN2 = new LineBorder(Color.BLUE, 1);
	    	Border marginN3 = new EmptyBorder(0, 25, 0, 25);
	    	JPasswordField newPasswordField2 = new JPasswordField();
	    	newPasswordField2.setEchoChar('*');
	    	newPasswordField2.setHorizontalAlignment(JTextField.LEFT);
	    	newPasswordField2.setOpaque(false);
	    	newPasswordField2.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	newPasswordField2.setBorder(new CompoundBorder(marginN3, borderN2));
	    	passwordContainer2.add(newPasswordField2);
		
		// -- end of 2nd "New Password" Field
	    addNewUserContainer.add(passwordContainer2);	
		
		JPanel resetSaveButtonsContainer = new JPanel();
		resetSaveButtonsContainer.setLayout(new BoxLayout(resetSaveButtonsContainer, BoxLayout.X_AXIS));
		resetSaveButtonsContainer.setBorder(new EmptyBorder(25, 0, 20, 0));
		
        // -- Reset Button
		resetButton.setName("resetButton");
		resetButton.setOpaque(false);
		resetButton.setContentAreaFilled(false);
		resetButton.setBorder(new EmptyBorder(0, 0, 0, 75));
		resetButton.addActionListener(addCourierController);
		resetSaveButtonsContainer.add(resetButton);
		
		addNewUserContainer.add(resetSaveButtonsContainer);
		
        // -- Save Button
		saveButton.setName("saveButton");
		saveButton.setOpaque(false);
		saveButton.setContentAreaFilled(false);
		saveButton.setBorder(new EmptyBorder(5, 0, 0, 0));
		saveButton.addActionListener(addCourierController);
		resetSaveButtonsContainer.add(saveButton);
		
		addNewUserContainer.add(resetSaveButtonsContainer);

		// --- end of Box for Menu buttons
		
		mainPane.add(addNewUserContainer, BorderLayout.CENTER);
		
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
		this.add(mainPane);
    }
}
