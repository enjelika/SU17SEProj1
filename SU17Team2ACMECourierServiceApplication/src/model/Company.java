package model;

public class Company 
{
	// Local variables
	public String Name;
	public String Address;
	public double BillRate;
	public int CostPerBlock;
	public int CourierSpeed;
	public int BlocksToAMile;
	public int BonusTimeVariance;
	public double BonusOnTime;
	public int PickUpTimeAllowance;
	public int DeliveryTimeAllowance;
	
	// Update the company's information
	public void UpdateCompanyInfo(String name, String address, double billRate, int costPerBlock,
			int courierSpeed, int blocksToAMile, int bonusTimeVariance, double bonusOnTime, int pickUpTimeAllowance,
			int deliveryTimeAllowance) 
	{
		Name = name;
		Address = address;
		BillRate = billRate;
		CostPerBlock = costPerBlock;
		CourierSpeed = courierSpeed;
		BlocksToAMile = blocksToAMile;
		BonusTimeVariance = bonusTimeVariance;
		BonusOnTime = bonusOnTime;
		PickUpTimeAllowance = pickUpTimeAllowance;
		DeliveryTimeAllowance = deliveryTimeAllowance;
	}
}
