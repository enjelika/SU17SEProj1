package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Intersections;

public class IntersectionsDAO
{
	// Save Intersections
	public static void saveIntersections(List<Intersections>  intersections) 
	{
		for(Intersections intersection : intersections)
		{
			emDAO.getEM().persist(intersection);
		}
	}
	
	// Get list of intersections
	public static List<Intersections> listIntersections() 
	{
		Query query = emDAO.getEM().createQuery("SELECT i FROM Intersections i");
		@SuppressWarnings("unchecked")
		List<Intersections> list= (List<Intersections>) query.getResultList();

		return list;
	}
	
	// Find an intersection by Id
	public static Intersections findIntersectionById(long id) 
	{
		Query query = emDAO.getEM().createQuery("SELECT intersection FROM Intersections intersection WHERE intersection.id = '" + id + "'");
		Intersections intersection = null;
		try
		{
			intersection = (Intersections)query.getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return intersection;
	}
}
