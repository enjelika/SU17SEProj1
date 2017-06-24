package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Courier;
import courierPD.Customer;

public class CourierDAO 
{
	// Find courier by id
	public static Courier findCourierById(long id) 
	{
		return emDAO.getEM().find(Courier.class, id);
	}
	
	// Save courier
	public static void saveCourier(Courier courier) 
	{
		emDAO.getEM().persist(courier);
	}
	
	// Add courier
	public static void addCourier(Courier courier) 
	{
		emDAO.getEM().persist(courier);
	}

	// Get couriers list
	public static List<Courier> listCourier() 
	{
		Query query = emDAO.getEM().createQuery("SELECT c FROM Courier c");
		@SuppressWarnings("unchecked")
		List<Courier> list= (List<Courier>) query.getResultList();

		return list;
	}
}