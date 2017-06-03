package model;

import java.util.Date;

public class Ticket
{
	// Declare variables
	Customer customer = new Customer();
	Courier courier = new Courier();
	Date dateTime = new Date();
	Date estimatedDeliveryTime = new Date();
	Date assignedTime = new Date();
	Date pickUpTime = new Date();
	Date deliveredTime = new Date();
	
	public String OrderTakenBy;
	public String BillToPickUp;
	public String BillToDelivery;
	public double QuotedPrice;
	public double EstimatedBlock;
	public double Bonus;
	public int PackageID;
	
	// TODO: Edit Ticket
	
	// TODO: Create Ticket
}
