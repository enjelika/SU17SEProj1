package main;

import javax.swing.JFrame;

//import view.View;

public class Main extends JFrame
{
	private static JFrame window;
	
	public static void main(String[] args)
	{
//		window = new View();      
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
	}
}