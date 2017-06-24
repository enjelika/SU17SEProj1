package courierDAO;

import courierPD.CompanyInfo;

public class CompanyInfoDAO
{
	// Find company info by name
	public static CompanyInfo findCompanyInfo(String name) 
	{
		return emDAO.getEM().find(CompanyInfo.class, "ACME Courier Service");
	}
	
	// Update company info
	public static void updateCompanyInfo(CompanyInfo companyInfo) 
	{
		emDAO.getEM().merge(companyInfo);
	}
}
