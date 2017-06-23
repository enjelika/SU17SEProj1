package courierPD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "map")
public class Map {

private static final long serialVersionUID = 1L;
	
	@Id //signifies the primary key
    @Column(name = "map_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long mapId;
	
	@Column(name = "intersection1", nullable = false,length = 75, unique=false)
	private String intersection1;
	
	@Column(name = "intersection2", nullable = false,length = 75)
	private String intersection2;
	
	@Column(name = "distance", nullable = false,length = 10)
	private int distance;
	
	@Column(name = "isactive", nullable = false,length = 1)
	private String isActive;

	public Map()
	{
		
	}
	
	public Map(String intersection1, String intersection2, int distance, String isactive)
	{
		this();
		this.intersection1 = intersection1;
		this.intersection2 = intersection2;
		this.distance = distance;
		this.isActive = isactive;
	}
	

	public String getIntersection1()
	{
		return this.intersection1;
	}

	public void setIntersection1(String intersection1)
	{
		this.intersection1 = intersection1;
	}

	public String getIntersection2()
	{
		return this.intersection2;
	}

	public void setIntersection2(String intersection2)
	{
		this.intersection2 = intersection2;
	}

	public int getDistance()
	{
		return this.distance;
	}

	public void setDistance(int distance)
	{
		this.distance = distance;
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
