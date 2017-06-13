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
import java.text.DateFormat;
import java.util.Calendar;

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
public class CreateDeliveryTicketScreen1 extends JPanel
{
	private JButton resetButton, nextButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel ticketScreen1Container, southButtonContainer, mainPane, imgContainer;
	public JTextField deliveryCustomerNumText, pickUpCustomerNumText;
		
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    int counter = 0;
    DateFormat dateFormat, timeFormat;
    String dateText, timeText, packageID;
    
    private ButtonController deliveryTicket1Controller;
    
    public CreateDeliveryTicketScreen1(ButtonController buttonController)
    {
    	deliveryTicket1Controller = buttonController;
    	
    	dateText = String.format("%02d", Calendar.MONTH) + "-" + String.format("%02d", Calendar.DAY_OF_MONTH) + "-17"; //TODO: YEAR!
    	timeText = "" + Calendar.HOUR_OF_DAY + Calendar.MINUTE;
    	
    	packageID = buttonController.model.getPackageId();
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	ticketScreen1Container = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 0, 0, 0);
    	ticketScreen1Container.setBorder(new CompoundBorder(margin, border));
    	ticketScreen1Container.setAlignmentY(CENTER_ALIGNMENT);
    	
    	southButtonContainer = new JPanel();
    	southButtonContainer.setBorder(new EmptyBorder(15, 5, 5, 5));
    	southButtonContainer.setLayout(new BoxLayout(southButtonContainer, BoxLayout.X_AXIS));
    	
