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

@SuppressWarnings("serial")
public class AddUserScreen extends JPanel
{
	private JButton resetButton, saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel addNewUserContainer, southButtonContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
	private JTextField userNameField = new JTextField("", 28);
	private JPasswordField newPasswordField1 = new JPasswordField("", 28);
	private JPasswordField newPasswordField2 = new JPasswordField("", 28);
	private ButtonGroup radioButtons = new ButtonGroup();
	private JRadioButton standardUserSelection = new JRadioButton("User");
	private JRadioButton adminUserSelection = new JRadioButton("Admin");
	private JLabel saveMessageLabel = new JLabel();
    
    private ButtonController addCourierController;
    
    public AddUserScreen(ButtonController buttonController)
    {
    	addCourierController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
		buttonController.setViewListener(new ViewListener(){
			public Object GetView() {
				return AddUserScreen.this;
			}			

		});
    	
    	// Container for the menu buttons
    	addNewUserContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 50, 0, 50);
    	addNewUserContainer.setBorder(new CompoundBorder(margin, border));
    	addNewUserContainer.setAlignmentX(CENTER_ALIGNMENT);
    	addNewUserContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
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
		addNewUserContainer.setLayout(new BoxLayout(addNewUserContainer, BoxLayout.Y_AXIS));
		addNewUserContainer.setOpaque(false);
		
		JPanel addCourierScreenTitle = new JPanel();
		addCourierScreenTitle.setLayout(new BoxLayout(addCourierScreenTitle, BoxLayout.X_AXIS));
		addCourierScreenTitle.setBorder(new EmptyBorder(15, 15, 0, 450));
		
		
		// -- Add a New User Screen Label
		JLabel addNewUserScreenLabel = new JLabel();
		addNewUserScreenLabel.setText("Add a New User:");
		addNewUserScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		addNewUserScreenLabel.setBorder(new EmptyBorder(5, 5, 0, 200));
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
	    	JTextField userIdField = new JTextField("<auto-generated>");
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
						
			// Used to "pretty" up the Text Field
			JPanel usernameTextboxContainer = new JPanel();
			usernameTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			usernameTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- User Name TextField
	    	userNameField.setHorizontalAlignment(JTextField.LEFT);
	    	userNameField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	userNameField.setBorder(new LineBorder(Color.BLUE, 1));
	    	usernameTextboxContainer.add(userNameField);
			userNameContainer.add(usernameTextboxContainer);
		
		// -- end of 1st "New Password" Field
		addNewUserContainer.add(userNameContainer);
			
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
			password1TextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			password1TextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- 1st New Password TextField
	    	newPasswordField1.setEchoChar('*');
	    	newPasswordField1.setHorizontalAlignment(JTextField.LEFT);
	    	newPasswordField1.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	newPasswordField1.setBorder(new LineBorder(Color.BLUE, 1));
	    	password1TextboxContainer.add(newPasswordField1);
			password1Container.add(password1TextboxContainer);
		
		// -- end of 1st "Password" Field
		addNewUserContainer.add(password1Container);
		
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
			password2TextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			password2TextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- 2nd Password TextField
	    	newPasswordField2.setEchoChar('*');
	    	newPasswordField2.setHorizontalAlignment(JTextField.LEFT);
	    	newPasswordField2.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	newPasswordField2.setBorder(new LineBorder(Color.BLUE, 1));
	    	password2TextboxContainer.add(newPasswordField2);
	    	passwordContainer2.add(password2TextboxContainer);
		
		// -- end of 2nd "Password" Field
	    addNewUserContainer.add(passwordContainer2);	
		
	    /*
	     *  Inner fourth container for User Role Radio Buttons
	     */
	    JPanel roleRadioButtonsContainer = new JPanel();
	    roleRadioButtonsContainer.setLayout(new BoxLayout(roleRadioButtonsContainer, BoxLayout.X_AXIS));
	    roleRadioButtonsContainer.setBorder(new EmptyBorder(10, 25, 0, 50));
	    
	    	// -- User Role Label
	    	JLabel userRoleRB = new JLabel();
	    	userRoleRB.setText("User Role: ");
	    	userRoleRB.setFont(new Font("Calibri", Font.PLAIN, 24));
	    	userRoleRB.setAlignmentX(LEFT_ALIGNMENT);
	    	roleRadioButtonsContainer.add(userRoleRB);
	    	
	    	// User Role Radio Buttons   		    	
	    	standardUserSelection.setFont(new Font("Calibri", Font.PLAIN, 24));
	    	standardUserSelection.setSelected(true);
	    	
	    	adminUserSelection.setFont(new Font("Calibri", Font.PLAIN, 24));
	    	
	    	radioButtons.add(adminUserSelection);
	    	radioButtons.add(standardUserSelection);
	    	
	    	roleRadioButtonsContainer.add(standardUserSelection);
	    	roleRadioButtonsContainer.add(adminUserSelection);
	    
	    // -- end of 4th Field
	    addNewUserContainer.add(roleRadioButtonsContainer);
	    
		JPanel resetSaveButtonsContainer = new JPanel();
		resetSaveButtonsContainer.setLayout(new BoxLayout(resetSaveButtonsContainer, BoxLayout.X_AXIS));
		resetSaveButtonsContainer.setBorder(new EmptyBorder(25, 0, 20, 0));
		
		//Message Label
		saveMessageLabel.setBorder(new EmptyBorder(25, 10, 5, 5));
		saveMessageLabel.setText("");
		saveMessageLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		saveMessageLabel.setForeground(Color.RED);
		resetSaveButtonsContainer.add(saveMessageLabel);
		
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
		backButton.setName("staffMaintBackButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 210));
		backButton.addActionListener(addCourierController);
		southButtonContainer.add(backButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 210, 0, 0));
		logoutButton.addActionListener(addCourierController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
    }
    
    public String GetUserName()
    {
    	return userNameField.getText();
    }
    
    @SuppressWarnings("deprecation")
	public String GetPassword1()
    {
    	return newPasswordField1.getText();
    }
    
	public String GetPassword2()
    {
    	return newPasswordField2.getText();
    }
    
    public String GetUserType()
    {
    	String userType = "";
    	if(standardUserSelection.isSelected())
    		userType = "user";
    	if(adminUserSelection.isSelected())
    		userType = "admin";
    	
    	return userType;
    		
    }
    
    public void Reset()
    {
    	standardUserSelection.setSelected(true);
    	userNameField.setText("");
    	newPasswordField1.setText("");
    	newPasswordField2.setText("");
    }
    
    public void SetSaveMessage(String message)
    {
    	saveMessageLabel.setText(message);
    }
}
