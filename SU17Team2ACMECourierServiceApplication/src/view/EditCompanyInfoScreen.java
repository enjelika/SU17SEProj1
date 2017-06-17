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
import courierDAO.CompanyInfoDAO;
import courierPD.CompanyInfo;
import model.Utility;

@SuppressWarnings("serial")
public class EditCompanyInfoScreen extends JPanel
{
	public CompanyInfo companyInfo = new CompanyInfo();
	
	private JButton resetButton, saveButton, backButton, logoutButton;
	private JLabel imageFrame;
	private JPanel editCompanyContainer, southButtonContainer, mainPane, imgContainer;

	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    private ButtonController editCompanyController;
    
    public JTextField courierIdField, companyAddressField, billRateField, costPerBlockField,
    			courierSpeedField, blocksToMileField, bonusOnTimeField, pickUpTimeField,
    			bonusTimeVarianceField, deliveryTimeField;
    
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
    	southButtonContainer.setBorder(new EmptyBorder(0, 0, 10, 0));
    	southButtonContainer.setLayout(new BoxLayout(southButtonContainer, BoxLayout.X_AXIS));
    	
    	buttonController.setViewListener(new ViewListener()
    	{
			public Object GetView() 
			{
				return EditCompanyInfoScreen.this;
			}			

		});
    	
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
    	
    	// Obtain company info from the db
    	companyInfo = CompanyInfoDAO.findCompanyInfo("ACME Courier Service");
    	UpdateText();
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
		editCompanyInfoScreenTitle.setBorder(new EmptyBorder(5, 5, 0, 0));
				
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
		companyNameContainer.setBorder(new EmptyBorder(10, 25, 5, 0));
		
			// -- Company Name Label
			JLabel companyNameLabel = new JLabel();
			companyNameLabel.setText("Company Name:");
			companyNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
			companyNameLabel.setAlignmentX(LEFT_ALIGNMENT);
			companyNameContainer.add(companyNameLabel);
			
			// -- Company Name TextField
			Border borderO1 = new LineBorder(Color.BLUE, 1);
	    	Border marginO2 = new EmptyBorder(0, 60, 0, 25);
	    	courierIdField = new JTextField("ACME Courier Service", 20);
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
			companyAddressField = new JTextField("4th Ave and D Street", 28);
	    	companyAddressField.setHorizontalAlignment(JTextField.LEFT);
	    	companyAddressField.setFont(new Font("Calibri", Font.PLAIN, 26));
	    	companyAddressField.setBorder(new LineBorder(Color.BLUE, 1));
	    	nameTextboxContainer.add(companyAddressField);
			companyAddressContainer.add(nameTextboxContainer);
		
		// -- end of Company Address Field
		editCompanyContainer.add(companyAddressContainer);
		
		// Bill Rate Field + Cost Per Block Field
		JPanel billRateAndCostPerBlockContainer = new JPanel();
		billRateAndCostPerBlockContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
		billRateAndCostPerBlockContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
		
			JPanel billRateContainer = new JPanel();
			billRateContainer.setLayout(new BoxLayout(billRateContainer, BoxLayout.X_AXIS));
			billRateContainer.setBorder(new EmptyBorder(5, 25, 5, 0));
			
				// -- Bill Rate Label
				JLabel billRateLabel = new JLabel();
				billRateLabel.setText("Bill Rate:   $");
				billRateLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
				billRateLabel.setAlignmentX(LEFT_ALIGNMENT);
				billRateContainer.add(billRateLabel);
				
				// Used to "pretty" up the Text Field
				JPanel billRateTextboxContainer = new JPanel();
				billRateTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
				billRateTextboxContainer.setBorder(new EmptyBorder(0, 0, 0, 10));
				
				// -- Bill Rate TextField
				billRateField = new JTextField("10", 5);
		    	billRateField.setHorizontalAlignment(JTextField.CENTER);
		    	billRateField.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	billRateField.setBorder(new LineBorder(Color.BLUE, 1));
		    	billRateTextboxContainer.add(billRateField);
		    	billRateContainer.add(billRateTextboxContainer);
		    	
