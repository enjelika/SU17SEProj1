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
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
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
import courierDAO.CourierDAO;
import courierDAO.CustomerDAO;
import courierPD.Courier;
import courierPD.Customer;
import courierPD.Ticket;
import model.Utility;

@SuppressWarnings("serial")
public class EditDeliveryTicketScreen extends JPanel
{
	private JButton cancelTicketButton, printDirectionsButton, saveButton, backButton, findButton, logoutButton;
	private JLabel imageFrame;
	private JPanel editTicketScreenContainer, southButtonContainer, mainPane, imgContainer;
	
	public JTextField packageIdText, estBlocksText, estDeliveryTimeText, quotedPriceText, deliveryTimeText, pickUpTimeText, courierPickUpTimeText, courierDeliveredTimeText;
	public JRadioButton courierSelection;
	public JComboBox<String> courierNameCB;
	
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private List<Courier> couriers;
    private Courier activeCourier;
    
    int counter = 0;
    DateFormat dateFormat, timeFormat;
    String dateText, timeText, packageID;
    
    private Ticket currentTicket;
    
    private ButtonController editDeliveryTicketController;
    
    public EditDeliveryTicketScreen(ButtonController buttonController)
    {
    	editDeliveryTicketController = buttonController;
    	
		courierNameCB = new JComboBox<String>(); 
		
    	dateText = String.format("%02d", Calendar.MONTH) + "-" + String.format("%02d", Calendar.DAY_OF_MONTH) + "-17";
    	timeText = "" + Calendar.HOUR_OF_DAY + Calendar.MINUTE;
    	
    	packageID = buttonController.model.getPackageId();
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
		buttonController.setViewListener(new ViewListener(){
			public Object GetView() {
				return EditDeliveryTicketScreen.this;
			}			
		});
    	
    	// Container for the menu buttons
    	editTicketScreenContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 0, 0, 0);
    	editTicketScreenContainer.setBorder(new CompoundBorder(margin, border));
    	editTicketScreenContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
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
    	// Cancel Ticket Button
    	Image cancelTicketButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "cancelThisTicketButton.png");
    	cancelTicketButton = new JButton(new ImageIcon(cancelTicketButtonIcon));     	
    	
    	// Find Button
    	Image findButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "smFindButton.png");
    	findButton = new JButton(new ImageIcon(findButtonIcon)); 		
		
    	// Save Button
    	Image saveButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "smSaveButton.png");
    	saveButton = new JButton(new ImageIcon(saveButtonIcon));     	
    	
    	// Back Button
    	Image backButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "backButton2.png");
    	backButton = new JButton(new ImageIcon(backButtonIcon));
    	    	
    	// Print Directions Button
    	Image printDirectionsButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "printDirectionsButton.png");
    	printDirectionsButton = new JButton(new ImageIcon(printDirectionsButtonIcon));
    	
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
		
		// Screen Title: Delivery & Ticket Information  --space-- Date --space-- Time
		JPanel titleContainer = new JPanel();
		titleContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
				
			JLabel deliveryTicketScreen1Title = new JLabel("Delivery & Ticket Information");
			deliveryTicketScreen1Title.setFont(new Font("Calibri", Font.PLAIN, 26));
			deliveryTicketScreen1Title.setBorder(new EmptyBorder(0, 5, 0, 0));
			titleContainer.add(deliveryTicketScreen1Title);
			
			JLabel dateLabel = new JLabel("Date: " + dateText);
			dateLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
			dateLabel.setBorder(new EmptyBorder(0, 200, 0, 0));
			//titleContainer.add(dateLabel);
			
			JLabel timeLabel = new JLabel("Time: " + timeText);
			timeLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
			timeLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
			//titleContainer.add(timeLabel);
			
		overallTicketContainer.add(titleContainer);
						
		/*
		 *  Outer box for the Pick Up and Delivery Information
		 */
		editTicketScreenContainer.setLayout(new BoxLayout(editTicketScreenContainer, BoxLayout.Y_AXIS));
		editTicketScreenContainer.setOpaque(false);
		
		JPanel ticketPackageID = new JPanel();
		ticketPackageID.setLayout(new FlowLayout(FlowLayout.LEFT));
		ticketPackageID.setBorder(new EmptyBorder(5, 5, 0, 0));
				
		// -- Ticket Package ID Label
		JLabel ticketPackageIdLabel = new JLabel();
		ticketPackageIdLabel.setText("Package ID: ");
		ticketPackageIdLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		ticketPackageIdLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		ticketPackageID.add(ticketPackageIdLabel);
		
		// Package ID TextField
		Border b1 = new LineBorder(Color.BLUE, 1);
		Border m1 = new EmptyBorder(0, 5, 0, 0);
		packageIdText = new JTextField("", 15);
		packageIdText.setFont(new Font("Calibri", Font.PLAIN, 24));
		packageIdText.setBorder(new CompoundBorder(m1, b1));
		ticketPackageID.add(packageIdText);
		
		// Find Button
		findButton.addActionListener(editDeliveryTicketController);
		findButton.setName("findButton");
		findButton.setOpaque(false);
		findButton.setContentAreaFilled(false);
		findButton.setBorder(new EmptyBorder(0, 5, 0, 0));
		ticketPackageID.add(findButton);
		
		editTicketScreenContainer.add(ticketPackageID);
		
		// Courier Label and ComboBox
		JPanel courierNameCbContainer = new JPanel();
		courierNameCbContainer.setLayout(new BoxLayout(courierNameCbContainer, BoxLayout.X_AXIS));
		courierNameCbContainer.setBorder(new EmptyBorder(25, 25, 0, 0));
		
			// Courier Name Label
			JLabel courierNameLabel= new JLabel();
			courierNameLabel.setText("Courier:");
			courierNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			courierNameLabel.setBorder(new EmptyBorder(0, 5, 0, 15));
			courierNameCbContainer.add(courierNameLabel);
		
			// ComboBox
			Border bCB = new LineBorder(Color.BLUE, 1);
			Border mCB = new EmptyBorder(0, 15, 0, 25);
			courierNameCB.setFont(new Font("Calibri", Font.PLAIN, 24));
			courierNameCB.setBorder(new CompoundBorder(mCB, bCB));
			courierNameCB.addItemListener(new ItemListener() 
			{
		        public void itemStateChanged(ItemEvent arg0) 
		        {
		        	UpdateCourier(arg0);
		        }
		    });
			courierNameCbContainer.add(courierNameCB);
			
		editTicketScreenContainer.add(courierNameCbContainer);
		
		// Estimated Blocks --space-- Estimated Delivery Time
		JPanel estBlocksAndDeliveryTimeContainer = new JPanel();
		estBlocksAndDeliveryTimeContainer.setLayout(new BoxLayout(estBlocksAndDeliveryTimeContainer, BoxLayout.X_AXIS));
		estBlocksAndDeliveryTimeContainer.setBorder(new EmptyBorder(20, 0, 10, 25));
		
			JLabel estBlocksLabel = new JLabel("Estimated Blocks: ");
			estBlocksLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			estBlocksLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
			//estBlocksAndDeliveryTimeContainer.add(estBlocksLabel);
			
			estBlocksText = new JTextField();
			estBlocksText.setFont(new Font("Calibri", Font.PLAIN, 24));
			estBlocksText.setBorder(new LineBorder(Color.BLUE, 1));
			estBlocksText.setEditable(false);
			//estBlocksAndDeliveryTimeContainer.add(estBlocksText);
			
			JLabel estDeliveryTimeLabel = new JLabel("Estimated Delivery Time: ");
			estDeliveryTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			estDeliveryTimeLabel.setBorder(new EmptyBorder(0, 25, 0, 10));
			estBlocksAndDeliveryTimeContainer.add(estDeliveryTimeLabel);

			estDeliveryTimeText = new JTextField();
			estDeliveryTimeText.setFont(new Font("Calibri", Font.PLAIN, 24));
			estDeliveryTimeText.setBorder(new LineBorder(Color.BLUE, 1));
			estDeliveryTimeText.setEditable(false);
			estBlocksAndDeliveryTimeContainer.add(estDeliveryTimeText);
		
		editTicketScreenContainer.add(estBlocksAndDeliveryTimeContainer);
		
		// JPanel BoxLayout.X_AXIS
		JPanel outerBoxLayoutXaxisContainer = new JPanel();
		outerBoxLayoutXaxisContainer.setLayout(new BoxLayout(outerBoxLayoutXaxisContainer, BoxLayout.X_AXIS));
		outerBoxLayoutXaxisContainer.setBorder(new EmptyBorder(10, 0, 0, 25));
		
			JPanel firstInnerBoxLayoutYaxisContainer = new JPanel();
			firstInnerBoxLayoutYaxisContainer.setLayout(new BoxLayout(firstInnerBoxLayoutYaxisContainer, BoxLayout.Y_AXIS));
			firstInnerBoxLayoutYaxisContainer.setBorder(new EmptyBorder(25, 25, 0, 25));
			
				// JPanel BoxLayout.X_AXIS: Quoted Price Label & TextField
				JPanel quotedPriceBoxLayoutXaxis = new JPanel();
				quotedPriceBoxLayoutXaxis.setLayout(new BoxLayout(quotedPriceBoxLayoutXaxis, BoxLayout.X_AXIS));
				quotedPriceBoxLayoutXaxis.setBorder(new EmptyBorder(0, 0, 0, 25));
				
					JLabel quotedPriceLabel = new JLabel("Quoted Price: ");
					quotedPriceLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
					quotedPriceLabel.setBorder(new EmptyBorder(0, 0, 0, 25));
					//quotedPriceBoxLayoutXaxis.add(quotedPriceLabel);
					
					quotedPriceText = new JTextField();
					quotedPriceText.setFont(new Font("Calibri", Font.PLAIN, 24));
					quotedPriceText.setBorder(new LineBorder(Color.BLUE, 1));
					quotedPriceText.setEditable(false);
					//quotedPriceBoxLayoutXaxis.add(quotedPriceText);
			
				// JPanel BoxLayout.X_AXIS: Delivery Time Label & TextField
				JPanel deliveryTimeBoxLayoutXaxis = new JPanel();
				deliveryTimeBoxLayoutXaxis.setLayout(new BoxLayout(deliveryTimeBoxLayoutXaxis, BoxLayout.X_AXIS));
				deliveryTimeBoxLayoutXaxis.setBorder(new EmptyBorder(25, 0, 25, 25));
				
					JLabel deliveryTimeLabel = new JLabel("Delivery Time: ");
					deliveryTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
					deliveryTimeLabel.setBorder(new EmptyBorder(0, 0, 0, 25));
					//deliveryTimeBoxLayoutXaxis.add(deliveryTimeLabel);	
					
					deliveryTimeText = new JTextField();
					deliveryTimeText.setFont(new Font("Calibri", Font.PLAIN, 24));
					deliveryTimeText.setBorder(new LineBorder(Color.BLUE, 1));
					deliveryTimeText.setEditable(false);
					//deliveryTimeBoxLayoutXaxis.add(deliveryTimeText);
					
				firstInnerBoxLayoutYaxisContainer.add(quotedPriceBoxLayoutXaxis);
				firstInnerBoxLayoutYaxisContainer.add(deliveryTimeBoxLayoutXaxis);
		
			Border lineB = new LineBorder(Color.BLUE, 1);
			Border marginB = new EmptyBorder(0, 50, 0, 0);
			JPanel secondInnerBoxLayoutYaxisContainer = new JPanel();
			secondInnerBoxLayoutYaxisContainer.setLayout(new BoxLayout(secondInnerBoxLayoutYaxisContainer, BoxLayout.Y_AXIS));
			secondInnerBoxLayoutYaxisContainer.setBorder(new CompoundBorder(marginB, lineB));

				// JPanel BoxLayout.X_AXIS: Pick Up Time Label & TextField
				JPanel pickUpTimeBoxLayoutXaxis1 = new JPanel();
				pickUpTimeBoxLayoutXaxis1.setLayout(new BoxLayout(pickUpTimeBoxLayoutXaxis1, BoxLayout.X_AXIS));
				pickUpTimeBoxLayoutXaxis1.setBorder(new EmptyBorder(25, 25, 0, 25));
				
					JLabel pickUpTimeLabel1 = new JLabel("Pick Up Time: ");
					pickUpTimeLabel1.setFont(new Font("Calibri", Font.PLAIN, 24));
					pickUpTimeLabel1.setBorder(new EmptyBorder(0, 0, 0, 25));
					pickUpTimeBoxLayoutXaxis1.add(pickUpTimeLabel1);
					
					pickUpTimeText = new JTextField();
					pickUpTimeText.setFont(new Font("Calibri", Font.PLAIN, 24));
					pickUpTimeBoxLayoutXaxis1.add(pickUpTimeText);
			
				// JPanel BoxLayout.X_AXIS: Delivered Time Label & TextField
				JPanel deliveryTimeBoxLayoutXaxis1 = new JPanel();
				deliveryTimeBoxLayoutXaxis1.setLayout(new BoxLayout(deliveryTimeBoxLayoutXaxis1, BoxLayout.X_AXIS));
				deliveryTimeBoxLayoutXaxis1.setBorder(new EmptyBorder(25, 25, 25, 25));
					
					JLabel deliveryTimeLabel1 = new JLabel("Delivered Time: ");
					deliveryTimeLabel1.setFont(new Font("Calibri", Font.PLAIN, 24));
					deliveryTimeLabel1.setBorder(new EmptyBorder(0, 0, 0, 25));
					deliveryTimeBoxLayoutXaxis1.add(deliveryTimeLabel1);
						
					deliveryTimeText = new JTextField();
					deliveryTimeText.setFont(new Font("Calibri", Font.PLAIN, 24));
					deliveryTimeBoxLayoutXaxis1.add(deliveryTimeText);
		
				secondInnerBoxLayoutYaxisContainer.add(pickUpTimeBoxLayoutXaxis1);
				secondInnerBoxLayoutYaxisContainer.add(deliveryTimeBoxLayoutXaxis1);
					
			outerBoxLayoutXaxisContainer.add(firstInnerBoxLayoutYaxisContainer);
			outerBoxLayoutXaxisContainer.add(secondInnerBoxLayoutYaxisContainer);
			
		editTicketScreenContainer.add(outerBoxLayoutXaxisContainer);
			 
	    // Container Bonus --space-- Save buttons
	 	JPanel bonusAndSaveButtonContainer = new JPanel();
	 	bonusAndSaveButtonContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
	 	bonusAndSaveButtonContainer.setBorder(new EmptyBorder(25, 25, 5, 25));
		 	
		 	// -- Cancel Ticket Button
		 	cancelTicketButton.setName("cancelThisTicketButton");
		 	cancelTicketButton.setOpaque(false);
		 	cancelTicketButton.setContentAreaFilled(false);
		 	cancelTicketButton.setBorder(new EmptyBorder(0, 0, 0, 20));
		 	cancelTicketButton.addActionListener(editDeliveryTicketController);
		 	bonusAndSaveButtonContainer.add(cancelTicketButton);
		 	
		    // -- Save Button
		 	saveButton.setName("saveButton");
		 	saveButton.setOpaque(false);
		 	saveButton.setContentAreaFilled(false);
		 	saveButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		 	saveButton.addActionListener(editDeliveryTicketController);
		 	bonusAndSaveButtonContainer.add(saveButton);
	 	
	 	editTicketScreenContainer.add(bonusAndSaveButtonContainer);

		// --- end of Box for Menu buttons
			 	
	 	overallTicketContainer.add(editTicketScreenContainer);
		mainPane.add(overallTicketContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back and Logout buttons
		 */
        // -- Back Button
		backButton.setName("deliveryBackButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 70));
		backButton.addActionListener(editDeliveryTicketController);
		southButtonContainer.add(backButton);
		
		// -- Print Directions Button
		printDirectionsButton.setName("printDirectionsButton");
		printDirectionsButton.setOpaque(false);
		printDirectionsButton.setContentAreaFilled(false);
		printDirectionsButton.setBorder(new EmptyBorder(0, 70, 0, 70));
		printDirectionsButton.addActionListener(editDeliveryTicketController);
		southButtonContainer.add(printDirectionsButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 70, 0, 0));
		logoutButton.addActionListener(editDeliveryTicketController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		PopulateCourierData();
		this.add(mainPane);
    }
    
	private void UpdateCourier(ItemEvent arg0) {
		for (Courier courier : couriers) {
			if(arg0.getItem() == courier.getName())
			{
				activeCourier = courier;
			}
		}
	}
	
	public void PopulateCourierData()
    {
    	//Get Data
		couriers = CourierDAO.listCourier();
		for (Courier item : couriers) {
			if(item.getIsActive().equals("Y"))
			{
				courierNameCB.addItem(item.getName());
			}
		}
    }
    
	public Ticket GetTicket()
	{
		currentTicket.SetPickupTime(pickUpTimeText.getText());
		currentTicket.SetDeliveryTime(deliveryTimeText.getText());
		currentTicket.SetCourier(activeCourier);
		return currentTicket;
	}
	
    public String GetPackageID()
    {
    	return packageIdText.getText();
    }
    
    public void SetTicket(Ticket ticket)
    {
    	currentTicket = ticket;
    	estDeliveryTimeText.setText(ticket.GetEstimatedDeliveryTime());
    	
    }
}
