package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import model.Utility;

public class EditUserScreen extends JPanel
{

	/**
	 * Auto-generated Serialization ID
	 */
	private static final long serialVersionUID = 6951443040591813836L;

	private JButton findButton, resetButton, saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel editUserContainer, southButtonContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController editCourierController;
    
    public EditUserScreen(ButtonController buttonController)
    {
    	editCourierController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	editUserContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 50, 0, 50);
    	editUserContainer.setBorder(new CompoundBorder(margin, border));
    	editUserContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
    	southButtonContainer = new JPanel();
    	southButtonContainer.setBorder(new EmptyBorder(15, 5, 5, 5));
    	southButtonContainer.setLayout(new BoxLayout(southButtonContainer, BoxLayout.X_AXIS));
    	
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
		// Find Button
    	Image findButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "findButton.png");
    	findButton = new JButton(new ImageIcon(findButtonIcon)); 
    	
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
		imgContainer.setBorder(new EmptyBorder(0, 10, 0, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		editUserContainer.setLayout(new BoxLayout(editUserContainer, BoxLayout.Y_AXIS));
		editUserContainer.setOpaque(false);
		
		JPanel editUserScreenTitle = new JPanel();
		editUserScreenTitle.setLayout(new BoxLayout(editUserScreenTitle, BoxLayout.X_AXIS));
		editUserScreenTitle.setBorder(new EmptyBorder(15, 15, 0, 450));
		
		
		// -- Add a New User Screen Label
		JLabel editNewUserScreenLabel = new JLabel();
		editNewUserScreenLabel.setText("Staff Information:");
		editNewUserScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		editNewUserScreenLabel.setBorder(new EmptyBorder(5, 5, 0, 200));
		editNewUserScreenLabel.setAlignmentX(LEFT_ALIGNMENT);
		editUserScreenTitle.add(editNewUserScreenLabel);
		
		editUserContainer.add(editUserScreenTitle);
		
		/*
		 *  Container for User ID field and User Name field
		 */
		JPanel userFields = new JPanel();
		userFields.setLayout(new BoxLayout(userFields, BoxLayout.Y_AXIS));
		userFields.setBorder(new EmptyBorder(25, 0, 0, 0));
		
		/*
		 *  Inner first container for User ID field
		 */
		JPanel userIdContainer = new JPanel();
		userIdContainer.setLayout(new BoxLayout(userIdContainer, BoxLayout.X_AXIS));
		userIdContainer.setBorder(new EmptyBorder(0, 0, 10, 0));
		
			// -- User ID Label
			JLabel userIdLabel = new JLabel();
			userIdLabel.setText("User ID:");
			userIdLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			userIdLabel.setAlignmentX(LEFT_ALIGNMENT);
			userIdContainer.add(userIdLabel);
			
			// Used to "pretty" up the Text Field
			JPanel userIdTextboxContainer = new JPanel();
			userIdTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			userIdTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 5));
			
			// -- User ID TextField
	    	JTextField userIdField = new JTextField("", 20);
			userIdField.setHorizontalAlignment(JTextField.LEFT);
			userIdField.setFont(new Font("Calibri", Font.PLAIN, 28));
			userIdField.setBorder(new LineBorder(Color.BLUE, 1));
			userIdTextboxContainer.add(userIdField);
			userIdContainer.add(userIdTextboxContainer);
		
		// -- end of User ID Field
		editUserContainer.add(userIdContainer);
			
		/*
		 *  Inner second container for User Name field
		 */
		JPanel userNameContainer = new JPanel();
		userNameContainer.setLayout(new BoxLayout(userNameContainer, BoxLayout.X_AXIS));
		userNameContainer.setBorder(new EmptyBorder(10, 0, 10, 0));
		
			// -- User Name Label
			JLabel userNameLabel = new JLabel();
			userNameLabel.setText("User Name:");
			userNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			userNameLabel.setAlignmentX(LEFT_ALIGNMENT);
			userNameContainer.add(userNameLabel);
						
			// Used to "pretty" up the Text Field
			JPanel usernameTextboxContainer = new JPanel();
			usernameTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			usernameTextboxContainer.setBorder(new EmptyBorder(0, 20, 0, 5));
			
			// -- User Name TextField
	    	JTextField userNameField = new JTextField("", 20);
	    	userNameField.setHorizontalAlignment(JTextField.LEFT);
	    	userNameField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	userNameField.setBorder(new LineBorder(Color.BLUE, 1));
	    	usernameTextboxContainer.add(userNameField);
			userNameContainer.add(usernameTextboxContainer);
		
		// -- end of User Id and Name Fields
		userFields.add(userIdContainer);
		userFields.add(userNameContainer);
			
		JPanel userSearchContainer = new JPanel();
		userSearchContainer.setLayout(new BoxLayout(userSearchContainer, BoxLayout.X_AXIS));
		userSearchContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
		
		// Find Button
		findButton.setName("findCourierButton");
		findButton.setOpaque(false);
		findButton.setContentAreaFilled(false);
		findButton.setBorder(new EmptyBorder(15, 0, 0, 0));
		findButton.addActionListener(editCourierController);
				
		userSearchContainer.add(userFields);
		userSearchContainer.add(findButton);
				
		editUserContainer.add(userSearchContainer);
				
		/*
		 *  Inner second container for 1st "Password" field
		 */
		JPanel password1Container = new JPanel();
		password1Container.setLayout(new BoxLayout(password1Container, BoxLayout.X_AXIS));
		password1Container.setBorder(new EmptyBorder(15, 25, 10, 10));
		
			// -- 1st New Password Label
			JLabel passwordLabel1 = new JLabel();
			passwordLabel1.setText("Password:");
			passwordLabel1.setFont(new Font("Calibri", Font.PLAIN, 24));
			passwordLabel1.setAlignmentX(LEFT_ALIGNMENT);
			password1Container.add(passwordLabel1);
					
			// Used to "pretty" up the Text Field
			JPanel password1TextboxContainer = new JPanel();
			password1TextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			password1TextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- 1st New Password TextField
	    	JPasswordField newPasswordField1 = new JPasswordField("", 20);
	    	newPasswordField1.setEchoChar('*');
	    	newPasswordField1.setHorizontalAlignment(JTextField.LEFT);
	    	newPasswordField1.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	newPasswordField1.setBorder(new LineBorder(Color.BLUE, 1));
	    	password1TextboxContainer.add(newPasswordField1);
			password1Container.add(password1TextboxContainer);
		
		// -- end of 1st "Password" Field
		editUserContainer.add(password1Container);
		
		/*
		 *  Inner third container for Retyping of "Password" field
		 */
		JPanel passwordContainer2 = new JPanel();
		passwordContainer2.setLayout(new BoxLayout(passwordContainer2, BoxLayout.X_AXIS));
		passwordContainer2.setBorder(new EmptyBorder(10, 25, 0, 10));
		
			// -- 2nd Password Label
			JLabel newPasswordLabel2 = new JLabel();
			newPasswordLabel2.setText("Retype Password:");
			newPasswordLabel2.setFont(new Font("Calibri", Font.PLAIN, 24));
			newPasswordLabel2.setAlignmentX(LEFT_ALIGNMENT);
			passwordContainer2.add(newPasswordLabel2);
			
			// Used to "pretty" up the Text Field
			JPanel password2TextboxContainer = new JPanel();
			password2TextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			password2TextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- 2nd Password TextField
	    	JPasswordField newPasswordField2 = new JPasswordField("", 20);
	    	newPasswordField2.setEchoChar('*');
	    	newPasswordField2.setHorizontalAlignment(JTextField.LEFT);
	    	newPasswordField2.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	newPasswordField2.setBorder(new LineBorder(Color.BLUE, 1));
	    	password2TextboxContainer.add(newPasswordField2);
	    	passwordContainer2.add(password2TextboxContainer);
		
		// -- end of 2nd "Password" Field
	    editUserContainer.add(passwordContainer2);	
		
	    /*
	     *  Inner fourth container for User Role Radio Buttons
	     */
	    JPanel roleRadioButtonsContainer = new JPanel();
	    roleRadioButtonsContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
	    roleRadioButtonsContainer.setBorder(new EmptyBorder(10, 25, 0, 50));
	    
	    	// -- User Role Label
	    	JLabel userRoleRB = new JLabel();
	    	userRoleRB.setText("User Role: ");
	    	userRoleRB.setFont(new Font("Calibri", Font.PLAIN, 26));
	    	userRoleRB.setAlignmentX(LEFT_ALIGNMENT);
	    	roleRadioButtonsContainer.add(userRoleRB);
	    	
	    	ButtonGroup radioButtons = new ButtonGroup();
	    	
	    	// User Role Radio Buttons   		    	
	    	JRadioButton standardUserSelection = new JRadioButton("User");
	    	standardUserSelection.setFont(new Font("Calibri", Font.PLAIN, 26));
	    	standardUserSelection.setSelected(true);
	    	
	    	JRadioButton adminUserSelection = new JRadioButton("Admin");
	    	adminUserSelection.setFont(new Font("Calibri", Font.PLAIN, 26));
	    	
	    	radioButtons.add(adminUserSelection);
	    	radioButtons.add(standardUserSelection);
	    	
	    	roleRadioButtonsContainer.add(standardUserSelection);
	    	roleRadioButtonsContainer.add(adminUserSelection);
	    
	    // -- end of 4th Field
	    editUserContainer.add(roleRadioButtonsContainer);
	 
	    // Container Status RBs, Reset and Save buttons
	 	JPanel statusAndButtonsContainer = new JPanel();
	 	statusAndButtonsContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
	 	statusAndButtonsContainer.setBorder(new EmptyBorder(10, 25, 10, 25));
	 		
	 	// Status RadioButtons
	 	JPanel statusRadioButtonsContainer = new JPanel();
	 	statusRadioButtonsContainer.setLayout(new BoxLayout(statusRadioButtonsContainer, BoxLayout.X_AXIS));
	 	statusRadioButtonsContainer.setBorder(new EmptyBorder(0, 0, 0, 50));
	 		    
	 	// -- Status Label
	 	JLabel activeStatusRBLabel = new JLabel();
	 	activeStatusRBLabel.setText("Status: ");
	 	activeStatusRBLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
	 	activeStatusRBLabel.setAlignmentX(LEFT_ALIGNMENT);
	 	statusRadioButtonsContainer.add(activeStatusRBLabel);
	 		    	
	 	ButtonGroup statusRadioButtons = new ButtonGroup();
	 		    	
	 	// User Status Radio Buttons   		    	
	 	JRadioButton activeStatusSelection = new JRadioButton("Active");
	 	activeStatusSelection.setFont(new Font("Calibri", Font.PLAIN, 26));
	 	activeStatusSelection.setSelected(true);
	 		    	
	 	JRadioButton inactiveStatusSelection = new JRadioButton("Inactive");
	 	inactiveStatusSelection.setFont(new Font("Calibri", Font.PLAIN, 26));
	 		    	
	 	statusRadioButtons.add(inactiveStatusSelection);
	 	statusRadioButtons.add(activeStatusSelection);
	 		    	
	 	statusRadioButtonsContainer.add(activeStatusSelection);
	 		    	
	 	statusRadioButtonsContainer.add(inactiveStatusSelection);
	 	    	
	 	statusAndButtonsContainer.add(statusRadioButtonsContainer);
	 		   
	 	// -- Reset Button
	 	resetButton.setName("resetButton");
	 	resetButton.setOpaque(false);
	 	resetButton.setContentAreaFilled(false);
	 	resetButton.setBorder(new EmptyBorder(0, 0, 0, 0));
	 	resetButton.addActionListener(editCourierController);
	 	statusAndButtonsContainer.add(resetButton);
	 	    
	    // -- Save Button
	 	saveButton.setName("saveButton");
	 	saveButton.setOpaque(false);
	 	saveButton.setContentAreaFilled(false);
	 	saveButton.setBorder(new EmptyBorder(5, 0, 0, 0));
	 	saveButton.addActionListener(editCourierController);
	 	statusAndButtonsContainer.add(saveButton);
	 	
	 	editUserContainer.add(statusAndButtonsContainer);

		// --- end of Box for Menu buttons
		
		mainPane.add(editUserContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("staffMaintBackButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 210));
		backButton.addActionListener(editCourierController);
		southButtonContainer.add(backButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 210, 0, 0));
		logoutButton.addActionListener(editCourierController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
    }	
}