		    	// -- Cost per Block Label
				JLabel costPerBlockLabel = new JLabel();
				costPerBlockLabel.setText("     +     Cost per Block:  $");
				costPerBlockLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
				costPerBlockLabel.setAlignmentX(LEFT_ALIGNMENT);
				billRateContainer.add(costPerBlockLabel);
				
				// Used to "pretty" up the Text Field
				JPanel costPerBlockTextboxContainer = new JPanel();
				costPerBlockTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
				costPerBlockTextboxContainer.setBorder(new EmptyBorder(0, 0, 0, 25));
				
				// -- Cost per Block TextField
				costPerBlockField = new JTextField("2", 5);
		    	costPerBlockField.setHorizontalAlignment(JTextField.CENTER);
		    	costPerBlockField.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	costPerBlockField.setBorder(new LineBorder(Color.BLUE, 1));
		    	costPerBlockTextboxContainer.add(costPerBlockField);
		    	billRateContainer.add(costPerBlockTextboxContainer);
		
		    	billRateAndCostPerBlockContainer.add(billRateContainer);
		    	
		editCompanyContainer.add(billRateAndCostPerBlockContainer);
		    	
		// Courier Speed Field -- space -- Blocks to a Mile Field
		JPanel courierSpeedAndBlocksToMileContainer = new JPanel();
		courierSpeedAndBlocksToMileContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		courierSpeedAndBlocksToMileContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
				
				JPanel courierSpeedContainer = new JPanel();
				courierSpeedContainer.setLayout(new BoxLayout(courierSpeedContainer, BoxLayout.X_AXIS));
				courierSpeedContainer.setBorder(new EmptyBorder(5, 25, 5, 0));
					
					// -- Courier Speed Label
					JLabel courierSpeedLabel = new JLabel();
					courierSpeedLabel.setText("Courier Speed:");
					courierSpeedLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
					courierSpeedLabel.setAlignmentX(LEFT_ALIGNMENT);
					courierSpeedContainer.add(courierSpeedLabel);
						
