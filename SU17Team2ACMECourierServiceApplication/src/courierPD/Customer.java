package courierPD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "customer")
public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id //signifies the primary key
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long customerID;
	
	@Column(name = "customerName", nullable = false, length = 30, unique = true)
	private String customerName;
	
	@Column(name = "address", nullable = false, length = 50)
	private String address;
	
	@Column(name = "isactive", nullable = false, length = 1)
	private String isActive;

	public Customer()
	{
		
	}
	
	public Customer(String customerName, String address, String isactive)
	{
		this();
		this.customerName = customerName;
		this.address = address;
		this.isActive = isactive;
	}

	// Update the customer information
	public void UpdateCustomer(long customerID, String customerName, String address, String isActive) 
	{
		this.customerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.isActive = isActive;
	}
	
	public long getCustomerID() 
	{
		return customerID;
	}
	
	public void setCustomerID(long customerID) 
	{
		this.customerID = customerID;
	}
	
	public String getName()
	{
		return this.customerName;
	}

	public void setUserName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getIsActive()
	{
		return this.isActive;
	}
	
	public void setIsActive(String isActive)
	{
		this.isActive = isActive;
	}
}
