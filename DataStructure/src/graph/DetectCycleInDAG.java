package geeksforgeeks.graph;

import java.util.ArrayList;

public class DetectCycleInDAG {
	public static void main(String[] args) {
		int V = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 2, 1);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);
		addEdge(adj, 5, 3);

		if (DFS(adj, V) == true) {
			System.out.println("Cycle found");
		} else {
			System.out.println("No cycle found");
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}

	private static boolean DFS(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}
		boolean[] recSt = new boolean[V];
		for (int i = 0; i < V; i++) {
			recSt[i] = false;
		}
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				if (DFSRec(adj, i, visited, recSt) == true) {
					return true;
				}
		}
		return false;
	}

	private static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recSt) {
		visited[s] = true;
		recSt[s] = true;

		for (int u : adj.get(s)) {
			if (!visited[u] && DFSRec(adj, u, visited, recSt)) {
				return true;
			} else if (recSt[u]) {
				return true;
			}
		}
		recSt[s] = false;
		return false;
	}
}
