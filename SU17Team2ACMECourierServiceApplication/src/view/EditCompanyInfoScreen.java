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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import model.Utility;

@SuppressWarnings("serial")
public class EditCompanyInfoScreen extends JPanel
{
	private JButton resetButton, saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel editCompanyContainer, southButtonContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController editCompanyController;
    
    public EditCompanyInfoScreen(ButtonController buttonController)
    {
    	editCompanyController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	editCompanyContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 25, 0, 25);
    	editCompanyContainer.setBorder(new CompoundBorder(margin, border));
    	editCompanyContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
    	southButtonContainer = new JPanel();
    	southButtonContainer.setBorder(new EmptyBorder(85, 0, 5, 0));
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
         *  Logo header
         */
        imgContainer = new JPanel();	
		imgContainer.setSize(new Dimension(75, 50));
		imageFrame = new JLabel();
		imageFrame = new JLabel(new ImageIcon(acmeCourierServiceLogo));
		imgContainer.add((Component)imageFrame);
		imgContainer.setBorder(new EmptyBorder(0, 10, 5, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		editCompanyContainer.setLayout(new BoxLayout(editCompanyContainer, BoxLayout.Y_AXIS));
		editCompanyContainer.setOpaque(false);

		JPanel editCompanyInfoScreenTitle = new JPanel();
		editCompanyInfoScreenTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
		editCompanyInfoScreenTitle.setBorder(new EmptyBorder(10, 15, 0, 0));
				
		// -- Edit/Delete Courier Screen Label
		JLabel editCompanyInfoScreenLabel = new JLabel();
		editCompanyInfoScreenLabel.setText("Company Information:");
		editCompanyInfoScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
		editCompanyInfoScreenLabel.setBorder(new EmptyBorder(5, 5, 0, 425));
		editCompanyInfoScreenLabel.setAlignmentX(LEFT_ALIGNMENT);
		editCompanyInfoScreenTitle.add(editCompanyInfoScreenLabel);
		
		editCompanyContainer.add(editCompanyInfoScreenTitle);
		
		/*
		 *  Inner first container for Company Name field
		 */
		JPanel companyNameContainer = new JPanel();
		companyNameContainer.setLayout(new BoxLayout(companyNameContainer, BoxLayout.X_AXIS));
		companyNameContainer.setBorder(new EmptyBorder(35, 25, 10, 0));
		
			// -- Company Name Label
			JLabel companyNameLabel = new JLabel();
			companyNameLabel.setText("Company Name:");
			companyNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			companyNameLabel.setAlignmentX(LEFT_ALIGNMENT);
			companyNameContainer.add(companyNameLabel);
			
			// -- Company Name TextField
			Border borderO1 = new LineBorder(Color.BLUE, 1);
	    	Border marginO2 = new EmptyBorder(0, 60, 0, 25);
	    	JTextField courierIdField = new JTextField(" ACME Courier Service", 20);
			courierIdField.setHorizontalAlignment(JTextField.LEFT);
			courierIdField.setOpaque(false);
			courierIdField.setFont(new Font("Calibri", Font.PLAIN, 26));
			courierIdField.setBorder(new CompoundBorder(marginO2, borderO1));
			courierIdField.setEditable(false);
			companyNameContainer.add(courierIdField);
		
		// -- end of Company Name Field
		editCompanyContainer.add(companyNameContainer);
			
		/*
		 *  Inner second container for Company Address field
		 */
		JPanel companyAddressContainer = new JPanel();
		companyAddressContainer.setLayout(new BoxLayout(companyAddressContainer, BoxLayout.X_AXIS));
		companyAddressContainer.setBorder(new EmptyBorder(15, 25, 5, 0));
		
			// -- Company Address Label
			JLabel companyAddressLabel = new JLabel();
			companyAddressLabel.setText("Company Address:");
			companyAddressLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			companyAddressLabel.setAlignmentX(LEFT_ALIGNMENT);
			companyAddressContainer.add(companyAddressLabel);
			
			// Used to "pretty" up the Text Field
			JPanel nameTextboxContainer = new JPanel();
			nameTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			nameTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- Company Address TextField
	    	JTextField companyAddressField = new JTextField(" 4th Ave and D Street", 28);
	    	companyAddressField.setHorizontalAlignment(JTextField.LEFT);
	    	companyAddressField.setFont(new Font("Calibri", Font.PLAIN, 26));
	    	companyAddressField.setBorder(new LineBorder(Color.BLUE, 1));
	    	nameTextboxContainer.add(companyAddressField);
			companyAddressContainer.add(nameTextboxContainer);
		
		// -- end of Company Address Field
		editCompanyContainer.add(companyAddressContainer);
		
		// TODO: Bill Rate Field + Cost Per Block Field
		
		// TODO: Courier Speed Field -- space -- Blocks to a Mile Field
		
		// TODO: Bonus on Time Field -- space -- Pick Up Time Allowance Field
			
		// TODO: Bonus Time Variance (+/-) Field -- space -- Delivery Time Allowance Field
		
	    // Container Reset and Save buttons
		JPanel resetAndSaveButtonsContainer = new JPanel();
		resetAndSaveButtonsContainer.setLayout(new BoxLayout(resetAndSaveButtonsContainer, BoxLayout.X_AXIS));
		resetAndSaveButtonsContainer.setBorder(new EmptyBorder(10, 25, 10, 25));
		   
			// -- Reset Button
			resetButton.setName("resetButton");
			resetButton.setOpaque(false);
			resetButton.setContentAreaFilled(false);
			resetButton.setBorder(new EmptyBorder(0, 0, 0, 0));
			resetButton.addActionListener(editCompanyController);
			resetAndSaveButtonsContainer.add(resetButton);
		    
	        // -- Save Button
			saveButton.setName("saveButton");
			saveButton.setOpaque(false);
			saveButton.setContentAreaFilled(false);
			saveButton.setBorder(new EmptyBorder(5, 0, 0, 0));
			saveButton.addActionListener(editCompanyController);
			resetAndSaveButtonsContainer.add(saveButton);
		
		editCompanyContainer.add(resetAndSaveButtonsContainer);

		// --- end of Box for Menu buttons
		
		mainPane.add(editCompanyContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("courierMaintBackButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(10, 0, 0, 215));
		backButton.addActionListener(editCompanyController);
		southButtonContainer.add(backButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(10, 215, 0, 0));
		logoutButton.addActionListener(editCompanyController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
	}
}