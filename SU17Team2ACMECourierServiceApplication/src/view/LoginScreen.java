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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.LoginController;
import model.Utility;

@SuppressWarnings("serial")
public class LoginScreen extends JFrame
{
	private JButton loginButton;
	private JLabel imageFrame;
	private JPanel loginCredentials, mainPane, imgContainer;
	
	private String title = "ACME Courier Service";
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private LoginController loginController;

    /*
     * Constructor
     */
    public LoginScreen()
    {
    	loginController = new LoginController();
    	
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
        setTitle(title);
        setSize(1000, 900);
        setLocationRelativeTo(null);
        JFrame.setDefaultLookAndFeelDecorated(true); 
        
        // Logo
        imgContainer = new JPanel();	
		imgContainer.setSize(new Dimension(75, 50));
		imageFrame = new JLabel();
		imageFrame = new JLabel(new ImageIcon(acmeCourierServiceLogo));
		imgContainer.add((Component)imageFrame);
		imgContainer.setBorder(new EmptyBorder(35, 10, 50, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
                
        // Outer box for the following
		loginCredentials.setLayout(new BoxLayout(loginCredentials, BoxLayout.Y_AXIS));
		loginCredentials.setOpaque(false);
		loginCredentials.setBounds(375, 440, 275, 250);
        
        // -- Username label
		JLabel usernameLabel = new JLabel();
		usernameLabel.setBorder(new EmptyBorder(75, 5, 5, 5));
		usernameLabel.setText("Username:");
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		usernameLabel.setAlignmentX(LEFT_ALIGNMENT);
		loginCredentials.add(usernameLabel);
        
        // -- Username Textbox
		Border borderT = new LineBorder(Color.BLUE, 1);
    	Border marginT = new EmptyBorder(0, 25, 0, 25);
		JTextField usernameTextbox = new JTextField("", 28);
		usernameTextbox.setHorizontalAlignment(JTextField.CENTER);
		usernameTextbox.setOpaque(false);
		usernameTextbox.setFont(new Font("Calibri", Font.PLAIN, 28));
		usernameTextbox.setBorder(new CompoundBorder(marginT, borderT));
		loginCredentials.add(usernameTextbox);
		
        // -- Password label
		JLabel passwordLabel = new JLabel();
		passwordLabel.setBorder(new EmptyBorder(50, 5, 5, 5));
		passwordLabel.setText("Password:");
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		loginCredentials.add(passwordLabel);
		
        // -- Password Textbox
		Border borderP = new LineBorder(Color.BLUE, 1);
    	Border marginP = new EmptyBorder(0, 25, 50, 25);
		JPasswordField passwordTextbox = new JPasswordField();
		passwordTextbox.setEchoChar('*');
		passwordTextbox.setHorizontalAlignment(JTextField.CENTER);
		passwordTextbox.setOpaque(false);
		passwordTextbox.setFont(new Font("Calibri", Font.PLAIN, 28));
		passwordTextbox.setBorder(new CompoundBorder(marginP, borderP));
		loginCredentials.add(passwordTextbox);
		
        // -- Login Button  ** CENTER THIS
		loginButton.setName("loginButton");
		loginButton.setOpaque(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setBorder(new EmptyBorder(75, 50, 25, 50));
		loginButton.addActionListener(loginController);
		loginCredentials.add(loginButton, BorderLayout.SOUTH);
		
		mainPane.add(loginCredentials, BorderLayout.CENTER);
		
		setContentPane(mainPane);       
    }
}