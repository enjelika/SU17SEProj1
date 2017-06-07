package model;

public class User
{
	// Declare variables
	public String Name;
	public String Password;
	public String Type;	// Consider to use enum here instead of String	
	public int ID;
	
	// Change password
	public void ChangePassword(String password) 
	{
		Password = password;
	}
	
	// Verify user account
	public void Verify() 
	{
		// TODO: Add logic here
	}
}
