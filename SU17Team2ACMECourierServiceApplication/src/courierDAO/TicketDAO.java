package courierDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import courierPD.Courier;
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

		public static List<Ticket> listTicketsByCourierId(long id) 
		{
			Courier courier = CourierDAO.findCourierById(id);
			Query query = emDAO.getEM().createQuery("SELECT t FROM ticket t WHERE t.courier = :courier");
			query.setParameter("courier", courier);
			@SuppressWarnings("unchecked")
			List<Ticket> list= (List<Ticket>) query.getResultList();

			return list;
		}
		
		public static List<Ticket> listTicketsByCourierId(long id, Date startDate, Date endDate) 
		{
			Courier courier = CourierDAO.findCourierById(id);
			Query query = emDAO.getEM().createQuery("SELECT t FROM ticket t WHERE t.courier = :courier");
			query.setParameter("courier", courier);
			@SuppressWarnings("unchecked")
			List<Ticket> list = (List<Ticket>) query.getResultList();
			List<Ticket> filteredList = new ArrayList<Ticket>();
			try 
			{
				for(Ticket ticket : list) 
				{
					Date ticketDate = new SimpleDateFormat("MM/dd/yy").parse(ticket.GetCreatedDate());
					if(ticketDate.after(startDate) && ticketDate.before(endDate) || ticketDate.equals(startDate) || ticketDate.equals(endDate)) 
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
				for(Ticket ticket : list) 
				{
					Date ticketDate = new SimpleDateFormat("MM/dd/yy").parse(ticket.GetCreatedDate());
					if(ticketDate.after(startDate) && ticketDate.before(endDate) || ticketDate.equals(startDate) || ticketDate.equals(endDate)) 
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
		
		public static Ticket findTicketById(long packageID) 
		{
			return emDAO.getEM().find(Ticket.class, packageID);
		}

		public static void removeTicket(Ticket ticket) {
			emDAO.getEM().remove(ticket);
			
		}
}
