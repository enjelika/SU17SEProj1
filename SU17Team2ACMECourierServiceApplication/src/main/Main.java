package main;

import javax.swing.JFrame;

import controller.ButtonController;
import model.Model;

@SuppressWarnings("serial")
public class Main extends JFrame
{
	private static JFrame window;
	private static ButtonController buttonController;
	private static Model model;
	
	public static void main(String[] args)
	{
		/**
		 *  The Model (think of this as our Repository class from work - hence why it is static)
		 */
		model = new Model();
		
		/**
		 *  The ViewModel/Controller(s) go here
		 *  
		 *  Note: Some or all of the controllers may need to have the model passed to it
		 */
		buttonController = new ButtonController();
				
		/**
		 *  The View
		 */
		window = new view.MainWindow(buttonController);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}