package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

	private int v;
	private LinkedList<Integer> adj[];

	BFS(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
		boolean visited[] = new boolean[v];

		LinkedList<Integer> queue = new LinkedList<>();

		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			s = queue.poll();
			
			System.out.print(s+ " ");
			
			Iterator<Integer> ite = adj[s].listIterator();
			
			while(ite.hasNext()){
				int n = ite.next();
				
				if (!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		BFS g = new BFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}

}
