package main;

import javax.swing.JFrame;

import controller.ButtonController;
import view.ButtonListener;

import view.LoginScreen;
import view.MainMenuScreen;

@SuppressWarnings("serial")
public class Main extends JFrame
{
	private static JFrame window;
	private static ButtonController buttonController;
	
	public static void main(String[] args)
	{
		buttonController = new ButtonController();
		
		buttonController.setButtonListener(new ButtonListener(){
			public void screenChanged(String screen)
			{
				window = new MainMenuScreen(buttonController);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);
				window.setResizable(false);
				window.setLocationRelativeTo(null);
			}
			
		});
		
		window = new LoginScreen(buttonController);      
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
	}
}