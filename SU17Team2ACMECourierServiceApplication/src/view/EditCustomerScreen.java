package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import courierDAO.CustomerDAO;
import courierDAO.IntersectionsDAO;
import courierPD.Customer;
import courierPD.Intersections;
import model.Utility;

@SuppressWarnings("serial")
public class EditCustomerScreen extends JPanel
{
	public Customer customer = new Customer();
	
	private JButton findButton, resetButton, saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel editCustomerContainer, southButtonContainer, mainPane, imgContainer;
	private JComboBox<String> customerAddressComboBox, customerNameComboBox, customerIdComboBox;
	
	public JTextField customerIdField, customerNameField, addressField;
	public JRadioButton activeStatusSelection, inactiveStatusSelection;
	
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController editCustomerController;
    
    public EditCustomerScreen(ButtonController buttonController)
    {
    	editCustomerController = buttonController;
    	
    	buttonController.setViewListener(new ViewListener(){
			public Object GetView() {
				return EditCustomerScreen.this;
			}			
		});
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	editCustomerContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 25, 0, 25);
    	editCustomerContainer.setBorder(new CompoundBorder(margin, border));
    	editCustomerContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
    	southButtonContainer = new JPanel();
    	southButtonContainer.setBorder(new EmptyBorder(97, 0, 5, 0));
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
		editCustomerContainer.setLayout(new BoxLayout(editCustomerContainer, BoxLayout.Y_AXIS));
		editCustomerContainer.setOpaque(false);

		JPanel editCustomerScreenTitle = new JPanel();
		editCustomerScreenTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
		editCustomerScreenTitle.setBorder(new EmptyBorder(10, 15, 0, 0));
				
		// -- Edit/Delete Courier Screen Label
		JLabel editCourierScreenLabel = new JLabel();
		editCourierScreenLabel.setText("Customer Information:");
		editCourierScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
		editCourierScreenLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
		editCustomerScreenTitle.add(editCourierScreenLabel);
		
		editCustomerContainer.add(editCustomerScreenTitle);
		
		/*
		 *  Container for Customer ID field and Customer Name field
		 */
		JPanel customerFields = new JPanel();
		customerFields.setLayout(new BoxLayout(customerFields, BoxLayout.Y_AXIS));
		customerFields.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		/*
		 *  Inner first container for Customer ID field
		 */
		JPanel customerIdContainer = new JPanel();
		customerIdContainer.setLayout(new BoxLayout(customerIdContainer, BoxLayout.X_AXIS));
		customerIdContainer.setBorder(new EmptyBorder(35, 25, 5, 0));
		
			// -- Customer ID Label
			JLabel customerIdLabel = new JLabel();
			customerIdLabel.setText("Customer ID:");
			customerIdLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			customerIdLabel.setAlignmentX(LEFT_ALIGNMENT);
			customerIdContainer.add(customerIdLabel);
			
			// Used to "pretty" up the Text Field
			JPanel idTextboxContainer = new JPanel();
			idTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			idTextboxContainer.setBorder(new EmptyBorder(0, 10, 0, 0));
			
			// -- Customer ID TextField
			customerIdField = new JTextField("", 17);
			customerIdField.setHorizontalAlignment(JTextField.LEFT);
			customerIdField.setFont(new Font("Calibri", Font.PLAIN, 28));
			customerIdField.setBorder(new LineBorder(Color.BLUE, 1));
//			idTextboxContainer.add(customerIdField);
//			customerIdContainer.add(idTextboxContainer);
			
			// -- Customer Id ComboBox
			customerIdComboBox = new JComboBox<String>();
			customerIdComboBox.setPreferredSize(new Dimension(40, 10));
			customerIdComboBox.setFont(new Font("Calibri", Font.PLAIN, 24));
			PopulateCustomerIdDataComboBox();
			customerIdComboBox.addItemListener(new ItemListener() 
			{
		        public void itemStateChanged(ItemEvent arg0) 
		        {
		        	customerIdField.setText(arg0.getItem().toString());
		        }
		    });
			customerIdContainer.add(customerIdComboBox);

		// -- end of Customer ID Field
			
		/*
		 *  Inner second container for Customer Name field
		 */
		JPanel customerNameContainer = new JPanel();
		customerNameContainer.setLayout(new BoxLayout(customerNameContainer, BoxLayout.X_AXIS));
		customerNameContainer.setBorder(new EmptyBorder(15, 25, 5, 0));
		
