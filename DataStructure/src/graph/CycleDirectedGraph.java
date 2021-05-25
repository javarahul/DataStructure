package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CycleDirectedGraph {
	private int v;
	private List<List<Integer>> adj;

	public CycleDirectedGraph(int v) {
		this.v = v;
		adj = new ArrayList<>(v);

		for (int i = 0; i < v; i++) {
			adj.add(new LinkedList<Integer>());
		}
	}

	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	private boolean isCyclic() {
		boolean visited[] = new boolean[v];
		boolean recStack[] = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
		if (recStack[i]) {
			return true;
		}

		if (visited[i]) {
			return false;
		}

		visited[i] = true;
		recStack[i] = true;

		List<Integer> child = adj.get(i);

		for (Integer c : child) {
			if (isCyclicUtil(c, visited, recStack)) {
				return true;
			}
		}

		recStack[i] = false;
		return false;
	}

	public static void main(String[] args) {
		CycleDirectedGraph graph = new CycleDirectedGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't " + "contain cycle");
	}
}
