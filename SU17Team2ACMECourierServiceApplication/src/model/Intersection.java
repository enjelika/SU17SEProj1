package model;

import java.util.HashMap;
import java.util.Map;

public class Intersection implements Comparable<Intersection>
{

	public final String streetName;
	public String Direction = "";
	public int distance;
	public Intersection previous = null;
	public final Map<Intersection, Integer> neighbours = new HashMap<>();
	
	public Intersection(String name) 
	{
		this.streetName = name;
	}
	
	public void GetDirection(String description) 
	{
		if(this == this.previous) 
		{
			Direction = this.previous.Direction.concat("-------- " + description + "\n START: " + this.streetName + "\n");
		}
		else if (this.previous == null) 
		{
			Direction = this.previous.Direction.concat(this.streetName + "(unreached)");
		}
		else 
		{
			this.previous.GetDirection(description);
			Direction = this.previous.Direction.concat(" GO TO: " + this.streetName + " (traveled " + this.distance + " blocks)\n");
		}
	}
	
	@Override
	public int compareTo(Intersection other)
	{
		if(distance == other.distance) 
			return streetName.compareTo(other.streetName);
		return Integer.compare(distance, other.distance);
	}
	
	public String toString() 
	{
		return "(" + streetName + "," + distance + ")";
	}
}
