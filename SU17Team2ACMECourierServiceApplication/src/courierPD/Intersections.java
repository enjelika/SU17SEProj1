package courierPD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="Intersections")

public class Intersections implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id //signifies the primary key
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "Street1", nullable = false,length = 50)
	private String street1;
	
	@Column(name = "Street2", nullable = false,length = 50)
	private String street2;
	
	@Column(name = "IsBlocked", nullable = false,length = 1)
	private String isBlocked;

	public Intersections()
	{
		
	}
	
	public long getId()
	{
		return this.id;
	}
	
	public String getStreet1()
	{
		return this.street1;
	}

	public void setStreet1(String street1)
	{
		this.street1 = street1;
	}
	
	public String getStreet2()
	{
		return this.street2;
	}

	public void setStreet2(String street2)
	{
		this.street2 = street2;
	}
	
	public String getIsBlocked()
	{
		return this.isBlocked;
	}

	public void setIsBlocked(String isBlocked)
	{
		this.isBlocked = isBlocked;
	}
}
