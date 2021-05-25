package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	private int v;
	private LinkedList<Integer> adj[];

	DFS(int v) {
		this.v = v;
		adj = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> ite = adj[v].listIterator();
		while (ite.hasNext()) {
			int n = ite.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}

	void DFSPrg(int startIngIndex) {
		boolean visited[] = new boolean[v];
		DFSUtil(startIngIndex, visited);
	}

	public static void main(String[] args) {
		DFS g = new DFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFSPrg(0);
	}

}
