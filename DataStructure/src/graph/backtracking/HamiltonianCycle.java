package graph.backtracking;

public class HamiltonianCycle {

	private final int V = 5;
	private int path[];

	public static void main(String[] args) {
		HamiltonianCycle hamiltonian = new HamiltonianCycle();
		int graph1[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };

		hamiltonian.hamCycle(graph1);

		int graph2[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0 }, };

		hamiltonian.hamCycle(graph2);
	}

	private int hamCycle(int graph[][]) {
		path = new int[V];

		for (int i = 0; i < V; i++) {
			path[i] = -1;
		}

		path[0] = 0;

		if (hamCycleUtil(graph, path, 1)) {
			printSolution(path);
		} else {
			System.out.println("Solution does not exist");
		}
		return 1;
	}

	private boolean hamCycleUtil(int graph[][], int path[], int curVertex) {
		if (curVertex == V) {
			if (graph[path[curVertex - 1]][path[0]] == 1) {
				return true;
			}
			return false;
		}

		for (int v = 1; v < V; v++) {
			if (isSafe(v, graph, path, curVertex)) {
				path[curVertex] = v;
				if (hamCycleUtil(graph, path, curVertex + 1)) {
					return true;
				}
				path[curVertex] = -1;
			}
		}
		return false;
	}

	private boolean isSafe(int v, int graph[][], int path[], int curVertex) {
		if (graph[path[curVertex - 1]][v] == 0) {
			return false;
		}

		for (int i = 0; i < curVertex; i++) {
			if (path[i] == v) {
				return false;
			}
		}
		return true;
	}

	private void printSolution(int path[]) {
		System.out.println("Solution Exist");

		for (int i = 0; i < path.length; i++) {
			System.out.print(" " + path[i] + " ");
		}

		System.out.println(" " + path[0] + " ");
	}
}
