package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Intersections;

public class IntersectionsDAO
{
	public static void saveIntersections(Intersections intersection) 
	{
		emDAO.getEM().persist(intersection);
	}
	
	public static List<Intersections> listIntersections() 
	{
		Query query = emDAO.getEM().createQuery("SELECT i FROM Intersections i");
		@SuppressWarnings("unchecked")
		List<Intersections> list= (List<Intersections>) query.getResultList();

		return list;
	}
}
