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
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ButtonController;
import courierDAO.CourierDAO;
import courierDAO.CustomerDAO;
import courierDAO.TicketDAO;
import courierPD.Courier;
import courierPD.Customer;
import courierPD.Ticket;
import model.Utility;

@SuppressWarnings("serial")
public class ReportCompanyPerformanceScreen extends JPanel
{
	private JLabel imageFrame, dateLabel, timeLabel;
	public JRadioButton weeklyCycle, monthlyCycle;
	public JComboBox<Customer> customerNameCB = new JComboBox();
	public JTextField reportStartDateText;
	private JPanel mainPane, imgContainer, reportContainer, southButtonContainer;
	private JButton generateReportButton, printReportButton, backButton, logoutButton;
	
	public JScrollPane coPerformanceReportViewer;
	public JTable reportTable;
	
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
<<<<<<< Upstream, based on origin/master

=======
    	
	public String dateText, timeText;
	public String[] Header = new String[] {"Package ID", "Est. Delivery Time", "Act. Delivery Time"};
	
>>>>>>> afec4df Obtain list of ticket from a customer for report
	private List<Customer> customers;
	
	ButtonController buttonController;
	
	public ReportCompanyPerformanceScreen(ButtonController buttonController)
	{		
		this.buttonController = buttonController;
		
		buttonController.setViewListener(new ViewListener(){
			public Object GetView() {
				return ReportCompanyPerformanceScreen.this;
			}			

		});
		
		// Populate customers data
		PopulateFormData();
    	
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
		
			// Company Performance Report: --space-- Date --space-- Time
			JLabel reportScreen1Title = new JLabel("Company Performance Report:");
			reportScreen1Title.setFont(new Font("Calibri", Font.PLAIN, 26));
			reportScreen1Title.setBorder(new EmptyBorder(0, 5, 0, 0));
			titleContainer.add(reportScreen1Title);
<<<<<<< Upstream, based on origin/master
=======
					
			dateLabel = new JLabel("Date: " + dateText);
			dateLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
			dateLabel.setBorder(new EmptyBorder(0, 200, 0, 0));
			titleContainer.add(dateLabel);
			
			timeLabel = new JLabel("Time: " + timeText);
			timeLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
			timeLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
			titleContainer.add(timeLabel);
>>>>>>> afec4df Obtain list of ticket from a customer for report
		
		overallContainer.add(titleContainer);
		
		/*
		 *  Outer box for the report generation items
		 */
		reportContainer.setLayout(new BoxLayout(reportContainer, BoxLayout.Y_AXIS));
		reportContainer.setOpaque(false);
		
			// Customer Name drop down AND Generate Report Button
			JPanel customerNameCbContainer = new JPanel();
			customerNameCbContainer.setLayout(new BoxLayout(customerNameCbContainer, BoxLayout.X_AXIS));
			customerNameCbContainer.setBorder(new EmptyBorder(15, 15, 0, 0));
			
				// Customer Name Label
				JLabel customerNameLabel= new JLabel();
				customerNameLabel.setText("Customer Name:");
				customerNameLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
				customerNameLabel.setBorder(new EmptyBorder(0, 5, 0, 15));
				customerNameCbContainer.add(customerNameLabel);
			
				// ComboBox
				Border bCB = new LineBorder(Color.BLUE, 1);
				Border mCB = new EmptyBorder(0, 15, 0, 15);
				customerNameCB.setFont(new Font("Calibri", Font.PLAIN, 24));
				customerNameCB.setBorder(new CompoundBorder(mCB, bCB));
				customerNameCB.addActionListener(null); 
				customerNameCbContainer.add(customerNameCB);
				
				// Generate Report Button
				generateReportButton.setName("generateCompanyPerformanceReport");
				generateReportButton.setOpaque(false);
				generateReportButton.setContentAreaFilled(false);
				generateReportButton.setBorder(new EmptyBorder(0, 0, 0, 0));
				generateReportButton.addActionListener(buttonController);
				customerNameCbContainer.add(generateReportButton);
				
			reportContainer.add(customerNameCbContainer);
				
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
<<<<<<< Upstream, based on origin/master
			JPanel scrollPaneContainer = new JPanel();
			scrollPaneContainer.setBorder(new EmptyBorder(5, 0, 5, 0));
			
				coPerformanceReportViewer = new JScrollPane();
				coPerformanceReportViewer.setPreferredSize(new Dimension(800, 325));
				coPerformanceReportViewer.setAutoscrolls(true);
				scrollPaneContainer.add(coPerformanceReportViewer);
			
			reportContainer.add(scrollPaneContainer);
=======
			coPerformanceReportViewer = new JScrollPane();
			coPerformanceReportViewer.setPreferredSize(new Dimension(350, 325));
			coPerformanceReportViewer.setAutoscrolls(true);
			JTextArea a = new JTextArea(100, 100);
			a.setPreferredSize(new Dimension(350,325));
			a.setText("asdfasdfsadfsadfasdfasdf");	// For testing
			coPerformanceReportViewer.add(a);
			reportContainer.add(coPerformanceReportViewer);
>>>>>>> afec4df Obtain list of ticket from a customer for report
			
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
		printReportButton.setName("printCoPerformanceReport");
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
	
	// Populate customers list
	public void PopulateFormData()
    {
    	// Get all customer names in DB and put it into the combo box
    	customers = CustomerDAO.ListCustomer();
		for (Customer customer : customers)
		{
			customerNameCB.addItem(customer);
		}
		
		// Only display name of the customer in the combo box
		customerNameCB.setRenderer(new DefaultListCellRenderer() 
		{
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Customer){
                	Customer customer = (Customer) value;
                    setText(customer.getName());
                }
                return this;
            }
		});
    }
	
	// Generate report
	public void Generate()
	{
		Customer selectedCustomer = (Customer)customerNameCB.getSelectedItem();
		List<Ticket> listTicket = TicketDAO.listTicketsByCustomerId(selectedCustomer.getCustomerID());
		int numberOfRow = listTicket.size();
		int row = 0;
		Object[][] rowData = new Object[numberOfRow][3];
		
		for(Ticket ticket : TicketDAO.listTickets()) 
		{
			rowData[row][0] = ticket.GetTicketID();
			rowData[row][1] = ticket.GetEstimatedDeliveryTime();
			rowData[row][2] = ticket.GetDeliveryTime();
		    row++;
		}
		
		reportTable = new JTable(rowData, Header);
		coPerformanceReportViewer.add(reportTable);
	}
}