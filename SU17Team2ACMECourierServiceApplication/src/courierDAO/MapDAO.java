package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Map;

public class MapDAO {
	public static void saveMap(Map map) {
		emDAO.getEM().persist(map);
	}
	
		public static void addUser(Map map) {
			emDAO.getEM().persist(map);
		}

		public static List<Map> listMap() {
			Query query = emDAO.getEM().createQuery("SELECT m FROM map m");
			@SuppressWarnings("unchecked")
			List<Map> list= (List<Map>) query.getResultList();

			return list;
		}

}
