package model;

public class Company 
{
	// Local variables
	private static String Name;
	private static String Address;
	private static double BillRate;
	private static int CostPerBlock;
	private static int CourierSpeed;
	private static int BlocksToAMile;
	private static int BonusTimeVariance;
	private static int PickUpTimeAllowance;
	private static int DeliveryTimeAllowance;
	
	// Update the company's information
	public static void UpdateCompanyInfo(String name, String address, double billRate, int costPerBlock,
			int courierSpeed, int blocksToAMile, int bonusTimeVariance, int pickUpTimeAllowance,
			int deliveryTimeAllowance) 
	{
		Name = name;
		Address = address;
		BillRate = billRate;
		CostPerBlock = costPerBlock;
		CourierSpeed = courierSpeed;
		BlocksToAMile = blocksToAMile;
		BonusTimeVariance = bonusTimeVariance;
		PickUpTimeAllowance = pickUpTimeAllowance;
		DeliveryTimeAllowance = deliveryTimeAllowance;
	}
}
