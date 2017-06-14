package courierDAO;

import javax.persistence.Query;

import courierPD.CompanyInfo;
import courierPD.User;
import model.Company;

public class CompanyInfoDAO
{
	public static CompanyInfo findCompannInfo(String name) 
	{
		return emDAO.getEM().find(CompanyInfo.class, "ACME Courier Service");
	}
	
	public static void updateCompanyInfo(CompanyInfo companyInfo) 
	{
		emDAO.getEM().merge(companyInfo);
		System.out.println(("UPDATE companyInfo SET "
				+ "name = " + "'" + companyInfo.getName() + "'" + ", "
				+ "address = " + "'" + companyInfo.getAddress() + "'" + ", "
				+ "billRate = " + "'" + companyInfo.getBillRate() + "'" + ", "
				+ "costPerBlock = " + "'" + companyInfo.getCostPerBlock() + "'" + ", "
				+ "courierSpeed = " + "'" + companyInfo.getCourierSpeed() + "'" + ", "
				+ "blocksToAmile = " + "'" + companyInfo.getBlocksToAMile() + "'" + ", "
				+ "bonusTimeVariance = " + "'" + companyInfo.getBonusTimeVariance() + "'" + ", "
				+ "bonusOnTime = " + "'" + companyInfo.getBonusOnTime() + "'" + ", "
				+ "pickUpTimeAllowance = " + "'" + companyInfo.getPickUpTimeAllowance() + "'" + ", "
				+ "deliveryTimeAllowance = " + "'" + companyInfo.getDeliveryTimeAllowance()+ "' "
				+ "WHERE name = " + "'" + companyInfo.getName() + "'"));
	}
}
