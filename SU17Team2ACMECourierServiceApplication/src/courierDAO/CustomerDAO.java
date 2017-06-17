package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Courier;
import courierPD.Customer;

public class CustomerDAO
{
	public static Customer findCustomerById(long id) 
	{
		return emDAO.getEM().find(Customer.class, id);
	}
	
	public static Customer findCustomerByName(String name) 
	{
		Query query = emDAO.getEM().createQuery("SELECT customer FROM Customer customer WHERE customer.customerName = '" + name + "'");
		Customer customer = null;
		try
		{
			customer = (Customer)query.getSingleResult();
		}
		catch(Exception e)
		{
			
		}
		return customer;
	}
	
	public static void addCustomer(Customer customer) 
	{
		emDAO.getEM().persist(customer);
	}
	
	public static void updateCustomer(Customer customer) 
	{
		emDAO.getEM().merge(customer);
	}
	
	public static List<Customer> ListCustomer() 
	{
		Query query = emDAO.getEM().createQuery("SELECT c FROM Customer c");
		@SuppressWarnings("unchecked")
		List<Customer> list= (List<Customer>) query.getResultList();

		return list;
	}
}
