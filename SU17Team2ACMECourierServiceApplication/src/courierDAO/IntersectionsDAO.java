package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Intersections;

public class IntersectionsDAO
{
	public static void saveIntersections(List<Intersections>  intersections) 
	{
		for(Intersections intersection : intersections)
		{
			emDAO.getEM().persist(intersection);
		}
	}
	
	public static List<Intersections> listIntersections() 
	{
		Query query = emDAO.getEM().createQuery("SELECT i FROM Intersections i");
		@SuppressWarnings("unchecked")
		List<Intersections> list= (List<Intersections>) query.getResultList();

		return list;
	}
	
	// Find a customer by name
	public static Intersections findIntersectionById(long id) 
	{
		Query query = emDAO.getEM().createQuery("SELECT intersection FROM Intersections intersection WHERE intersection.id = '" + id + "'");
		Intersections customer = null;
		try
		{
			customer = (Intersections)query.getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return customer;
	}
}
