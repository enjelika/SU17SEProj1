package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LoginController implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		JButton sender = (JButton) ae.getSource();
    	String buttonID = sender.getName();

    	switch(buttonID)
    	{
    		case "loginButton":
    			// TODO: Login action here
    			System.out.println("Login was pressed");
    			break;
    			
    		default:
    			break;
    	}
	}
}
