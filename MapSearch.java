package ajain5.HW4;

import algs.hw4.map.HighwayMap;

import algs.hw4.map.Information;
import algs.days.day22.BreadthFirstPaths;
import algs.days.day21.DepthFirstPaths;

/**
 * Copy this class into USERID.hw4 and make changes.
 */
public class MapSearch {
	
	/**
	 * This method must create a copy of the graph, which you can do by creating a new graph with 
	 * the same number of vertices as the original one, BUT you only add an edge to the copy
	 * if the edge in the original graph IS NOT involved in the M25.
	 * 
	 * For example, in the data set you will see two nodes:
	 * 
	 *      E13@6a(M1)&E30@21(M25)&M1@6a&M25@21 51.716288 -0.385208
	 * 		E30/M25@+M25(X14) 51.713257 -0.421343
	 * 
	 * These lines correspond to vertex #114 (the first one) and vertex #1196 (the second one).
	 * Because the label for both of these vertices includes "M25" this edge must not appear in 
	 * the copied graph, since it is a highway segment involving the M25.
	 * 
	 * Note that the edge is eliminated even when only one of the nodes involves M25.
	 */
	static Information remove_M25_segments(Information info) {
		
		edu.princeton.cs.algs4.Graph g = info.graph;
		edu.princeton.cs.algs4.Graph copy = new edu.princeton.cs.algs4.Graph(g.V());

		// DO YOUR WORK HERE...
		for(int i = 0;i < g.V(); i++) {
			Iterable<Integer> adjEdge = g.adj(i);
			//String
			for(int j: adjEdge) {
				if(i<j) {
					if(!(info.labels.get(j).contains("M25")) && !(info.labels.get(i).contains("M25"))) {
						copy.addEdge(i, j);
					}
				}
				
			}
		}
		//BreadthFirstPaths M25BFS = new BreadthFirstPaths(g, north);
		
		Information newInfo = new Information(copy, info.positions, info.labels);
		return newInfo;
	}
	
	/** 
	 * This helper method returns the western-most data point in the Information, given its latitude and
	 * longitude.
	 * 
	 * https://en.wikipedia.org/wiki/Latitude
	 * https://en.wikipedia.org/wiki/Longitude
	 * 
	 */
	public static int westernMostVertex(Information info) {
		int south = Integer.MAX_VALUE;
		float smallLat = Integer.MAX_VALUE;
		
		Iterable<Integer> MyKeys = info.positions.keys();
		
		for(Integer i: MyKeys){
			float smallestlong = info.positions.get(i).longitude;
			
			if(smallestlong < smallLat) {
				
				south = i;
				smallLat = smallestlong;
			}	
		}
		 
		return (int) (south);
	}

	/** 
	 * This helper method returns the western-most data point in the Information, given its latitude and
	 * longitude.
	 * 
	 * https://en.wikipedia.org/wiki/Latitude
	 * https://en.wikipedia.org/wiki/Longitude
	 * 
	 */
	public static int easternMostVertex(Information info) {
		int north = Integer.MIN_VALUE;
		float largeLat = Integer.MIN_VALUE;
		
		Iterable<Integer> MyKeys = info.positions.keys();
		
		for(Integer i: MyKeys){
			float largestlong = info.positions.get(i).longitude;
			
			if(largestlong > largeLat) {
				
				north = i;
				largeLat = largestlong;
			}	
		}
		 
		return (int) (north);
		
	}
	
	/** 
	 * This helper method returns the southern-most data point in the Information, given its latitude and
	 * longitude.
	 * 
	 * https://en.wikipedia.org/wiki/Latitude
	 * https://en.wikipedia.org/wiki/Longitude
	 * 
	 */
	public static int southernMostVertex(Information info) {
		int south = Integer.MAX_VALUE;
		float smallLat = Integer.MAX_VALUE;
		
		Iterable<Integer> MyKeys = info.positions.keys();
		
		for(Integer i: MyKeys){
			float smallestlong = info.positions.get(i).latitude;
			
			if(smallestlong < smallLat) {
				
				south = i;
				smallLat = smallestlong;
			}	
		}
		 
		return (int) (south);
	}
	
	/** 
	 * This helper method returns the northern-most data point in the Information, given its latitude and
	 * longitude.
	 * 
	 * https://en.wikipedia.org/wiki/Latitude
	 * https://en.wikipedia.org/wiki/Longitude
	 * 
	 */
	public static int northernMostVertex(Information info) {
		int north = Integer.MIN_VALUE;
		float largeLat = Integer.MIN_VALUE;
		
		Iterable<Integer> MyKeys = info.positions.keys();
		
		for(Integer i: MyKeys){
			float largestlong = info.positions.get(i).latitude;
			
			if(largestlong > largeLat) {
				
				north = i;
				largeLat = largestlong;
			}	
		}
		 
		return (int) (north);
		//throw new RuntimeException("Student Completes");
	}

