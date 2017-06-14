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
public class UpdatePasswordScreen extends JPanel
{
	private JButton saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel updatePasswordContainer, southButtonContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
	private JPasswordField oldPasswordField = new JPasswordField("", 20);
	private JPasswordField newPasswordField1 = new JPasswordField("", 20);
	private JPasswordField newPasswordField2 = new JPasswordField("", 20);
	private JLabel saveMessageLabel = new JLabel();
    
    private ButtonController updatePasswordController;
    
    public UpdatePasswordScreen(ButtonController buttonController)
    {
    	updatePasswordController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
		buttonController.setViewListener(new ViewListener(){
			public Object GetView() {
				return UpdatePasswordScreen.this;
			}			

		});
    	
    	// Container for the menu buttons
    	updatePasswordContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 50, 0, 50);
    	updatePasswordContainer.setBorder(new CompoundBorder(margin, border));
    	updatePasswordContainer.setAlignmentX(CENTER_ALIGNMENT);
    	updatePasswordContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
    	southButtonContainer = new JPanel();
    	southButtonContainer.setBorder(new EmptyBorder(50, 5, 5, 5));
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
		imgContainer.setBorder(new EmptyBorder(0, 10, 15, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		updatePasswordContainer.setLayout(new BoxLayout(updatePasswordContainer, BoxLayout.Y_AXIS));
		updatePasswordContainer.setOpaque(false);
		
		JPanel updatePasswordScreenTitle = new JPanel();
		updatePasswordScreenTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
		updatePasswordScreenTitle.setBorder(new EmptyBorder(15, 15, 0, 00));
		
		
		// -- Update Password Label
		JLabel updatePasswordScreenLabel = new JLabel();
		updatePasswordScreenLabel.setText("Update Password:");
		updatePasswordScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		updatePasswordScreenLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
		updatePasswordScreenTitle.add(updatePasswordScreenLabel);
		
		updatePasswordContainer.add(updatePasswordScreenTitle);
		
		/*
		 *  Inner first container for "Old Password" field
		 */
		/*
		JPanel oldPasswordContainer = new JPanel();
		oldPasswordContainer.setLayout(new BoxLayout(oldPasswordContainer, BoxLayout.X_AXIS));
		oldPasswordContainer.setBorder(new EmptyBorder(35, 25, 5, 10));
		
			// -- Old Password Label
			JLabel oldPasswordLabel = new JLabel();
			oldPasswordLabel.setText("Old Password:");
			oldPasswordLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			oldPasswordLabel.setAlignmentX(LEFT_ALIGNMENT);
			oldPasswordContainer.add(oldPasswordLabel);
			
			// Used to "pretty" up the Text Field
			JPanel password1TextboxContainer = new JPanel();
			password1TextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			password1TextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- Old Password TextField
			oldPasswordField.setEchoChar('*');
			oldPasswordField.setHorizontalAlignment(JTextField.LEFT);
			oldPasswordField.setFont(new Font("Calibri", Font.PLAIN, 28));
			oldPasswordField.setBorder(new LineBorder(Color.BLUE, 1));
			password1TextboxContainer.add(oldPasswordField);
			oldPasswordContainer.add(password1TextboxContainer);
		
		// -- end of "Old Password" Field
		updatePasswordContainer.add(oldPasswordContainer);*/
			
		/*
		 *  Inner second container for 1st "New Password" field
		 */
		JPanel newPasswordContainer = new JPanel();
		newPasswordContainer.setLayout(new BoxLayout(newPasswordContainer, BoxLayout.X_AXIS));
		newPasswordContainer.setBorder(new EmptyBorder(10, 30, 5, 10));
		
			// -- 1st New Password Label
			JLabel newPasswordLabel1 = new JLabel();
			newPasswordLabel1.setText("New Password:");
			newPasswordLabel1.setFont(new Font("Calibri", Font.PLAIN, 24));
			newPasswordLabel1.setAlignmentX(LEFT_ALIGNMENT);
			newPasswordContainer.add(newPasswordLabel1);
			
			// Used to "pretty" up the Text Field
			JPanel password2TextboxContainer = new JPanel();
			password2TextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			password2TextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- 1st New Password TextField
	    	newPasswordField1.setEchoChar('*');
	    	newPasswordField1.setHorizontalAlignment(JTextField.LEFT);
	    	newPasswordField1.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	newPasswordField1.setBorder(new LineBorder(Color.BLUE, 1));
	    	password2TextboxContainer.add(newPasswordField1);
			newPasswordContainer.add(password2TextboxContainer);
		
		// -- end of 1st "New Password" Field
		updatePasswordContainer.add(newPasswordContainer);
		
		/*
		 *  Inner third container for Retyping of "New Password" field
		 */
		JPanel newPasswordContainer2 = new JPanel();
		newPasswordContainer2.setLayout(new BoxLayout(newPasswordContainer2, BoxLayout.X_AXIS));
		newPasswordContainer2.setBorder(new EmptyBorder(10, 25, 35, 10));
		
			// -- 2nd New Password Label
			JLabel newPasswordLabel2 = new JLabel();
			newPasswordLabel2.setText("Retype Password:");
			newPasswordLabel2.setFont(new Font("Calibri", Font.PLAIN, 24));
			newPasswordLabel2.setAlignmentX(LEFT_ALIGNMENT);
			newPasswordContainer2.add(newPasswordLabel2);

			// Used to "pretty" up the Text Field
			JPanel password3TextboxContainer = new JPanel();
			password3TextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			password3TextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- 2nd New Password TextField
	    	newPasswordField2.setEchoChar('*');
	    	newPasswordField2.setHorizontalAlignment(JTextField.LEFT);
	    	newPasswordField2.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	newPasswordField2.setBorder(new LineBorder(Color.BLUE, 1));
	    	password3TextboxContainer.add(newPasswordField2);
	    	newPasswordContainer2.add(password3TextboxContainer);
		
		// -- end of 2nd "New Password" Field
		updatePasswordContainer.add(newPasswordContainer2);		
		
		JPanel saveButtonContainer = new JPanel();
		saveButtonContainer.setLayout(new BoxLayout(saveButtonContainer, BoxLayout.X_AXIS));
		saveButtonContainer.setBorder(new EmptyBorder(5, 0, 15, 0));
		
		//Message Label
		saveMessageLabel.setBorder(new EmptyBorder(25, 10, 5, 5));
		saveMessageLabel.setText("");
		saveMessageLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		saveMessageLabel.setForeground(Color.RED);
		saveButtonContainer.add(saveMessageLabel);
		
        // -- Save Button
		saveButton.setName("saveButton");
		saveButton.setOpaque(false);
		saveButton.setContentAreaFilled(false);
		saveButton.setBorder(new EmptyBorder(5, 0, 0, 0));
		saveButton.addActionListener(updatePasswordController);
		saveButtonContainer.add(saveButton, BorderLayout.CENTER);
		
		updatePasswordContainer.add(saveButtonContainer);

		// --- end of Box for Menu buttons
		
		mainPane.add(updatePasswordContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("settingsBackButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 150));
		backButton.addActionListener(updatePasswordController);
		southButtonContainer.add(backButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 150, 0, 0));
		logoutButton.addActionListener(updatePasswordController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
    }
    
    public String GetOldPassword()
    {
    	return oldPasswordField.getText();
    }
    
    
    public String GetNewPassword1()
    {
    	return newPasswordField1.getText();
    }
    
    public String GetNewPassword2()
    {
    	return newPasswordField2.getText();
    }
    
    public void SetSaveMessage(String message)
    {
    	saveMessageLabel.setText(message);
    }
}
