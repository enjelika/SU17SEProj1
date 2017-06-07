package model;

import java.util.HashMap;
import java.util.Map;

public class Intersection implements Comparable<Intersection>
{

	public final String streetName;
	public int distance = Integer.MAX_VALUE;
	public Intersection previous = null;
	public final Map<Intersection, Integer> neighbours = new HashMap<>();
	
	public Intersection(String name) 
	{
		this.streetName = name;
	}
	
	public void PrintDirection() 
	{
		if(this == this.previous) 
		{
			System.out.printf("%s", this.streetName);
		}
		else if (this.previous == null) 
		{
			System.out.printf("%s(unreached)", this.streetName);
		}
		else 
		{
			this.previous.PrintDirection();
			System.out.printf(" --> %s(%d blocks)", this.streetName, this.distance);
			//System.out.printf(" --> %s", this.streetName);
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
