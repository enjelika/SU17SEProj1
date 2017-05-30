package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Utility;

public class LoginScreen extends JFrame
{
	private JLayeredPane layeredPane;
	
	private String title = "ACME Courier Service";
	protected final static String filePath = System.getProperty("user.dir"); 
    protected final static String separator = System.getProperty("file.separator");
//    private final Toolkit t = Toolkit.getDefaultToolkit();
    
    private final Image acmeCourierServiceLogo;
    
    public LoginScreen()
    {
		layeredPane = getLayeredPane();
		
		acmeCourierServiceLogo = Utility.getImage(filePath + separator + "images" + separator + "AcmeCourierServiceLogo.jpg");
		
//      Image loginButtonIcon = Utility.getImage(filePath + separator + "images" + separator + "start_button2.png");
//      loginButton = new JButton(new ImageIcon(loginButtonIcon));
    	
        SetUpView();
    }
    
    /*
     * Setting up the Login Screen View
     */
    public void SetUpView()
    {
        setTitle(title);
        setSize(1000, 900);
        setLocationRelativeTo(null);
        JFrame.setDefaultLookAndFeelDecorated(true); 
        
        // Set up the window icon
//        ArrayList<Image> img = new ArrayList<>(); 
//        img.add(t.getImage(filePath + separator + "images" + separator + "corgi_icon.png"));
//        setIconImages(img);
        
        // Logo
                
        // Outer box for the following
                
        // -- Username label
        
        // -- Username Textbox
        
        // -- Password label
        
        // -- Password Textbox
        
        // -- Login Button
                
    }
}