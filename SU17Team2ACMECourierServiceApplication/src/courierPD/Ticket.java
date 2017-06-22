package courierPD;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "ticket")
public class Ticket implements Serializable
{
private static final long serialVersionUID = 1L;
	
	@Id //signifies the primary key
    @Column(name = "ticket_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long ticketId;
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pickupcustomer",referencedColumnName="customer_id") 
	private Customer pickupcustomer;
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "deliverycustomer",referencedColumnName="customer_id") 
	private Customer deliverycustomer;
	
	@Column(name = "pickuptime", nullable = true,length = 10)
	private String pickuptime;
	
	@Column(name = "deliverytime", nullable = true,length = 10)
	private String deliverytime;
	
	@Column(name = "estimateddeliverytime", nullable = false,length = 10)
	private String estimateddeliverytime;
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "courier",referencedColumnName="courier_id") 
	private Courier courier;
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "payee",referencedColumnName="customer_id") 
	private Customer payee;
	
	@Column(name = "cost", nullable = false,length = 10)
	private String cost;
	
	@Column(name = "paid", nullable = true,length = 10)
	private String paid;

	@Column(name = "createdDate", nullable = true,length = 10)
	private String createdDate;
	
	public Ticket()
	{
		
	}
	
	public Ticket(Customer pickupcustomer, Customer deliverycustomer, String pickuptime, String deliverytime,
			String estimateddeliverytime, Courier courier, Customer payee, String cost, String paid)
	{
		this();
		this.pickupcustomer = pickupcustomer;
		this.deliverycustomer = deliverycustomer;
		this.pickuptime = pickuptime;
		this.deliverytime = deliverytime;
		this.estimateddeliverytime = estimateddeliverytime;
		this.courier = courier;
		this.payee = payee;
		this.cost = cost;
		this.paid = paid;
	}
	
	public Customer GetPickupCustomer()
	{
		return this.pickupcustomer;
	}
	
	public void SetPickupCustomer(Customer pickupcustomer)
	{
		this.pickupcustomer = pickupcustomer;
	}
	
	public Customer GetDeliveryCustomer()
	{
		return this.deliverycustomer;
	}
	
	public void SetDeliveryCustomer(Customer deliverycustomer)
	{
		this.deliverycustomer = deliverycustomer;
	}
	public String GetPickupTime()
	{
		return this.pickuptime;
	}
	
	public void SetPickupTime(String pickuptime)
	{
		this.pickuptime = pickuptime;
	}
	
	public String GetDeliveryTime()
	{
		return this.deliverytime;
	}
	
	public void SetDeliveryTime(String deliverytime)
	{
		this.deliverytime = deliverytime;
	}
	
	public String GetEstimatedDeliveryTime()
	{
		return this.estimateddeliverytime;
	}
	
	public void SetEstimatedDeliveryTime(String estimateddeliverytime)
	{
		this.estimateddeliverytime = estimateddeliverytime;
	}
	
	public Customer GetPayee()
	{
		return this.payee;
	}
	
	public void SetPayee(Customer payee)
	{
		this.payee = payee;
	}
	
	public String GetCost()
	{
		return this.cost;
	}
	
	public void SetCost(String cost)
	{
		this.cost = cost;
	}
	
	public String GetPaid()
	{
		return this.paid;
	}
	
	public void SetPaid(String paid)
	{
		this.paid = paid;
	}
	
	public String GetCreatedDate()
	{
		return this.createdDate;
	}
	
	public void SetCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}
	
	public long GetTicketID() 
	{
		return ticketId;
	}
	
	public Courier GetCourier() 
	{
		return courier;
	}
}
