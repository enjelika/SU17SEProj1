package courierDAO;

import java.util.List;

import javax.persistence.Query;

import courierPD.Customer;
import courierPD.Ticket;
import courierPD.User;

public class TicketDAO {

	public static void saveTicket(Ticket ticket) {
		emDAO.getEM().persist(ticket);
	}
	
		public static void addTicket(User ticket) {
			emDAO.getEM().persist(ticket);
		}

		public static List<Ticket> listTickets() {
			Query query = emDAO.getEM().createQuery("SELECT t FROM ticket t");
			@SuppressWarnings("unchecked")
			List<Ticket> list= (List<Ticket>) query.getResultList();

			return list;
		}

		public static List<Ticket> listTicketsByCustomerId(long id) 
		{
			Customer customer = CustomerDAO.findCustomerById(id);
			Query query = emDAO.getEM().createQuery("SELECT t FROM ticket t WHERE t.pickupcustomer = :customer");
			query.setParameter("customer", customer);
			@SuppressWarnings("unchecked")
			List<Ticket> list= (List<Ticket>) query.getResultList();

			return list;
		}
		
		public static Ticket findTicket(String username, String password) {
			Query query = emDAO.getEM().createQuery("SELECT u FROM user u WHERE u.userName = '" + username + "' and u.password = '" + password + "'");
			Ticket ticket = null;
			try
			{
				ticket = (Ticket) query.getSingleResult();
			}
			catch(Exception e)
			{
				
			}

			return ticket;
		}

		public static void removeTicket(Ticket ticket) {
			emDAO.getEM().remove(ticket);
			
		}
}
