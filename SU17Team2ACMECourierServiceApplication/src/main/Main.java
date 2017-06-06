package main;

import javax.swing.JFrame;

import controller.ButtonController;

@SuppressWarnings("serial")
public class Main extends JFrame
{
	private static JFrame window;
	private static ButtonController buttonController;
	
	public static void main(String[] args)
	{
		buttonController = new ButtonController();
		
		window = new view.MainWindow(buttonController);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}