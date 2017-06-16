package courierPD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Courier")
public class Courier implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //signifies the primary key
    @Column(name = "courier_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long courier_Id;
	
	@Column(name = "name", nullable = false,length = 50, unique=true)
	private String name;
	
	@Column(name = "isactive", nullable = false,length = 1)
	private String isActive;

	public Courier()
	{
		
	}
	
	public Courier(String name, String isactive)
	{
		this();
		this.name = name;
		this.isActive = isactive;
	}
	

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
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
