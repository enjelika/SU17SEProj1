package courierDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import courierPD.Customer;
import courierPD.Ticket;

public class TicketDAO {

	public static void saveTicket(Ticket ticket) {
		emDAO.getEM().persist(ticket);
	}
	
		public static void addTicket(Ticket ticket) {
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
		
		public static List<Ticket> listTicketsByCustomerId(long id, Date startDate, Date endDate) 
		{
			Customer customer = CustomerDAO.findCustomerById(id);
			Query query = emDAO.getEM().createQuery("SELECT t FROM ticket t WHERE t.pickupcustomer = :customer");
			query.setParameter("customer", customer);
			@SuppressWarnings("unchecked")
			List<Ticket> list = (List<Ticket>) query.getResultList();
			List<Ticket> filteredList = new ArrayList<Ticket>();
			try 
			{
				Date ticketDate = new SimpleDateFormat("MM/dd/yy").parse("10/10/10");	// TODO: get date in ticket
				for(Ticket ticket : list) 
				{
					if(ticketDate.after(startDate) && ticketDate.before(endDate)) // TODO: Replace ticketDate with actual date
					{
						filteredList.add(ticket);
					}
				}
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
			return filteredList;
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
