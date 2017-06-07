package view;

import javax.swing.JFrame;

import controller.ButtonController;

public class MainWindow extends JFrame
{
	/**
	 * Generated Serialization
	 */
	private static final long serialVersionUID = 7823189013269499160L;

	private String title = "ACME Courier Service";
	
    private ButtonController buttonController;
	
	/**
	 * Create the MainWindow frame.
	 */
	public MainWindow(ButtonController buttonController)
	{
		this.buttonController = buttonController;
		buttonController.setMainFrame(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		SetUpView();
	}
	
	/**
	 *  SetUpView - have a placeholder for the JPanel
	 */
	// - Initial JPanel will be the LoginScreen
	public void SetUpView()
	{
		setTitle(title);
        setSize(900, 800);
        setLocationRelativeTo(null);
        JFrame.setDefaultLookAndFeelDecorated(true); 
		
		setContentPane(new LoginScreen(buttonController));
		getContentPane().invalidate();
		getContentPane().validate();
		getContentPane().repaint();
	}
}