package model;

public class Company 
{
	// Local variables
	public static String Name;
	public static String Address;
	public static double BillRate;
	public static int CostPerBlock;
	public static int CourierSpeed;
	public static int BlocksToAMile;
	public static int BonusTimeVariance;
	public static int BonusOnTime;
	public static int PickUpTimeAllowance;
	public static int DeliveryTimeAllowance;
	
	// Update the company's information
	public static void UpdateCompanyInfo(String name, String address, double billRate, int costPerBlock,
			int courierSpeed, int blocksToAMile, int bonusTimeVariance, int bonusOnTime, int pickUpTimeAllowance,
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