		// Set the Logo image for the North part of the window
		try 
		{ 
			acmeCourierServiceLogo = ImageIO.read(new File(filePath + separator + "images" + separator + "exSmAcmeCourierServiceLogo.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
    	/*
    	 *  Setup the images for each button
    	 */    	
    	// Reset Button
    	Image resetButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "resetButton2.png");
    	resetButton = new JButton(new ImageIcon(resetButtonIcon)); 
    	
    	// Next Button
    	Image nextButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "nextButton.png");
    	nextButton = new JButton(new ImageIcon(nextButtonIcon));     	
    	
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
		
		JPanel overallTicketContainer = new JPanel();
		overallTicketContainer.setLayout(new BoxLayout(overallTicketContainer, BoxLayout.Y_AXIS));
		overallTicketContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
		
		JPanel titleContainer = new JPanel();
		titleContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// Screen Title: Delivery Ticket
		JLabel deliveryTicketScreen1Title = new JLabel("Delivery Ticket:");
		deliveryTicketScreen1Title.setFont(new Font("Calibri", Font.PLAIN, 26));
		deliveryTicketScreen1Title.setBorder(new EmptyBorder(0, 5, 0, 0));
		titleContainer.add(deliveryTicketScreen1Title);
		overallTicketContainer.add(titleContainer);
		
		// Pick Up and Delivery Information --space-- Date --space-- Time
		JPanel subtitleContainer = new JPanel();
		subtitleContainer.setLayout(new FlowLayout(FlowLayout.LEFT));	
		
		JPanel pickUpDeliveryInfoSubtitle = new JPanel();
		pickUpDeliveryInfoSubtitle.setLayout(new BoxLayout(pickUpDeliveryInfoSubtitle, BoxLayout.X_AXIS));
		pickUpDeliveryInfoSubtitle.setBorder(new EmptyBorder(0, 5, 0, 0));
		
		JLabel pickUpAndDeliveryLabel = new JLabel("Pick Up and Delivery Information");
		pickUpAndDeliveryLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
		pickUpAndDeliveryLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		pickUpDeliveryInfoSubtitle.add(pickUpAndDeliveryLabel);
		
		JLabel dateLabel = new JLabel("Date: " + dateText);
		dateLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
		dateLabel.setBorder(new EmptyBorder(0, 200, 0, 0));
		pickUpDeliveryInfoSubtitle.add(dateLabel);
		
		JLabel timeLabel = new JLabel("Time: " + timeText);
		timeLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
		timeLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
		pickUpDeliveryInfoSubtitle.add(timeLabel);
		subtitleContainer.add(pickUpDeliveryInfoSubtitle);
		overallTicketContainer.add(subtitleContainer);
		
		/*
		 *  Outer box for the Pick Up and Delivery Information
		 */
		ticketScreen1Container.setLayout(new BoxLayout(ticketScreen1Container, BoxLayout.Y_AXIS));
		ticketScreen1Container.setOpaque(false);
		
		JPanel ticketPackageID = new JPanel();
		ticketPackageID.setLayout(new FlowLayout(FlowLayout.LEFT));
		ticketPackageID.setBorder(new EmptyBorder(5, 5, 0, 0));
		
		
		// -- Ticket Package ID Label
		JLabel ticketPackageIdLabel = new JLabel();
		ticketPackageIdLabel.setText("Package ID: " + packageID);
		ticketPackageIdLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		ticketPackageIdLabel.setBorder(new EmptyBorder(5, 5, 0, 200));
		ticketPackageID.add(ticketPackageIdLabel);
		
		ticketScreen1Container.add(ticketPackageID);
		
		// Container for Pick Up Customer # Label & Field (un-editable)
		JPanel pickUpCustomerNumContainer = new JPanel();
		pickUpCustomerNumContainer.setLayout(new BoxLayout(pickUpCustomerNumContainer, BoxLayout.X_AXIS));
		pickUpCustomerNumContainer.setBorder(new EmptyBorder(0, 25, 0, 0));
		
			// -- Pick Up Customer Label
			JLabel pickUpCustomerLabel= new JLabel();
			pickUpCustomerLabel.setText("Pick Up Customer #:");
			pickUpCustomerLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			pickUpCustomerLabel.setBorder(new EmptyBorder(0, 5, 0, 0));
			pickUpCustomerNumContainer.add(pickUpCustomerLabel);
			
			// -- Pick Up Customer TextField
			Border b1 = new LineBorder(Color.BLUE, 1);
			Border m1 = new EmptyBorder(0, 15, 0, 500);
			pickUpCustomerNumText = new JTextField(" <test>", 5); // TODO: wire up to model to retrieve the Customer ID num from drop down selection
			pickUpCustomerNumText.setHorizontalAlignment(JTextField.LEFT);
			pickUpCustomerNumText.setFont(new Font("Calibri", Font.PLAIN, 26));
			pickUpCustomerNumText.setBorder(new CompoundBorder(m1, b1));
			pickUpCustomerNumText.setEditable(false);
			pickUpCustomerNumContainer.add(pickUpCustomerNumText);
			
		ticketScreen1Container.add(pickUpCustomerNumContainer);
		
		// TODO: Pick Up : Customer Name drop down
//		JPanel pickUpCustomerNameCbContainer = new JPanel();
//		pickUpCustomerNameCbContainer.setLayout(new BoxLayout(pickUpCustomerNumContainer, BoxLayout.X_AXIS));
//		pickUpCustomerNameCbContainer.setBorder(new EmptyBorder(0, 25, 0, 0));
//		
//			String[] tempArray = {"test1, test2"};
//			JComboBox<String> pickUpCustomerNameCB = new JComboBox<String>(tempArray); //deliveryTicket1Controller.model.getCustomerNames());
//			pickUpCustomerNameCB.setSelectedIndex(0);
//			pickUpCustomerNameCB.addActionListener(null); //TODO: Create an ActionListener for CBs to the controller package
//			pickUpCustomerNameCbContainer.add(pickUpCustomerNameCB);
//			
//		ticketScreen1Container.add(pickUpCustomerNameCbContainer);
		
		
		/*
		 *  Container for Pick Up Time --space-- Bill To radioButtons () Pick Up  () Delivery
		 */
		JPanel pickUpTimeAndBillToRBContainer = new JPanel();
		pickUpTimeAndBillToRBContainer.setLayout(new BoxLayout(pickUpTimeAndBillToRBContainer, BoxLayout.X_AXIS));
		pickUpTimeAndBillToRBContainer.setBorder(new EmptyBorder(15, 25, 10, 10));
		
			// -- Pick Up Time Label
			JLabel pickUpTimeLabel= new JLabel();
			pickUpTimeLabel.setText("Pick Up Time:");
			pickUpTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			pickUpTimeLabel.setAlignmentX(LEFT_ALIGNMENT);
			pickUpTimeAndBillToRBContainer.add(pickUpTimeLabel);
					
			// Used to "pretty" up the Text Field
			JPanel pickUpTimeTextboxContainer = new JPanel();
			pickUpTimeTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			pickUpTimeTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
			
			// -- Pick Up Time TextField
	    	JTextField pickUpTimeField = new JTextField("", 5);
	    	pickUpTimeField.setHorizontalAlignment(JTextField.LEFT);
	    	pickUpTimeField.setFont(new Font("Calibri", Font.PLAIN, 28));
	    	pickUpTimeField.setBorder(new LineBorder(Color.BLUE, 1));
	    	pickUpTimeTextboxContainer.add(pickUpTimeField);
			pickUpTimeAndBillToRBContainer.add(pickUpTimeTextboxContainer);
			 		
		 	// Bill To RadioButtons
		 	JPanel billToRadioButtonsContainer = new JPanel();
		 	billToRadioButtonsContainer.setLayout(new BoxLayout(billToRadioButtonsContainer, BoxLayout.X_AXIS));
		 	billToRadioButtonsContainer.setBorder(new EmptyBorder(0, 0, 0, 50));
		 	
		 	// -- Bill To Label
	    	JLabel billToRB = new JLabel();
	    	billToRB.setText("Bill To: ");
	    	billToRB.setFont(new Font("Calibri", Font.PLAIN, 26));
	    	billToRB.setAlignmentX(LEFT_ALIGNMENT);
	    	billToRadioButtonsContainer.add(billToRB);
	    	
	    	ButtonGroup radioButtons = new ButtonGroup();
	    	
	    	// Bill To Radio Buttons   		    	
	    	JRadioButton pickUpSelection = new JRadioButton("Pick Up");
	    	pickUpSelection.setFont(new Font("Calibri", Font.PLAIN, 26));
	    	pickUpSelection.setSelected(true);
	    	
	    	JRadioButton deliverySelection = new JRadioButton("Delivery");
	    	deliverySelection.setFont(new Font("Calibri", Font.PLAIN, 26));
	    	
	    	radioButtons.add(deliverySelection);
	    	radioButtons.add(pickUpSelection);
	    	
	    	billToRadioButtonsContainer.add(pickUpSelection);
	    	billToRadioButtonsContainer.add(deliverySelection);
	    	
	    	pickUpTimeAndBillToRBContainer.add(billToRadioButtonsContainer);
			
		// -- end of 1st "Password" Field
		ticketScreen1Container.add(pickUpTimeAndBillToRBContainer);
		
		// TODO: Delivery Customer # Label & Field (un-editable)
		JPanel deliveryCustomerNumContainer = new JPanel();
		deliveryCustomerNumContainer.setLayout(new BoxLayout(deliveryCustomerNumContainer, BoxLayout.X_AXIS));
		deliveryCustomerNumContainer.setBorder(new EmptyBorder(0, 25, 0, 0));
		
			// -- Delivery Customer Label
			JLabel deliveryCustomerLabel= new JLabel();
			deliveryCustomerLabel.setText("Delivery Customer #:");
			deliveryCustomerLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			deliveryCustomerLabel.setBorder(new EmptyBorder(0, 5, 0, 0));
			deliveryCustomerNumContainer.add(deliveryCustomerLabel);
			
			// -- Delivery Customer TextField
			Border b2 = new LineBorder(Color.BLUE, 1);
			Border m2 = new EmptyBorder(0, 15, 0, 500);
			deliveryCustomerNumText = new JTextField(" <test>", 5); // TODO: wire up to model to retrieve the Customer ID num from drop down selection
			deliveryCustomerNumText.setHorizontalAlignment(JTextField.LEFT);
			deliveryCustomerNumText.setFont(new Font("Calibri", Font.PLAIN, 26));
			deliveryCustomerNumText.setBorder(new CompoundBorder(m2, b2));
			deliveryCustomerNumText.setEditable(false);
			deliveryCustomerNumContainer.add(deliveryCustomerNumText);
			
		ticketScreen1Container.add(deliveryCustomerNumContainer);
		
		// TODO: Delivery : Customer Name drop down
			 
	    // Container Reset and Next buttons
	 	JPanel resetAndNextButtonsContainer = new JPanel();
	 	resetAndNextButtonsContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
	 	resetAndNextButtonsContainer.setBorder(new EmptyBorder(10, 25, 5, 25));
	 		    	 		   
	 	// -- Reset Button
	 	resetButton.setName("resetButton");
	 	resetButton.setOpaque(false);
	 	resetButton.setContentAreaFilled(false);
	 	resetButton.setBorder(new EmptyBorder(0, 0, 0, 0));
	 	resetButton.addActionListener(deliveryTicket1Controller);
	 	resetAndNextButtonsContainer.add(resetButton);
	 	    
	    // -- Next Button
	 	nextButton.setName("nextButton");
	 	nextButton.setOpaque(false);
	 	nextButton.setContentAreaFilled(false);
	 	nextButton.setBorder(new EmptyBorder(0, 0, 0, 0));
	 	nextButton.addActionListener(deliveryTicket1Controller);
	 	resetAndNextButtonsContainer.add(nextButton);
	 	
	 	ticketScreen1Container.add(resetAndNextButtonsContainer);

		// --- end of Box for Menu buttons
		
	 	
	 	overallTicketContainer.add(ticketScreen1Container);
		mainPane.add(overallTicketContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("deliveryTicketButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 210));
		backButton.addActionListener(deliveryTicket1Controller);
		southButtonContainer.add(backButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 210, 0, 0));
		logoutButton.addActionListener(deliveryTicket1Controller);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
    }
}