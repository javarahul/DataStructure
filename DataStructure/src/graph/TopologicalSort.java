package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

	private int V;
	private ArrayList<ArrayList<Integer>> adjList;

	public TopologicalSort(int v) {
		this.V = v;
		adjList = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}

	private void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
	}

	private void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();

		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}

		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				topologicalSortUtil(v, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		int i;

		Iterator<Integer> ite = adjList.get(v).iterator();

		while (ite.hasNext()) {
			i = ite.next();
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		stack.push(v);
	}

	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		// Function Call
		g.topologicalSort();
	}

}