			// -- Customer Name Label
			JLabel customerNameLabel = new JLabel();
			customerNameLabel.setText("Customer Name:");
			customerNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			customerNameLabel.setAlignmentX(LEFT_ALIGNMENT);
			customerNameContainer.add(customerNameLabel);
			
			// Used to "pretty" up the Text Field
			JPanel nameTextboxContainer = new JPanel();
			nameTextboxContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
			nameTextboxContainer.setBorder(new EmptyBorder(0, 10, 0, 0));
			
			// -- Customer Name TextField
			customerNameField = new JTextField("", 16);
	    	customerNameField.setHorizontalAlignment(JTextField.LEFT);
	    	customerNameField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	customerNameField.setBorder(new LineBorder(Color.BLUE, 1));
//	    	nameTextboxContainer.add(customerNameField);
//			customerNameContainer.add(nameTextboxContainer);
		
			// -- Customer Name ComboBox
			customerNameComboBox = new JComboBox<String>();
			customerNameComboBox.setPreferredSize(new Dimension(40, 10));
			customerNameComboBox.setFont(new Font("Calibri", Font.PLAIN, 24));
			PopulateCustomerNameDataComboBox();
			customerNameComboBox.addItemListener(new ItemListener() 
			{
		        public void itemStateChanged(ItemEvent arg0) 
		        {
		        	customerNameField.setText(arg0.getItem().toString());
		        }
		    });
			customerNameContainer.add(customerNameComboBox);
			
		// -- end of Customer Name Field
		customerFields.add(customerIdContainer);
		customerFields.add(customerNameContainer);
		
		JPanel customerSearchContainer = new JPanel();
		customerSearchContainer.setLayout(new BoxLayout(customerSearchContainer, BoxLayout.X_AXIS));
		customerSearchContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		// Find Button
		findButton.setName("findCustomerButton");
		findButton.setOpaque(false);
		findButton.setContentAreaFilled(false);
		findButton.setBorder(new EmptyBorder(15, 0, 0, 0));
		findButton.addActionListener(editCustomerController);
		
		customerSearchContainer.add(customerFields);
		customerSearchContainer.add(findButton);
		
		editCustomerContainer.add(customerSearchContainer);
		
		/*
		 *  Address Field
		 */
		JPanel addressContainer = new JPanel();
		addressContainer.setLayout(new BoxLayout(addressContainer, BoxLayout.X_AXIS));
		addressContainer.setBorder(new EmptyBorder(15, 25, 5, 25));
		
			// -- Address Label
			JLabel addressLabel = new JLabel();
			addressLabel.setText("Address:");
			addressLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			addressContainer.add(addressLabel);
			
			// Used to "pretty" up the Text Field
			JPanel addressTextBoxContainer = new JPanel();
			addressTextBoxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			addressTextBoxContainer.setBorder(new EmptyBorder(0, 10, 0, 0));
						
			// -- Address TextField
			addressField = new JTextField("", 20);
	    	addressField.setHorizontalAlignment(JTextField.LEFT);
	    	addressField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	addressField.setBorder(new LineBorder(Color.BLUE, 1));
	    	addressTextBoxContainer.add(addressField);
	    	addressContainer.add(addressTextBoxContainer);
		
	    	// -- Customer Address ComboBox
			customerAddressComboBox = new JComboBox<String>();
//			customerAddressComboBox.setPreferredSize(new Dimension(40, 10));
			customerAddressComboBox.setFont(new Font("Calibri", Font.PLAIN, 24));
			PopulateAddressDataComboBox();
			customerAddressComboBox.addItemListener(new ItemListener() 
			{
		        public void itemStateChanged(ItemEvent arg0) 
		        {
		        	addressField.setText(arg0.getItem().toString());
		        }
		    });
			addressContainer.add(customerAddressComboBox);
	    	
		// -- end of Address Field
	    editCustomerContainer.add(addressContainer);
		
	    // Container Status RBs, Reset and Save buttons
		JPanel statusAndButtonsContainer = new JPanel();
		statusAndButtonsContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		statusAndButtonsContainer.setBorder(new EmptyBorder(10, 25, 10, 25));
		
