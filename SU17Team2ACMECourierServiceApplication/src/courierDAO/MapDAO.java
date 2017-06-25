package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Map;

public class MapDAO
{
	// Save street segments to the db
	public static void saveMap(List<Map> streetSegments) 
	{
		for(Map streetSegment : streetSegments) 
		{
			emDAO.getEM().persist(streetSegment);
		}
	}

	// Get the list of street segments
	public static List<Map> listMap()
	{
		Query query = emDAO.getEM().createQuery("SELECT m FROM map m");
		@SuppressWarnings("unchecked")
		List<Map> list= (List<Map>) query.getResultList();

		return list;
	}
}
