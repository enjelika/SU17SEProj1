package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MainMenuScreen extends JFrame
{
	private JButton adminMenuButton, customerMaintenanceButton, deliveryTicketButton, reportsButton, settingsButton, logoutButton;
	private JLabel imageFrame;
	private JPanel mainMenuContainer, mainPane, imgContainer;
	
	private String title = "ACME Courier Service";
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
    private BufferedImage acmeCourierServiceLogo;
    
    public MainMenuScreen()
    {
    	mainPane = new JPanel();
    	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
    	
    	// Container for the menu buttons
    	mainMenuContainer = new JPanel();
    	Border border = new LineBorder(Color.BLUE, 1);
    	Border margin = new EmptyBorder(0, 300, 75, 300);
    	mainMenuContainer.setBorder(new CompoundBorder(margin, border));
    	mainMenuContainer.setAlignmentX(CENTER_ALIGNMENT);
    	mainMenuContainer.setAlignmentY(CENTER_ALIGNMENT);
    }
    
    public void SetUpView()
    {
        setTitle(title);
        setSize(1000, 900);
        setLocationRelativeTo(null);
        JFrame.setDefaultLookAndFeelDecorated(true); 
        
        // Logo
        imgContainer = new JPanel();	
		imgContainer.setSize(new Dimension(75, 50));
		imageFrame = new JLabel();
		imageFrame = new JLabel(new ImageIcon(acmeCourierServiceLogo));
		imgContainer.add((Component)imageFrame);
		imgContainer.setBorder(new EmptyBorder(35, 10, 50, 10));
		mainPane.add(imgContainer, BorderLayout.NORTH);
		
		
    }
}