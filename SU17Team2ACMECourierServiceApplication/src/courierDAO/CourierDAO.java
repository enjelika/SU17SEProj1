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

		public static List<Courier> listCourier() {
			Query query = emDAO.getEM().createQuery("SELECT c FROM Courier c");
			List<Courier> list= (List<Courier>) query.getResultList();

			return list;
		}
}
