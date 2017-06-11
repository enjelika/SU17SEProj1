package courierPD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id //signifies the primary key
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "username", nullable = false,length = 50)
	private String userName;
	
	@Column(name = "password", nullable = false,length = 50)
	private String password;
	
	@Column(name = "accesslevel", nullable = false,length = 10)
	private String accessLevel;
	
	@Column(name = "isactive", nullable = false,length = 1)
	private String isActive;

	public User()
	{
		
	}
	
	public User(User team, String name, String position, String number)
	{
		this();
		//this.name = name;
		//this.position = position;
		//this.number = number;
		//team.addPlayer(this);
	}
	

	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getAccessLevel()
	{
		return this.accessLevel;
	}

	public void setAccessLevel(String accessLevel)
	{
		this.accessLevel = accessLevel;
	}
	
	public String getIsActive()
	{
		return this.isActive;
	}
	
	public void setIsActive(String isActive)
	{
		this.isActive = isActive;
	}

	/*public String toString()
	{
		return getNumber()+":"+getName()+":"+getPosition();
	}*/
	
}
