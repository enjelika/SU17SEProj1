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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import courierPD.Customer;
import model.Utility;

@SuppressWarnings("serial")
public class AddCustomerScreen extends JPanel
{
	public Customer customer = new Customer();
	
	private JButton saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel addCustomerContainer, southButtonContainer, mainPane, imgContainer;
	
	public JTextField customerIdField, customerNameField, customerAddressField;
	
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController addCustomerController;
    
    public AddCustomerScreen(ButtonController buttonController)
    {
    	addCustomerController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	buttonController.setViewListener(new ViewListener(){
			public Object GetView() {
				return AddCustomerScreen.this;
			}			
		});
    	
    	// Container for the menu buttons
    	addCustomerContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 50, 0, 50);
    	addCustomerContainer.setBorder(new CompoundBorder(margin, border));
    	addCustomerContainer.setAlignmentX(CENTER_ALIGNMENT);
    	addCustomerContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
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
		imgContainer.setBorder(new EmptyBorder(0, 10, 0, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		/*
		 *  Outer box for the Main Menu buttons
		 */
		addCustomerContainer.setLayout(new BoxLayout(addCustomerContainer, BoxLayout.Y_AXIS));
		addCustomerContainer.setOpaque(false);
		
		JPanel addCustomerScreenTitle = new JPanel();
		addCustomerScreenTitle.setLayout(new BoxLayout(addCustomerScreenTitle, BoxLayout.X_AXIS));
		addCustomerScreenTitle.setBorder(new EmptyBorder(15, 15, 0, 200));
		
		
		// -- Add Courier Screen Label
		JLabel addCustomerScreenLabel = new JLabel();
		addCustomerScreenLabel.setText("Add a Customer:");
		addCustomerScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		addCustomerScreenLabel.setBorder(new EmptyBorder(5, 5, 0, 250));
		addCustomerScreenLabel.setAlignmentX(LEFT_ALIGNMENT);
		addCustomerScreenTitle.add(addCustomerScreenLabel);
		
		addCustomerContainer.add(addCustomerScreenTitle);
		
		/*
		 *  Inner first container for Customer ID field
		 */
		JPanel courierIdContainer = new JPanel();
		courierIdContainer.setLayout(new BoxLayout(courierIdContainer, BoxLayout.X_AXIS));
		courierIdContainer.setBorder(new EmptyBorder(75, 25, 10, 10));
		
			// -- Customer ID Label
			JLabel customerIdLabel = new JLabel();
			customerIdLabel.setText("Customer ID:");
			customerIdLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			customerIdLabel.setAlignmentX(LEFT_ALIGNMENT);
			courierIdContainer.add(customerIdLabel);
			
			// -- Customer ID TextField
			Border borderO1 = new LineBorder(Color.BLUE, 1);
	    	Border marginO2 = new EmptyBorder(0, 60, 0, 25);
	    	customerIdField = new JTextField("<auto-generated>");
			customerIdField.setHorizontalAlignment(JTextField.LEFT);
			customerIdField.setOpaque(false);
			customerIdField.setFont(new Font("Calibri", Font.PLAIN, 28));
			customerIdField.setBorder(new CompoundBorder(marginO2, borderO1));
			customerIdField.setEditable(false);
			courierIdContainer.add(customerIdField);
		
		// -- end of Courier ID Field
		addCustomerContainer.add(courierIdContainer);
			
		/*
		 *  Inner second container for Customer Name field
		 */
		JPanel customerNameContainer = new JPanel();
		customerNameContainer.setLayout(new BoxLayout(customerNameContainer, BoxLayout.X_AXIS));
		customerNameContainer.setBorder(new EmptyBorder(15, 25, 5, 10));
		
			// -- Customer Name Label
			JLabel customerNameLabel = new JLabel();
			customerNameLabel.setText("Customer Name:");
			customerNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			customerNameLabel.setAlignmentX(LEFT_ALIGNMENT);
			customerNameContainer.add(customerNameLabel);
			
			// Used to "pretty" up the Text Field
			JPanel nameTextboxContainer = new JPanel();
			nameTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			nameTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- Customer Name TextField
			customerNameField = new JTextField("", 20);
	    	customerNameField.setHorizontalAlignment(JTextField.LEFT);
	    	customerNameField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	customerNameField.setBorder(new LineBorder(Color.BLUE, 1));
	    	nameTextboxContainer.add(customerNameField);
			customerNameContainer.add(nameTextboxContainer);
		
		// -- end of Customer Name Field
		addCustomerContainer.add(customerNameContainer);
				
		/*
		 *  Inner third container for Customer Address field
		 */
		JPanel customerAddressContainer = new JPanel();
		customerAddressContainer.setLayout(new BoxLayout(customerAddressContainer, BoxLayout.X_AXIS));
		customerAddressContainer.setBorder(new EmptyBorder(15, 25, 5, 10));
		
			// -- Customer Address Label
			JLabel customerAddressLabel = new JLabel();
			customerAddressLabel.setText("Address:");
			customerAddressLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			customerAddressLabel.setAlignmentX(LEFT_ALIGNMENT);
			customerAddressContainer.add(customerAddressLabel);
			
			// Used to "pretty" up the Text Field
			JPanel addressTextboxContainer = new JPanel();
			addressTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			addressTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- Customer Address TextField
			customerAddressField = new JTextField("", 20);
	    	customerAddressField.setHorizontalAlignment(JTextField.LEFT);
	    	customerAddressField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	customerAddressField.setBorder(new LineBorder(Color.BLUE, 1));
	    	addressTextboxContainer.add(customerAddressField);
			customerAddressContainer.add(addressTextboxContainer);
		
		// -- end of Customer Name Field
		addCustomerContainer.add(customerAddressContainer);		
		
		JPanel saveButtonContainer = new JPanel();
		saveButtonContainer.setLayout(new BoxLayout(saveButtonContainer, BoxLayout.X_AXIS));
		saveButtonContainer.setBorder(new EmptyBorder(50, 0, 25, 0));
		
        // -- Save Button
		saveButton.setName("saveButton");
		saveButton.setOpaque(false);
		saveButton.setContentAreaFilled(false);
		saveButton.setBorder(new EmptyBorder(5, 0, 0, 0));
		saveButton.addActionListener(addCustomerController);
		saveButtonContainer.add(saveButton, BorderLayout.CENTER);
		
		addCustomerContainer.add(saveButtonContainer);

		// --- end of Box for Menu buttons
		
		mainPane.add(addCustomerContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("customerMaintBackButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 150));
		backButton.addActionListener(addCustomerController);
		southButtonContainer.add(backButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 150, 0, 0));
		logoutButton.addActionListener(addCustomerController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
    }
    
    public void SaveCustomer() 
    {
		customer.UpdateCustomer(
		customer.getCustomerID(), 
		customerNameField.getText(), 
		customerAddressField.getText(),
		"Y");
    }
    
    public void ClearText() 
    {
    	customerNameField.setText("");
    	customerAddressField.setText("");
    }
}
