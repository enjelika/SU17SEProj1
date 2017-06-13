/**
 * 
 * @author Debra
 * 
 * Note: This is like the Repository class we use at work
 *
 */
package model;

import java.util.Calendar;

import courierDAO.UserDAO;

public class Model 
{
	String packageID;
	int counter = 0;
	
	public void setPackageId()
	{
		counter++;
		packageID = String.format("%02d", Calendar.MONTH) + String.format("%02d", Calendar.DAY_OF_MONTH) + "17" + String.format("%03d", counter);
	}
	
	public String getPackageId()
	{
		setPackageId();
		return packageID;
	}
	
	String[] customerNames;

	public String[] getCustomerNames() 
	{
		return customerNames;
	}

	public void setCustomerNames() 
	{
		// TODO: Fill the customerNames String array with values from the DB
	}
	
	
}