	public static void main(String[] args) {
		Information info = HighwayMap.undirectedGraph();
		int west = westernMostVertex(info);
		int east = easternMostVertex(info);

		int south = southernMostVertex(info);
		int north = northernMostVertex(info);
		
		//BFS West to East
		
		BreadthFirstPaths bfsWestToEast = new BreadthFirstPaths(info.graph, west);
		Iterable<Integer> pathEast = bfsWestToEast.pathTo(east);
		String westLabel = info.labels.get(west);
		String eastLabel = info.labels.get(east);
		
		
		int WestToEastEdges = 0;
		for(int i: pathEast) {
			WestToEastEdges++;
		}
		WestToEastEdges--;
		//BFS South to North
		BreadthFirstPaths bfsSouthToNorth = new BreadthFirstPaths(info.graph, south);
		Iterable<Integer> pathNorth = bfsSouthToNorth.pathTo(north);
		int StoN_Edge = bfsSouthToNorth.distTo(north);
		String southLabel = info.labels.get(south);
		String northLabel = info.labels.get(north);
		
		
		int SouthToNorthEdges = 0;
		for(int i: pathNorth) {
			SouthToNorthEdges++;
		}
		SouthToNorthEdges--;
		//West to East DFS
		DepthFirstPaths dfsWestToEast = new DepthFirstPaths(info.graph, west);
		Iterable<Integer> pathEastDFS = dfsWestToEast.pathTo(east);
		int WestToEastEdgesdfs = 0;
		for(int i: pathEastDFS) {
			WestToEastEdgesdfs++;
		}
		WestToEastEdgesdfs--;
		
		DepthFirstPaths dfsSouthToNorth = new DepthFirstPaths(info.graph, south);
		Iterable<Integer> pathNorthDFS = dfsSouthToNorth.pathTo(north);
		int SouthToNOrthEdgesdfs = 0;
		for(int i: pathNorthDFS) {
			SouthToNOrthEdgesdfs++;
		}
		SouthToNOrthEdgesdfs--;
		System.out.println("BreadthFirst Search from West to East:");
		// DO SOME WORK HERE
		System.out.println("BFS: " + westLabel + "(" + west + ") to " + eastLabel + "(" + east + ") has " + WestToEastEdges + " edges.");
		
		
		System.out.println("\nBreadthFirst Search from South to North:");
		// DO SOME WORK HERE
		System.out.println("BFS: " + southLabel + "(" + south + ") to " + northLabel + "(" + north + ") has " + SouthToNorthEdges + " edges.");
		
		System.out.println("\nDepthFirst Search from West to East:");
		// DO SOME WORK HERE
		System.out.println("DFS: " + westLabel + "(" + west + ") to " + eastLabel + "(" + east + ") has " + WestToEastEdgesdfs + " edges.");
		
		System.out.println("\nDepthFirst Search from South to North:");
		// DO SOME WORK HERE
		System.out.println("DFS: " + southLabel + "(" + south + ") to " + northLabel + "(" + north + ") has " + SouthToNOrthEdgesdfs + " edges.");
		
		System.out.println("\nNow without M25 edges...\n");
		System.out.println("WEST to EAST");
		
		
		Information info_no_m25 = remove_M25_segments(info);
		//West to East M25 remove
			//	BreadthFirstPaths
		BreadthFirstPaths WestToEastM25 = new BreadthFirstPaths(info_no_m25.graph, west);
		Iterable<Integer> pathEastM25 = WestToEastM25.pathTo(east);
		int WestToEastEdgesM25 = 0;
		for(int i: pathEastM25) {
			WestToEastEdgesM25++;
		}
		WestToEastEdgesM25--;
		BreadthFirstPaths SouthToNorthM25 = new BreadthFirstPaths(info_no_m25.graph, south);
		Iterable<Integer> pathNorthM25 = SouthToNorthM25.pathTo(north);
		int SouthToNorthEdgesM25 = 0;
		for(int i: pathNorthM25) {
			SouthToNorthEdgesM25++;
		}
		SouthToNorthEdgesM25--;
		// DO SOME WORK HERE
		System.out.println("BFS: " + westLabel + "(" + west + ") to " + eastLabel + "(" + east + ") has " + WestToEastEdgesM25 + " edges.");
		
		System.out.println("\nNORTH to SOUTH");
		// DO SOME WORK HERE
		System.out.println("BFS: " + southLabel + "(" + south + ") to " + northLabel + "(" + north + ") has " + SouthToNorthEdgesM25 + " edges.");
				
	}
	
}
