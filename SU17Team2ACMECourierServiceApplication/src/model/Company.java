package model;

public class Company 
{
	// Local variables
	private String name;
	private String address;
	private double billRate;
	private int costPerBlock;
	private int courierSpeed;
	private int blocksToAMile;
	private int bonusTimeVariance;
	private int pickUpTimeAllowance;
	private int deliveryTimeAllowance;
	
	// Update the company's information
	public void UpdateCompanyInfo(String name, String address, double billRate, int costPerBlock,
			int courierSpeed, int blocksToAMile, int bonusTimeVariance, int pickUpTimeAllowance,
			int deliveryTimeAllowance) 
	{
		this.name = name;
		this.address = address;
		this.billRate = billRate;
		this.costPerBlock = costPerBlock;
		this.courierSpeed = courierSpeed;
		this.blocksToAMile = blocksToAMile;
		this.bonusTimeVariance = bonusTimeVariance;
		this.pickUpTimeAllowance = pickUpTimeAllowance;
		this.deliveryTimeAllowance = deliveryTimeAllowance;
	}
	
	public String GetName() 
	{
		return name;
	}
	
	public String GetAddress() 
	{
		return address;
	}
	
	public double GetBillRate() 
	{
		return billRate;
	}
	
	public double GetCostPerBlock() {
		return costPerBlock;
	}
	
	public int GetCourierSpeed() 
	{
		return courierSpeed;
	}
	
	public int GetBlocksToAMile() 
	{
		return blocksToAMile;
	}
	
	public int GetBonusTimeAllowance() 
	{
		return bonusTimeVariance;
	}
	
	public int GetPickUpTimeAllowance() 
	{
		return pickUpTimeAllowance;
	}
	
	public int GetDeliveryTimeAllowance() 
	{
		return deliveryTimeAllowance;
	}
}
