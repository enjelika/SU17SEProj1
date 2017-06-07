package main;

import javax.swing.JFrame;

import controller.ButtonController;
import courierDAO.emDAO;
import model.Model;

@SuppressWarnings("serial")
public class Main extends JFrame
{
	private static JFrame window;
	private static ButtonController buttonController;
	private static Model model;
	
	@SuppressWarnings("serial")
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
		emDAO.initEM();
		window = new view.MainWindow(buttonController);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}