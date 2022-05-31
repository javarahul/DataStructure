package geeksforgeeks.graph;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {
	public static void main(String[] args) {
		int V = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 4);
		addEdge(adj, 4, 5);
		addEdge(adj, 1, 3);
		addEdge(adj, 2, 3);

		if (DFS(adj, V)) {
			System.out.println("Cycle found");
		} else {
			System.out.println("No cycle found");
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	private static boolean DFS(ArrayList<ArrayList<Integer>> adj, int v) {
		boolean visited[] = new boolean[v];
		for (int i = 0; i < v; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				if (DFSRec(adj, i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int sourceVertex, boolean[] visited, int parent) {
		visited[sourceVertex] = true;
		for (int adjElement : adj.get(sourceVertex)) {
			if (!visited[adjElement]) {
				if (DFSRec(adj, adjElement, visited, sourceVertex)) {
					return true;
				}
			} else if (adjElement != parent) {
				return true;
			}
		}
		return false;
	}
}
