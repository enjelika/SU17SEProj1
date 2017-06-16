package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.User;

public class UserDAO 
{

	public static void saveUser(User user) {
		emDAO.getEM().persist(user);
	}
	
		public static void addUser(User user) {
			emDAO.getEM().persist(user);
		}

		public static List<User> listUser() {
			Query query = emDAO.getEM().createQuery("SELECT u FROM user u");
			@SuppressWarnings("unchecked")
			List<User> list= (List<User>) query.getResultList();

			return list;
		}

		public static User findUserById(int id) {
			Query query = emDAO.getEM().createQuery("SELECT user FROM user user");
			User user = (User) query.getSingleResult();
			return user;
		}
		
		public static User findUser(String username, String password) {
			Query query = emDAO.getEM().createQuery("SELECT u FROM user u WHERE u.userName = '" + username + "' and u.password = '" + password + "'");
			User user = null;
			try
			{
				user = (User) query.getSingleResult();
			}
			catch(Exception e)
			{
				
			}

			return user;
		}

		public static void removeUser(User user) {
			emDAO.getEM().remove(user);
			
		}
}
