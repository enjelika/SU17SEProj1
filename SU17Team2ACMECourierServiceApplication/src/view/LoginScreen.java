package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

public class LoginScreen extends JPanel
{
	/**
	 * Auto-generated Serialization ID
	 */
	private static final long serialVersionUID = 8429357136772095411L;
	
	private JButton loginButton;
	private JLabel imageFrame;
	private JPanel loginCredentials, mainPane, imgContainer;
	private JTextField usernameTextbox = new JTextField("", 28);
	private JPasswordField passwordTextbox = new JPasswordField("", 28);
	
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController loginController;

    /*
     * Constructor
     */
    public LoginScreen(ButtonController buttonController)
    {
    	loginController = buttonController;
    	

		buttonController.setViewListener(new ViewListener(){
			public Object GetView() {
				return LoginScreen.this;
			}			

		});
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	loginCredentials = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 300, 75, 300);
    	loginCredentials.setBorder(new CompoundBorder(margin, border));
    	loginCredentials.setAlignmentX(CENTER_ALIGNMENT);
    	loginCredentials.setAlignmentY(CENTER_ALIGNMENT);
		
		// Set the Logo image for the North part of the window
		try 
		{ 
			acmeCourierServiceLogo = ImageIO.read(new File(filePath + separator + "images" + separator + "acmeCourierServiceLogo.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		Image loginButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "acmeLoginButton.png");
		loginButton = new JButton(new ImageIcon(loginButtonIcon));
    	
        SetUpView();
    }
    
    /*
     * Setting up the Login Screen View
     */
    public void SetUpView()
    {       
        // Logo header
        imgContainer = new JPanel();	
		imageFrame = new JLabel(new ImageIcon(acmeCourierServiceLogo));
		imgContainer.add((Component)imageFrame);
		imgContainer.setBorder(new EmptyBorder(35, 10, 35, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
                
        // Outer box for the following
		loginCredentials.setLayout(new BoxLayout(loginCredentials, BoxLayout.Y_AXIS));
		loginCredentials.setOpaque(false);
        
		// Used to left align the label
		JPanel usernameLabelContainer = new JPanel();
		usernameLabelContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		usernameLabelContainer.setBorder(new EmptyBorder(0, 17, 0, 0));
		
        // -- User name label
		JLabel usernameLabel = new JLabel();
		usernameLabel.setBorder(new EmptyBorder(50, 0, 5, 0));
		usernameLabel.setText("Username:");
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		usernameLabelContainer.add(usernameLabel);
		loginCredentials.add(usernameLabelContainer);
        
		// Used to "pretty" up the Text Field
		JPanel usernameTextboxContainer = new JPanel();
		usernameTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
		usernameTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
		
        // -- User name Text box
		usernameTextbox.setHorizontalAlignment(JTextField.CENTER);
		usernameTextbox.setFont(new Font("Calibri", Font.PLAIN, 28));
		usernameTextbox.setBorder(new LineBorder(Color.BLUE, 1));
		usernameTextboxContainer.add(usernameTextbox);
		loginCredentials.add(usernameTextboxContainer);
		
		// Used to left align the label
		JPanel passwordLabelContainer = new JPanel();
		passwordLabelContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		passwordLabelContainer.setBorder(new EmptyBorder(0, 20, 0, 0));
		
        // -- Password label
		JLabel passwordLabel = new JLabel();
		passwordLabel.setBorder(new EmptyBorder(25, 5, 5, 5));
		passwordLabel.setText("Password:");
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		passwordLabelContainer.add(passwordLabel);
		loginCredentials.add(passwordLabelContainer);
		
		// Used to "pretty" up the Text Field
		JPanel passwordTextboxContainer = new JPanel();
		passwordTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
		passwordTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
		
        // -- Password Textbox
		passwordTextbox.setEchoChar('*');
		passwordTextbox.setHorizontalAlignment(JTextField.CENTER);
		passwordTextbox.setFont(new Font("Calibri", Font.PLAIN, 28));
		passwordTextbox.setBorder(new LineBorder(Color.BLUE, 1));
		passwordTextboxContainer.add(passwordTextbox);
		loginCredentials.add(passwordTextboxContainer);
		
		JPanel loginButtonContainer = new JPanel();
		loginButtonContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
		
        // -- Login Button	
		loginButton.setName("loginButton");
		loginButton.setOpaque(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setBorder(new EmptyBorder(90, 25, 25, 0));
		loginButton.addActionListener(loginController);
		loginButtonContainer.add(loginButton);
		
		
		loginCredentials.add(loginButtonContainer);
		mainPane.add(loginCredentials); 
		this.add(mainPane);
    }
    
    public String GetUserName()
    {
    	return usernameTextbox.getText();
    }
    
    @SuppressWarnings("deprecation")
	public String GetPassword()
    {
    	return passwordTextbox.getText();
    }
}