			// Status RadioButtons
		    JPanel statusRadioButtonsContainer = new JPanel();
		    statusRadioButtonsContainer.setLayout(new BoxLayout(statusRadioButtonsContainer, BoxLayout.X_AXIS));
		    statusRadioButtonsContainer.setBorder(new EmptyBorder(0, 0, 0, 0)); 
		    
		    	// -- Status Label
		    	JLabel activeStatusRBLabel = new JLabel();
		    	activeStatusRBLabel.setText("Status: ");
		    	activeStatusRBLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	activeStatusRBLabel.setAlignmentX(LEFT_ALIGNMENT);
		    	statusRadioButtonsContainer.add(activeStatusRBLabel);
		    	
		    	ButtonGroup radioButtons = new ButtonGroup();
		    	
		    	// User Role Radio Buttons   		    	
		    	activeStatusSelection = new JRadioButton("Active");
		    	activeStatusSelection.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	activeStatusSelection.setSelected(true);
		    	
		    	inactiveStatusSelection = new JRadioButton("Inactive");
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
		resetButton.setBorder(new EmptyBorder(0, 150, 0, 0));
		resetButton.addActionListener(editCustomerController);
		statusAndButtonsContainer.add(resetButton);
	    
        // -- Save Button
		saveButton.setName("saveButton");
		saveButton.setOpaque(false);
		saveButton.setContentAreaFilled(false);
		saveButton.setBorder(new EmptyBorder(5, 0, 0, 0));
		saveButton.addActionListener(editCustomerController);
		statusAndButtonsContainer.add(saveButton);
		
		editCustomerContainer.add(statusAndButtonsContainer);

		// --- end of Box for Menu buttons
		
		mainPane.add(editCustomerContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("customerMaintBackButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(10, 0, 0, 215));
		backButton.addActionListener(editCustomerController);
		southButtonContainer.add(backButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(10, 215, 0, 0));
		logoutButton.addActionListener(editCustomerController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
	}
    
    public void SaveCustomer() 
    {
    	String isActive = "N";
    	if(activeStatusSelection.isSelected()) 
    	{
    		isActive = "Y";
    	}
		customer.UpdateCustomer(
		Long.parseLong(customerIdField.getText()), 
		customerNameField.getText(), 
		addressField.getText(),
		isActive);
    }
    
    public void UpdateText() 
    {
    	customerIdField.setText(Long.toString(customer.getCustomerID()));
    	customerNameField.setText(customer.getName());
    	addressField.setText(customer.getAddress());
    	if(customer.getIsActive() == "Y") 
    	{
    		activeStatusSelection.setSelected(true);
    	}
    	else
    	{
    		inactiveStatusSelection.setSelected(true);
    	}
    }
    
    public void ClearText() 
    {
    	customerIdField.setText("");
    	customerNameField.setText("");
    	addressField.setText("");
    	activeStatusSelection.setSelected(true);
    }
    
    // Validate the input customer's address
    public boolean ValidateAddress(String address) 
    {
    	boolean isValidAddress = false;
    	List<Intersections> intersections = IntersectionsDAO.listIntersections();
		for(Intersections intersection : intersections) 
    	{
			if(address.equals(intersection.getStreet2() + " And " + intersection.getStreet1()))
			{
				isValidAddress = true; 
				break;
			}
    	}
		return isValidAddress;
    }
    
    // Populate address data for combo box
    private void PopulateAddressDataComboBox()
    {
    	//Get Data
    	List<Intersections> intersections = IntersectionsDAO.listIntersections();
    	for(Intersections intersection : intersections) 
    	{
    		customerAddressComboBox.addItem(intersection.getStreet2() + " And " + intersection.getStreet1());
		}
    }
    
    // Populate customer name data for combo box
    private void PopulateCustomerNameDataComboBox()
    {
    	//Get Data
    	List<Customer> customers = CustomerDAO.ListCustomer();
    	for(Customer customer : customers) 
    	{
    		customerNameComboBox.addItem(customer.getName());
		}
    }
    
    // Populate customer id data for combo box
    private void PopulateCustomerIdDataComboBox()
    {
    	//Get Data
    	List<Customer> customers = CustomerDAO.ListCustomer();
    	for(Customer customer : customers) 
    	{
    		customerIdComboBox.addItem(Long.toString(customer.getCustomerID()));
		}
    }
}
