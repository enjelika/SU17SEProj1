package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StreetMap
{	
	// Mapping of intersection names to Intersection objects, built from a set of Street Segment
	private final Map<String, Intersection> map;
	
	// Street Segment list that is used to build a map
	public static List<StreetSegment> StreetSegmentList = new ArrayList<StreetSegment>();
	
	// Build a streets map from a set of street segments
	public StreetMap(List<StreetSegment> streetSegment)
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
		final String startIntersection = "7th Ave and G Street";
		final String endIntersection = "1st Ave and A Street";
		try 
		{
			LoadMap("StreetSegments.csv");
		}
		catch(Exception ex)
		{
			System.out.println("Error reading file");  
		}
		
		StreetMap m = new StreetMap(StreetSegmentList);
		m.Dijkstra(startIntersection);
		m.PrintDirection(endIntersection);
	}
	
	// Load the map from cvs file
	public static void LoadMap(String pathName) throws IOException
	{	
		String line = null;
		String[] token;
		
		String intersection1;
		String intersection2;
		String distance;		
		
		BufferedReader bufferedReader = null;
	    try 
	    {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = new FileReader(pathName);

	        // Always wrap FileReader in BufferedReader.
	        bufferedReader = new BufferedReader(fileReader);
	       
	        // Read and discard headings in csv
	        line = bufferedReader.readLine();
	        
	        while((line = bufferedReader.readLine()) != null) 
		    {
        		//split data by comma
	        	token = line.split(",");
	        	if ( token.length < 3)
	        		throw new IOException("Bad file format: " + pathName);
	        	else
	        	{
		        	intersection1 = token[0];
		        	intersection2 = token[1];	
		        	distance = token[2];	
	        	}
	        	StreetSegmentList.add(new StreetSegment(intersection1, intersection2, Integer.parseInt(distance)));    	
	        }
	    }
	    catch(FileNotFoundException ex) 
	    {
	        System.out.println(
	            "Unable to open file '" + 
	            pathName + "'" + " at cur dir: " + System.getProperty("user.dir"));    
	        throw ex;
	    }
	    catch(IOException ex) 
	    {
	        System.out.println("Error reading file '" + pathName + "'");  
	        throw ex;
		}
	    finally
	    {
	    	 // Always close files.
	    	if ( bufferedReader != null )
	    		bufferedReader.close();     
	    }
	}
}
