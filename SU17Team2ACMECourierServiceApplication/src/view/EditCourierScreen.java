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

public class EditCourierScreen extends JPanel
{
	/**
	 * Auto-generated Serialization ID
	 */
	private static final long serialVersionUID = -5175333879969531286L;
	
	private JButton findButton, resetButton, saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel editCourierContainer, southButtonContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController editCourierController;
    
    public EditCourierScreen(ButtonController buttonController)
    {
    	editCourierController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	editCourierContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 25, 0, 25);
    	editCourierContainer.setBorder(new CompoundBorder(margin, border));
    	editCourierContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
    	southButtonContainer = new JPanel();
    	southButtonContainer.setBorder(new EmptyBorder(127, 0, 5, 0));
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
         *  Logo header
         */
        imgContainer = new JPanel();	
		imgContainer.setSize(new Dimension(75, 50));
		imageFrame = new JLabel();
		imageFrame = new JLabel(new ImageIcon(acmeCourierServiceLogo));
		imgContainer.add((Component)imageFrame);
		imgContainer.setBorder(new EmptyBorder(0, 10, 10, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		editCourierContainer.setLayout(new BoxLayout(editCourierContainer, BoxLayout.Y_AXIS));
		editCourierContainer.setOpaque(false);

		JPanel editCourierScreenTitle = new JPanel();
		editCourierScreenTitle.setLayout(new BoxLayout(editCourierScreenTitle, BoxLayout.X_AXIS));
		editCourierScreenTitle.setBorder(new EmptyBorder(10, 15, 0, 210));
				
		// -- Edit/Delete Courier Screen Label
		JLabel editCourierScreenLabel = new JLabel();
		editCourierScreenLabel.setText("Courier Information:");
		editCourierScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
		editCourierScreenLabel.setBorder(new EmptyBorder(5, 5, 0, 425));
		editCourierScreenLabel.setAlignmentX(LEFT_ALIGNMENT);
		editCourierScreenTitle.add(editCourierScreenLabel);
		
		editCourierContainer.add(editCourierScreenTitle);
		
		/*
		 *  Container for Courier ID field and Courier Name field
		 */
		JPanel courierFields = new JPanel();
		courierFields.setLayout(new BoxLayout(courierFields, BoxLayout.Y_AXIS));
		courierFields.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		/*
		 *  Inner first container for Courier ID field
		 */
		JPanel courierIdContainer = new JPanel();
		courierIdContainer.setLayout(new BoxLayout(courierIdContainer, BoxLayout.X_AXIS));
		courierIdContainer.setBorder(new EmptyBorder(35, 0, 5, 0));
		
			// -- Courier ID Label
			JLabel courierIdLabel = new JLabel();
			courierIdLabel.setText("Courier ID:");
			courierIdLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			courierIdLabel.setAlignmentX(LEFT_ALIGNMENT);
			courierIdContainer.add(courierIdLabel);
			
			// Used to "pretty" up the Text Field
			JPanel idTextboxContainer = new JPanel();
			idTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			idTextboxContainer.setBorder(new EmptyBorder(0, 10, 0, 0));
			
			// -- Courier ID TextField
	    	JTextField courierIdField = new JTextField("", 20);
			courierIdField.setHorizontalAlignment(JTextField.LEFT);
			courierIdField.setFont(new Font("Calibri", Font.PLAIN, 28));
			courierIdField.setBorder(new LineBorder(Color.BLUE, 1));
			idTextboxContainer.add(courierIdField);
			courierIdContainer.add(idTextboxContainer);
		
		// -- end of Courier ID Field
			
		/*
		 *  Inner second container for Courier Name field
		 */
		JPanel courierNameContainer = new JPanel();
		courierNameContainer.setLayout(new BoxLayout(courierNameContainer, BoxLayout.X_AXIS));
		courierNameContainer.setBorder(new EmptyBorder(15, 0, 5, 0));
		
			// -- Courier Name Label
			JLabel courierNameLabel = new JLabel();
			courierNameLabel.setText("Courier Name:");
			courierNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			courierNameLabel.setAlignmentX(LEFT_ALIGNMENT);
			courierNameContainer.add(courierNameLabel);
			
			// Used to "pretty" up the Text Field
			JPanel nameTextboxContainer = new JPanel();
			nameTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			nameTextboxContainer.setBorder(new EmptyBorder(0, 10, 0, 0));
			
			// -- Courier Name TextField
	    	JTextField courierNameField = new JTextField("", 20);
	    	courierNameField.setHorizontalAlignment(JTextField.LEFT);
	    	courierNameField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	courierNameField.setBorder(new LineBorder(Color.BLUE, 1));
	    	nameTextboxContainer.add(courierNameField);
			courierNameContainer.add(nameTextboxContainer);
		
		// -- end of Courier Name Field
		courierFields.add(courierIdContainer);
		courierFields.add(courierNameContainer);
		
		JPanel courierSearchContainer = new JPanel();
		courierSearchContainer.setLayout(new BoxLayout(courierSearchContainer, BoxLayout.X_AXIS));
		courierSearchContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
		
		// Find Button
		findButton.setName("findCourierButton");
		findButton.setOpaque(false);
		findButton.setContentAreaFilled(false);
		findButton.setBorder(new EmptyBorder(15, 0, 0, 0));
		findButton.addActionListener(editCourierController);
		
		courierSearchContainer.add(courierFields);
		courierSearchContainer.add(findButton);
		
		editCourierContainer.add(courierSearchContainer);
		
		/*
		 *  Average Delivery Time Field
		 */
		JPanel avgDeliveryTimeContainer = new JPanel();
		avgDeliveryTimeContainer.setLayout(new BoxLayout(avgDeliveryTimeContainer, BoxLayout.X_AXIS));
		avgDeliveryTimeContainer.setBorder(new EmptyBorder(15, 25, 5, 225));
		
			// -- Average Delivery Time Label
			JLabel avgDeliveryTimeLabel = new JLabel();
			avgDeliveryTimeLabel.setText("Avg Delivery Time:");
			avgDeliveryTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			avgDeliveryTimeContainer.add(avgDeliveryTimeLabel);
			
			// Used to "pretty" up the Text Field
			JPanel avgDeliveryTimeTextBoxContainer = new JPanel();
			avgDeliveryTimeTextBoxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			avgDeliveryTimeTextBoxContainer.setBorder(new EmptyBorder(0, 10, 0, 0));
						
			// -- Average Delivery Time TextField
	    	JTextField avgDeliveryTimeField = new JTextField("", 15);
	    	avgDeliveryTimeField.setHorizontalAlignment(JTextField.LEFT);
	    	avgDeliveryTimeField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	avgDeliveryTimeField.setBorder(new LineBorder(Color.BLUE, 1));
	    	avgDeliveryTimeTextBoxContainer.add(avgDeliveryTimeField);
	    	avgDeliveryTimeContainer.add(avgDeliveryTimeTextBoxContainer);
	    	
	    	// -- Average Delivery Time Measurement Label
	    	JLabel avgDeliveryTimeMeasureMentLabel = new JLabel();
	    	avgDeliveryTimeMeasureMentLabel.setText("minutes");
	    	avgDeliveryTimeMeasureMentLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
	    	avgDeliveryTimeContainer.add(avgDeliveryTimeMeasureMentLabel);
		
		// -- end of Average Delivery Time Field
	    editCourierContainer.add(avgDeliveryTimeContainer);
		
	    // Container Status RBs, Reset and Save buttons
		JPanel statusAndButtonsContainer = new JPanel();
		statusAndButtonsContainer.setLayout(new BoxLayout(statusAndButtonsContainer, BoxLayout.X_AXIS));
		statusAndButtonsContainer.setBorder(new EmptyBorder(10, 25, 10, 25));
		
			// Status RadioButtons
		    JPanel statusRadioButtonsContainer = new JPanel();
		    statusRadioButtonsContainer.setLayout(new BoxLayout(statusRadioButtonsContainer, BoxLayout.X_AXIS));
		    statusRadioButtonsContainer.setBorder(new EmptyBorder(0, 0, 0, 0)); //10, 25, 50, 50
		    
		    	// -- Status Label
		    	JLabel activeStatusRBLabel = new JLabel();
		    	activeStatusRBLabel.setText("Status: ");
		    	activeStatusRBLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	activeStatusRBLabel.setAlignmentX(LEFT_ALIGNMENT);
		    	statusRadioButtonsContainer.add(activeStatusRBLabel);
		    	
		    	ButtonGroup radioButtons = new ButtonGroup();
		    	
		    	// User Role Radio Buttons   		    	
		    	JRadioButton activeStatusSelection = new JRadioButton("Active");
		    	activeStatusSelection.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	activeStatusSelection.setSelected(true);
		    	
		    	JRadioButton inactiveStatusSelection = new JRadioButton("Inactive");
		    	inactiveStatusSelection.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	
		    	radioButtons.add(inactiveStatusSelection);
		    	radioButtons.add(activeStatusSelection);
		    	
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
		
		editCourierContainer.add(statusAndButtonsContainer);

		// --- end of Box for Menu buttons
		
		mainPane.add(editCourierContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("courierMaintBackButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(10, 0, 0, 215));
		backButton.addActionListener(editCourierController);
		southButtonContainer.add(backButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(10, 215, 0, 0));
		logoutButton.addActionListener(editCourierController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
	}
}