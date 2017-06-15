package courierDAO;

import courierPD.CompanyInfo;

public class CompanyInfoDAO
{
	public static CompanyInfo findCompanyInfo(String name) 
	{
		return emDAO.getEM().find(CompanyInfo.class, "ACME Courier Service");
	}
	
	public static void updateCompanyInfo(CompanyInfo companyInfo) 
	{
		emDAO.getEM().merge(companyInfo);
	}
}