					// Used to "pretty" up the Text Field
					JPanel courierSpeedTextboxContainer = new JPanel();
					courierSpeedTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
					courierSpeedTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 205));
						
					// -- Courier Speed TextField
					courierSpeedField = new JTextField("10", 5);
			    	courierSpeedField.setHorizontalAlignment(JTextField.CENTER);
			    	courierSpeedField.setFont(new Font("Calibri", Font.PLAIN, 26));
			    	courierSpeedField.setBorder(new LineBorder(Color.BLUE, 1));
			    	courierSpeedTextboxContainer.add(courierSpeedField);
			    	courierSpeedContainer.add(courierSpeedTextboxContainer);
			    	
			    	// -- Courier Speed mph label
			    	JLabel courierSpeedMphLabel = new JLabel("mph");
			    	courierSpeedMphLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
			    	courierSpeedTextboxContainer.add(courierSpeedMphLabel);
			    	courierSpeedContainer.add(courierSpeedTextboxContainer);
				    	
			    	// -- Blocks to a Mile Label
					JLabel blockToMileLabel = new JLabel();
					blockToMileLabel.setText("Blocks to a Mile:");
					blockToMileLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
					blockToMileLabel.setAlignmentX(LEFT_ALIGNMENT);
					courierSpeedContainer.add(blockToMileLabel);
						
					// Used to "pretty" up the Text Field
					JPanel blocksToMileTextboxContainer = new JPanel();
					blocksToMileTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
					blocksToMileTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
						
					// -- Blocks to a Mile TextField
					blocksToMileField = new JTextField("10", 5);
			    	blocksToMileField.setHorizontalAlignment(JTextField.CENTER);
			    	blocksToMileField.setFont(new Font("Calibri", Font.PLAIN, 26));
			    	blocksToMileField.setBorder(new LineBorder(Color.BLUE, 1));
			    	blocksToMileTextboxContainer.add(blocksToMileField);
			    	courierSpeedContainer.add(blocksToMileTextboxContainer);
				
			    	courierSpeedAndBlocksToMileContainer.add(courierSpeedContainer);
				    	
		editCompanyContainer.add(courierSpeedAndBlocksToMileContainer);
				
		// Bonus on Time Field -- space -- Pick Up Time Allowance Field
		JPanel bonusOnTimeAndPickUpTimeContainer = new JPanel();
		bonusOnTimeAndPickUpTimeContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		bonusOnTimeAndPickUpTimeContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
				
				JPanel bonusOnTimeContainer = new JPanel();
				bonusOnTimeContainer.setLayout(new BoxLayout(bonusOnTimeContainer, BoxLayout.X_AXIS));
				bonusOnTimeContainer.setBorder(new EmptyBorder(5, 25, 5, 0));
					
					// -- Bonus on Time Label
					JLabel bonusOnTimeLabel = new JLabel();
					bonusOnTimeLabel.setText("Bonus on Time:  $");
					bonusOnTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
					bonusOnTimeLabel.setAlignmentX(LEFT_ALIGNMENT);
					bonusOnTimeContainer.add(bonusOnTimeLabel);
						
					// Used to "pretty" up the Text Field
					JPanel bonusOnTimeTextboxContainer = new JPanel();
					bonusOnTimeTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
					bonusOnTimeTextboxContainer.setBorder(new EmptyBorder(0, 0, 0, 115));
						
					// -- Bonus on Time TextField
					bonusOnTimeField = new JTextField("2", 5);
			    	bonusOnTimeField.setHorizontalAlignment(JTextField.CENTER);
			    	bonusOnTimeField.setFont(new Font("Calibri", Font.PLAIN, 26));
			    	bonusOnTimeField.setBorder(new LineBorder(Color.BLUE, 1));
			    	bonusOnTimeTextboxContainer.add(bonusOnTimeField);
			    	bonusOnTimeContainer.add(bonusOnTimeTextboxContainer);
				    	
			    	// -- Pick Up Time Allowance Label
					JLabel pickUpTimeLabel = new JLabel();
					pickUpTimeLabel.setText("Pick Up Time Allowance:");
					pickUpTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
					pickUpTimeLabel.setAlignmentX(LEFT_ALIGNMENT);
					bonusOnTimeContainer.add(pickUpTimeLabel);
						
					// Used to "pretty" up the Text Field
					JPanel pickUpTimeTextboxContainer = new JPanel();
					pickUpTimeTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
					pickUpTimeTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
						
					// -- Pick Up Time Allowance TextField
					pickUpTimeField = new JTextField("10", 5);
			    	pickUpTimeField.setHorizontalAlignment(JTextField.CENTER);
			    	pickUpTimeField.setFont(new Font("Calibri", Font.PLAIN, 26));
			    	pickUpTimeField.setBorder(new LineBorder(Color.BLUE, 1));
			    	pickUpTimeTextboxContainer.add(pickUpTimeField);
			    	bonusOnTimeContainer.add(pickUpTimeTextboxContainer);
				
			    	bonusOnTimeAndPickUpTimeContainer.add(bonusOnTimeContainer);
				    	
		editCompanyContainer.add(bonusOnTimeAndPickUpTimeContainer);
			
		// Bonus Time Variance (+/-) Field -- space -- Delivery Time Allowance Field
		JPanel bonusTimeVarianceAndDeliveryTimeContainer = new JPanel();
		bonusTimeVarianceAndDeliveryTimeContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		bonusTimeVarianceAndDeliveryTimeContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
				
				JPanel bonusTimeVarianceContainer = new JPanel();
				bonusTimeVarianceContainer.setLayout(new BoxLayout(bonusTimeVarianceContainer, BoxLayout.X_AXIS));
				bonusTimeVarianceContainer.setBorder(new EmptyBorder(5, 25, 5, 0));
					
				// -- Bonus Time Variance (+/-) Label
				JLabel bonusTimeVarianceLabel = new JLabel();
				bonusTimeVarianceLabel.setText("Bonus Time Variance (+/-):");
				bonusTimeVarianceLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
				bonusTimeVarianceLabel.setAlignmentX(LEFT_ALIGNMENT);
				bonusTimeVarianceContainer.add(bonusTimeVarianceLabel);
						
				// Used to "pretty" up the Text Field
				JPanel bonusTimeVarianceTextboxContainer = new JPanel();
				bonusTimeVarianceTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
				bonusTimeVarianceTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 2));
						
				// -- Bonus Time Variance (+/-) TextField
				bonusTimeVarianceField = new JTextField("5", 5);
			   	bonusTimeVarianceField.setHorizontalAlignment(JTextField.CENTER);
			   	bonusTimeVarianceField.setFont(new Font("Calibri", Font.PLAIN, 26));
			   	bonusTimeVarianceField.setBorder(new LineBorder(Color.BLUE, 1));
			   	bonusTimeVarianceTextboxContainer.add(bonusTimeVarianceField);
			   	bonusTimeVarianceContainer.add(bonusTimeVarianceTextboxContainer);
			   	
			   	// -- Bonus Time Variance min label
			   	JLabel bonusTimeVarianceMinLabel = new JLabel("min");
			   	bonusTimeVarianceMinLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
			   	bonusTimeVarianceMinLabel.setBorder(new EmptyBorder(0, 0, 0, 25));
			   	bonusTimeVarianceContainer.add(bonusTimeVarianceMinLabel);
			   	bonusTimeVarianceAndDeliveryTimeContainer.add(bonusTimeVarianceContainer);
				    	
			   	// -- Delivery Time Allowance Label
				JLabel deliveryTimeLabel = new JLabel();
				deliveryTimeLabel.setText("Delivery Time Allowance:");
				deliveryTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
				deliveryTimeLabel.setAlignmentX(LEFT_ALIGNMENT);
				bonusTimeVarianceContainer.add(deliveryTimeLabel);
						
				// Used to "pretty" up the Text Field
				JPanel deliveryTimeTextboxContainer = new JPanel();
				deliveryTimeTextboxContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
				deliveryTimeTextboxContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
						
				// -- Delivery Time Allowance TextField
				deliveryTimeField = new JTextField("10", 5);
			   	deliveryTimeField.setHorizontalAlignment(JTextField.CENTER);
			   	deliveryTimeField.setFont(new Font("Calibri", Font.PLAIN, 26));
			   	deliveryTimeField.setBorder(new LineBorder(Color.BLUE, 1));
			   	deliveryTimeTextboxContainer.add(deliveryTimeField);
			   	bonusTimeVarianceContainer.add(deliveryTimeTextboxContainer);
				
			bonusTimeVarianceAndDeliveryTimeContainer.add(bonusTimeVarianceContainer);
			    	
		editCompanyContainer.add(bonusTimeVarianceAndDeliveryTimeContainer);
		
	    // Container Reset and Save buttons
		JPanel resetAndSaveButtonsContainer = new JPanel();
		resetAndSaveButtonsContainer.setLayout(new BoxLayout(resetAndSaveButtonsContainer, BoxLayout.X_AXIS));
		resetAndSaveButtonsContainer.setBorder(new EmptyBorder(5, 25, 5, 25));
		   
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
		backButton.setName("adminBackButton");
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
    
    public void SaveCompany() 
    {
    		companyInfo.UpdateCompanyInfo(
			courierIdField.getText(), 
			companyAddressField.getText(), 
			Double.parseDouble(billRateField.getText()), 
			Integer.parseInt(costPerBlockField.getText()),
			Integer.parseInt(courierSpeedField.getText()), 
			Integer.parseInt(blocksToMileField.getText()),
			Integer.parseInt(bonusTimeVarianceField.getText()), 
			Double.parseDouble(bonusOnTimeField.getText()),
			Integer.parseInt(pickUpTimeField.getText()), 
			Integer.parseInt(deliveryTimeField.getText()));
    }
    
    public void UpdateText() 
    {
    	courierIdField.setText(companyInfo.getName());
    	companyAddressField.setText(companyInfo.getAddress());
    	billRateField.setText(Double.toString(companyInfo.getBillRate()));
    	costPerBlockField.setText(Integer.toString(companyInfo.getCostPerBlock()));
    	courierSpeedField.setText(Integer.toString(companyInfo.getCourierSpeed()));
    	blocksToMileField.setText(Integer.toString(companyInfo.getBlocksToAMile()));
    	bonusTimeVarianceField.setText(Integer.toString(companyInfo.getBonusTimeVariance()));
    	bonusOnTimeField.setText(Double.toString(companyInfo.getBonusOnTime()));
    	pickUpTimeField.setText(Integer.toString(companyInfo.getPickUpTimeAllowance()));
    	deliveryTimeField.setText(Integer.toString(companyInfo.getDeliveryTimeAllowance()));
    }
}