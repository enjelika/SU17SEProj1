package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Courier;
import courierPD.Customer;

public class CustomerDAO
{
	// Find a customer by id
	public static Customer findCustomerById(long id) 
	{
		return emDAO.getEM().find(Customer.class, id);
	}
	
	// Find a customer by name
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
	
	// Add a customer
	public static void addCustomer(Customer customer) 
	{
		emDAO.getEM().persist(customer);
	}
	
	// Update customer
	public static void updateCustomer(Customer customer) 
	{
		emDAO.getEM().merge(customer);
	}
	
	// Get a customers list
	public static List<Customer> ListCustomer() 
	{
		Query query = emDAO.getEM().createQuery("SELECT c FROM Customer c");
		@SuppressWarnings("unchecked")
		List<Customer> list= (List<Customer>) query.getResultList();

		return list;
	}
}
