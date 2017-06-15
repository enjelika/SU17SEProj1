package courierDAO;

import courierPD.Customer;

public class CustomerDAO
{
	public static Customer findCustomerById(long id) 
	{
		return emDAO.getEM().find(Customer.class, id);
	}
	
	public static void addCustomer(Customer customer) 
	{
		emDAO.getEM().persist(customer);
	}
	
	public static void updateCustomer(Customer customer) 
	{
		emDAO.getEM().merge(customer);
	}
}
