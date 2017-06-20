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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import model.Utility;

@SuppressWarnings("serial")
public class ReportCourierPerformanceScreen extends JPanel
{
	private JLabel imageFrame;
	public JRadioButton weeklyCycle, monthlyCycle;
	public JComboBox<String> courierNameCB;
	public JTextField reportStartDateText;
	private JPanel mainPane, imgContainer, reportContainer, southButtonContainer;
	private JButton generateReportButton, printReportButton, backButton, logoutButton;
	
	public JScrollPane courierPerformanceReportViewer;
	
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
	
	// TODO: Remove this once wired up to retrieve the list of Courier Names from the DB (including an option for "All Couriers")
	String[] tempArray;
	
	ButtonController buttonController;
	
	public ReportCourierPerformanceScreen(ButtonController buttonController)
	{
    	// TODO: Remove this once the comboboxes are retrieving the list of customer names from the DB
		tempArray = new String[] {"-- select a courier --", "test1", "test2"};
		
		this.buttonController = buttonController;
    	
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the Center screen items
    	reportContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 0, 0, 0);
    	reportContainer.setBorder(new CompoundBorder(margin, border));
    	reportContainer.setAlignmentY(CENTER_ALIGNMENT);
    	
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
    	// Generate Button
    	Image generateReportButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "generateReportButton.png");
    	generateReportButton = new JButton(new ImageIcon(generateReportButtonIcon)); 
    	
    	// Print Button
    	Image printReportButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "printReport.png");
    	printReportButton = new JButton(new ImageIcon(printReportButtonIcon));     	
    	
    	// Back Button
    	Image backButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "repBackButton.png");
    	backButton = new JButton(new ImageIcon(backButtonIcon));
    	
    	// Logout Button
		Image logoutButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "repLogoutButton.png");
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
		
		JPanel overallContainer = new JPanel();
		overallContainer.setLayout(new BoxLayout(overallContainer, BoxLayout.Y_AXIS));
		overallContainer.setBorder(new EmptyBorder(0, 25, 0, 25));
		
		JPanel titleContainer = new JPanel();
		titleContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		
			// Courier Performance Report: --space-- Date --space-- Time
			JLabel reportScreen1Title = new JLabel("Courier Performance Report:");
			reportScreen1Title.setFont(new Font("Calibri", Font.PLAIN, 26));
			reportScreen1Title.setBorder(new EmptyBorder(0, 5, 0, 0));
			titleContainer.add(reportScreen1Title);
		
		overallContainer.add(titleContainer);
		
		/*
		 *  Outer box for the report generation items
		 */
		reportContainer.setLayout(new BoxLayout(reportContainer, BoxLayout.Y_AXIS));
		reportContainer.setOpaque(false);
		
			// Courier Name drop down AND Generate Report Button
			JPanel courierNameCbContainer = new JPanel();
			courierNameCbContainer.setLayout(new BoxLayout(courierNameCbContainer, BoxLayout.X_AXIS));
			courierNameCbContainer.setBorder(new EmptyBorder(25, 25, 0, 0));
			
				// Courier Name Label
				JLabel courierNameLabel= new JLabel();
				courierNameLabel.setText("Courier Name:");
				courierNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
				courierNameLabel.setBorder(new EmptyBorder(0, 5, 0, 15));
				courierNameCbContainer.add(courierNameLabel);
			
				// ComboBox
				Border bCB = new LineBorder(Color.BLUE, 1);
				Border mCB = new EmptyBorder(0, 15, 0, 15);
				courierNameCB = new JComboBox<String>(tempArray); //TODO: deliveryTicket1Controller.model.getCourierNames());
				courierNameCB.setSelectedIndex(0);
				courierNameCB.setFont(new Font("Calibri", Font.PLAIN, 24));
				courierNameCB.setBorder(new CompoundBorder(mCB, bCB));
				courierNameCB.addActionListener(null); 
				//TODO: Create an ActionListener for CBs to the controller package
				courierNameCbContainer.add(courierNameCB);
				
				// Generate Report Button
				generateReportButton.setName("generateCourierPerformanceReport");
				generateReportButton.setOpaque(false);
				generateReportButton.setContentAreaFilled(false);
				generateReportButton.setBorder(new EmptyBorder(0, 0, 0, 0));
				generateReportButton.addActionListener(buttonController);
				courierNameCbContainer.add(generateReportButton);
				
			reportContainer.add(courierNameCbContainer);
				
			// Report Start Date: --space-- Cycle type radio buttons
			JPanel reportDateAndCycleContainer = new JPanel();
			reportDateAndCycleContainer.setLayout(new BoxLayout(reportDateAndCycleContainer, BoxLayout.X_AXIS));
			reportDateAndCycleContainer.setBorder(new EmptyBorder(25, 25, 10, 0));
			
				// Report Start Date Label
				JLabel reportStartDateLabel= new JLabel();
				reportStartDateLabel.setText("Report Start Date:");
				reportStartDateLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
				reportStartDateLabel.setBorder(new EmptyBorder(0, 5, 0, 15));
				reportDateAndCycleContainer.add(reportStartDateLabel);
			
				// Report Start Date TextField
				reportStartDateText = new JTextField("", 5);
				reportStartDateText.setFont(new Font("Calibri", Font.PLAIN, 24));
				reportDateAndCycleContainer.add(reportStartDateText);
				
				// Cycle radio buttons Label
				JLabel cycleTypeRB = new JLabel();
		    	cycleTypeRB.setText("Cycle: ");
		    	cycleTypeRB.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	cycleTypeRB.setBorder(new EmptyBorder(0, 5, 0, 5));
		    	reportDateAndCycleContainer.add(cycleTypeRB);
		    	
		    	ButtonGroup radioButtons = new ButtonGroup();
		    	
		    	// Cycle Radio Buttons   		    	
		    	weeklyCycle = new JRadioButton("Weekly");
		    	weeklyCycle.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	weeklyCycle.setSelected(true);
		    	
		    	monthlyCycle = new JRadioButton("Monthly");
		    	monthlyCycle.setFont(new Font("Calibri", Font.PLAIN, 26));
		    	
		    	radioButtons.add(weeklyCycle);
		    	radioButtons.add(monthlyCycle);
		    	
		    	reportDateAndCycleContainer.add(weeklyCycle);
		    	reportDateAndCycleContainer.add(monthlyCycle);
			
			reportContainer.add(reportDateAndCycleContainer);
			
			// JScrollPane (report viewer)
			JPanel scrollPaneContainer = new JPanel();
			scrollPaneContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
			
				courierPerformanceReportViewer = new JScrollPane();
				courierPerformanceReportViewer.setPreferredSize(new Dimension(800, 325));
				courierPerformanceReportViewer.setAutoscrolls(true);
				scrollPaneContainer.add(courierPerformanceReportViewer);
			
			reportContainer.add(scrollPaneContainer);
			
		overallContainer.add(reportContainer);
		mainPane.add(overallContainer, BorderLayout.CENTER);
		
		/*
		 * southButtonContainer for Back, Print Report, and Logout buttons
		 */
		// Back --space-- Print Report --space-- Logout Button
		backButton.setName("reportsBackButton");
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(new EmptyBorder(0, 0, 0, 70));
		backButton.addActionListener(buttonController);
		southButtonContainer.add(backButton);
		
        // -- Print Report Button
		printReportButton.setName("printCourierPerformanceReport");
		printReportButton.setOpaque(false);
		printReportButton.setContentAreaFilled(false);
		printReportButton.setBorder(new EmptyBorder(0, 70, 0, 70));
		printReportButton.addActionListener(buttonController);
		southButtonContainer.add(printReportButton);
		
		// -- Logout Button
		logoutButton.setName("logoutButton");
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorder(new EmptyBorder(0, 70, 0, 0));
		logoutButton.addActionListener(buttonController);
		southButtonContainer.add(logoutButton);
		
		// -- end of southButtonContainer
		
		mainPane.add(southButtonContainer, BorderLayout.SOUTH);
		this.add(mainPane);
	}
}