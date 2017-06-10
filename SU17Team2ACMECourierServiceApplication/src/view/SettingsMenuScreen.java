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
public class SettingsMenuScreen extends JPanel
{
	private JButton updatePasswordButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel settingsMenuContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController settingsMenuController;
    
    public SettingsMenuScreen(ButtonController buttonController)
    {
    	settingsMenuController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	settingsMenuContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 300, 150, 300);
    	settingsMenuContainer.setBorder(new CompoundBorder(margin, border));
    	settingsMenuContainer.setAlignmentX(CENTER_ALIGNMENT);
    	settingsMenuContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
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
    	// Update Password Button
    	Image updatePasswordButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "updatePasswordButton.png");
    	updatePasswordButton = new JButton(new ImageIcon(updatePasswordButtonIcon));    	
    	
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
		imgContainer.setBorder(new EmptyBorder(0, 10, 30, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		settingsMenuContainer.setLayout(new BoxLayout(settingsMenuContainer, BoxLayout.Y_AXIS));
		settingsMenuContainer.setOpaque(false);

		// -- Settings Menu Label
		JLabel settingsMenuLabel = new JLabel();
		settingsMenuLabel.setText("Settings");
		settingsMenuLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		settingsMenuLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
		settingsMenuLabel.setAlignmentX(LEFT_ALIGNMENT);
		settingsMenuContainer.add(settingsMenuLabel);
		
        // -- Update Password Button
		updatePasswordButton.setName("updatePasswordButton");
		updatePasswordButton.setOpaque(false);
		updatePasswordButton.setContentAreaFilled(false);
		updatePasswordButton.setBorder(new EmptyBorder(25, 75, 0, 75));
		updatePasswordButton.addActionListener(settingsMenuController);
		settingsMenuContainer.add(updatePasswordButton);
		
        // -- Back Button
		backButton.setName("backButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(25, 75, 5, 75));
		backButton.addActionListener(settingsMenuController);
		settingsMenuContainer.add(backButton);
		
		// --- end of Box for Menu buttons
		
		mainPane.add(settingsMenuContainer, BorderLayout.CENTER);
		
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(12, 215, 0, 0));
		logoutButton.addActionListener(settingsMenuController);
		mainPane.add(logoutButton, BorderLayout.SOUTH);
		this.add(mainPane);
    }
}
