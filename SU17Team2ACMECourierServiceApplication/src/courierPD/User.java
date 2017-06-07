package courierPD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "user")
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id //signifies the primary key
    @Column(name = "player_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long playerId;
	
	/**
	 * The name of the Player
	 */
	@Column(name = "name", nullable = false,length = 50)
	private String name;
	
	/**
	 * The position the Player plays on the Team.
	 */
	@Column(name = "position", nullable = false,length = 15)
	private String position;
	
	/**
	 * The number on the Player's jersey.
	 */
	@Column(name = "number", nullable = false,length = 3)
	private String number;

	public User()
	{
		
	}
	
	public User(User team, String name, String position, String number)
	{
		this();
		this.name = name;
		this.position = position;
		this.number = number;
		//team.addPlayer(this);
	}
	

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPosition()
	{
		return this.position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String toString()
	{
		return getNumber()+":"+getName()+":"+getPosition();
	}
}
