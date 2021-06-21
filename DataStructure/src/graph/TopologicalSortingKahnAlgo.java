package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortingKahnAlgo {
	private int V;
	List<Integer> adjList[];

	public TopologicalSortingKahnAlgo(int v) {
		this.V = v;
		adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
	}

	private void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}

	private void topologicalSort() {
		int indegree[] = new int[V];

		for (int i = 0; i < V; i++) {
			ArrayList<Integer> temp = (ArrayList<Integer>) adjList[i];
			for (int node : temp) {
				indegree[node]++;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		int count = 0;

		ArrayList<Integer> topOrder = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			int srcVertext = queue.poll();
			topOrder.add(srcVertext);

			for (int node : adjList[srcVertext]) {
				if (--indegree[node] == 0) {
					queue.add(node);
				}
			}
			count++;
		}

		if (count != V) {
			System.out.println("Cycle detected in Graph");
			return;
		}

		for (int i : topOrder) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		TopologicalSortingKahnAlgo g = new TopologicalSortingKahnAlgo(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();
	}

}
