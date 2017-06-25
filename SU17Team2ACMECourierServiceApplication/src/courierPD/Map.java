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
    @Column(name = "streetSegmentId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long streetSegmentId;
	
	@Column(name = "intersection1", nullable = false,length = 75, unique=false)
	private String intersection1;
	
	@Column(name = "intersection2", nullable = false,length = 75)
	private String intersection2;
	
	@Column(name = "distance", nullable = false,length = 10)
	private int distance;
	
	@Column(name = "defaultDistance", nullable = false,length = 10)
	private int defaultDistance;

	public Map()
	{
		
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
	
	public void setDefaultDistance(int defaultDistance)
	{
		this.defaultDistance = defaultDistance;
	}
	
	public int getDefaultDistance()
	{
		return defaultDistance;
	}
}
