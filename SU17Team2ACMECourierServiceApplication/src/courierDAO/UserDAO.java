package courierDAO;

import java.util.ArrayList;

import javax.persistence.Query;

import courierPD.User;

public class UserDAO {

	public static void saveUser(User user) {
		emDAO.getEM().persist(user);
	}
	
		public static void addPlayer(User user) {
			emDAO.getEM().persist(user);
		}

		public static ArrayList<User> listUser() {
			Query query = emDAO.getEM().createQuery("SELECT user FROM user user");
			ArrayList<User> list= (ArrayList<User>) query.getResultList();

			return list;
		}

		public static User findUserById(int id) {
			Query query = emDAO.getEM().createQuery("SELECT user FROM user user");
			User user = (User) query.getSingleResult();
			return user;
		}
		
		public static User findUser(String username, String password) {
			Query query = emDAO.getEM().createQuery("SELECT u FROM user u WHERE u.userName = 'admin'");
			User user = (User) query.getSingleResult();
			return user;
		}

		public static void removeUser(User user) {
			emDAO.getEM().remove(user);
			
		}
}
