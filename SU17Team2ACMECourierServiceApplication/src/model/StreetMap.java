package model;

import java.util.*;

public class StreetMap
{	
	// Mapping of intersection names to Intersection objects, built from a set of Street Segment
	private final Map<String, Intersection> map;
	
	// Build a streets map from a set of street segments
	public StreetMap(StreetSegment[] streetSegment) 
	{
		map = new HashMap<>(streetSegment.length);
		
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
		
		Dijkstra(intersectionSet);
	}
	
	// Implementation of dijkstra's algorithm using a binary heap
	private void Dijkstra(final NavigableSet<Intersection> IntersectionSet) 
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
	public void PrintDirection(String endIntersection) 
	{
		if(!map.containsKey(endIntersection)) 
		{
			System.err.printf("Map does not contain destionation \"%s\"\n", endIntersection);
			return;
		}
		
		map.get(endIntersection).PrintDirection();
		System.out.println();
	}
	
	// Prints all possible directions
	public void PrintAllDirections() 
	{
		for (Intersection i : map.values()) 
		{
			i.PrintDirection();
			System.out.println();
		}
	}
	
	// For testing purpose
	public static void testMap() 
	{
		//int Blocked = Integer.MAX_VALUE;
		int Blocked = 9999;
		
		final StreetSegment[] streetSegmentList = 
		{
			new StreetSegment("A1", "B1", Blocked),
			new StreetSegment("B1", "A1", 1),		     
			new StreetSegment("A1", "A2", 1),		      
			new StreetSegment("A2", "A1", Blocked),		     
			new StreetSegment("B1", "C1", Blocked),		      
			new StreetSegment("C1", "B1", 1),		      
			new StreetSegment("B1", "B2", Blocked),		      		      
			new StreetSegment("B2", "B1", 1),		      
			new StreetSegment("C1", "C2", 1),		      		      
			new StreetSegment("C2", "C1", Blocked),		
			new StreetSegment("A2", "B2", 1),		      		      
			new StreetSegment("B2", "A2", 1),		
			new StreetSegment("B2", "C2", 1),		      		      
			new StreetSegment("C2", "B2", 1),
			new StreetSegment("A2", "A3", 1),		      		      
			new StreetSegment("A3", "A2", Blocked),
			new StreetSegment("B2", "B3", Blocked),		      		      
			new StreetSegment("B3", "B2", 1),
			new StreetSegment("C2", "C3", 1),		      		      
			new StreetSegment("C3", "C2", Blocked),
			new StreetSegment("A3", "B3", Blocked),		      		      
			new StreetSegment("B3", "A3", 1),
			new StreetSegment("B3", "C3", Blocked),		      		      
			new StreetSegment("C3", "B3", 1),
		};
		
		final String startIntersection = "C3";
		final String endIntersection = "A1";
		
		StreetMap m = new StreetMap(streetSegmentList);
		m.Dijkstra(startIntersection);
		m.PrintDirection(endIntersection);
	}
}
