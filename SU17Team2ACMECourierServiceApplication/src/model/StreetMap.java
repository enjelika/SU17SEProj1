package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import courierDAO.MapDAO;
import courierPD.Courier;

public class StreetMap
{	
	// Mapping of intersection names to Intersection objects, built from a set of Street Segment
	private static Map<String, Intersection> map;
	
	// Map file Name
	private String mapFileName = "StreetSegments.csv";
			
	// Direction for the courier
	public String Direction = "";
	
	// Total Traveled Distance
	public int TotalDistance = 0;
	
	// Street Segment list that is used to build a map
	public static List<StreetSegment> StreetSegmentList = new ArrayList<StreetSegment>();
	
	// Constructor
	public StreetMap() 
	{
		try 
		{
			LoadMap();
		}
		catch(Exception ex)
		{
			System.out.println("Error reading file");  
		}
		
		BuildStreetMap(StreetSegmentList);
	}
	
	// Build a streets map from a set of street segments
	public static void BuildStreetMap(List<StreetSegment> streetSegment)
	{
		//map = new HashMap<>(streetSegment.length);
		map = new HashMap<>(streetSegment.size());
		
		// One pass to find all intersections
		for (StreetSegment ss : streetSegment) 
		{
			if (!map.containsKey(ss.street1)) 
				map.put(ss.street1, new Intersection(ss.street1));
			if (!map.containsKey(ss.street2)) 
				map.put(ss.street2, new Intersection(ss.street2));
		}
		
		// Another pass to set neighboring intersections
		for (StreetSegment ss : streetSegment) 
		{
			map.get(ss.street1).neighbours.put(map.get(ss.street2), ss.distance);
		}
	}
	
	// Runs Dijkstra using a specified source intersection
	public void Dijkstra(String startIntersection) 
	{
		if (!map.containsKey(startIntersection)) 
		{
			System.err.printf("Graph does not contain start intersection \"%s\"\n", startIntersection);
		}
		final Intersection source = map.get(startIntersection);
		NavigableSet<Intersection> intersectionSet = new TreeSet<>();
		
		// Setup intersections
		for (Intersection i : map.values()) 
		{
			i.previous = i == source ? source : null;
			i.distance = i == source ? 0 : Integer.MAX_VALUE;
			intersectionSet.add(i);
		}
		
		dijkstra(intersectionSet);
	}
	
	// Implementation of dijkstra's algorithm using a binary heap
	private void dijkstra(final NavigableSet<Intersection> IntersectionSet) 
	{
		Intersection intersection1, intersection2;
		while(!IntersectionSet.isEmpty()) 
		{
			// Intersection with shortest distance (first iteration will return source)
			intersection1 = IntersectionSet.pollFirst();
			
			// We can ignore intersection 1 (and any other remaining intersection) since they are unreachable
			if(intersection1.distance == Integer.MAX_VALUE) break;
			
			// Look at distance to each neighbor
			for (Map.Entry<Intersection, Integer> entry : intersection1.neighbours.entrySet()) 
			{
				// The neighbor in this iteration
				intersection2 = entry.getKey();
				
				final int alternateDistance = intersection1.distance + entry.getValue();
				if(alternateDistance < intersection2.distance) 
				{
					// Shorter path to neighbor found
					IntersectionSet.remove(intersection2);
					intersection2.distance = alternateDistance;
					intersection2.previous = intersection1;
					IntersectionSet.add(intersection2);
				}
			}
		}
	}
	
	// Prints a direction from the source to the specified intersection
	public void GetDirection(String endIntersection, String description) 
	{
		if(!map.containsKey(endIntersection)) 
		{
			System.err.printf("Map does not contain destination \"%s\"\n", endIntersection);
			return;
		}
		
		TotalDistance += map.get(endIntersection).distance;	// Get the total traveled distance
		map.get(endIntersection).GetDirection(description);
		Direction = map.get(endIntersection).Direction;	// Get the direction for the courier
	}
	
	// Load the map from cvs file
	public static void LoadMap() throws IOException
	{			
		List<courierPD.Map> mapList = MapDAO.listMap();
		for (courierPD.Map item : mapList) {
			StreetSegmentList.add(new StreetSegment(item.getIntersection1(), item.getIntersection2(), item.getDistance()));    	
		}
	}
}
