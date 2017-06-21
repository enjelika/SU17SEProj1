package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Courier;
import courierPD.Customer;

public class CourierDAO 
{
	public static Courier findCourierById(long id) 
	{
		return emDAO.getEM().find(Courier.class, id);
	}
	
	public static void saveCourier(Courier courier) 
	{
		emDAO.getEM().persist(courier);
	}
	
	public static void addCourier(Courier courier) 
	{
		emDAO.getEM().persist(courier);
	}

	public static List<Courier> listCourier() 
	{
		Query query = emDAO.getEM().createQuery("SELECT c FROM Courier c");
		@SuppressWarnings("unchecked")
		List<Courier> list= (List<Courier>) query.getResultList();

		return list;
	}
}