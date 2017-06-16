package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Courier;
import courierPD.User;

public class CourierDAO {
	public static void saveCourier(Courier courier) {
		emDAO.getEM().persist(courier);
	}
	
		public static void addCourier(Courier courier) {
			emDAO.getEM().persist(courier);
		}

		public static List<Courier> listUser() {
			Query query = emDAO.getEM().createQuery("SELECT c FROM courier c");
			List<Courier> list= (List<Courier>) query.getResultList();

			return list;
		}
		
		public static Courier findCourier(String username, String password) {
			Query query = emDAO.getEM().createQuery("SELECT u FROM user u WHERE u.userName = '" + username + "' and u.password = '" + password + "'");
			Courier user = null;
			try
			{
				user = (Courier) query.getSingleResult();
			}
			catch(Exception e)
			{
				
			}

			return user;
		}
}
