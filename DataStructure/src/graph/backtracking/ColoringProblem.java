package graph.backtracking;

public class ColoringProblem {
	private int[] color;
	private int V = 4;

	public static void main(String[] args) {
		ColoringProblem Coloring = new ColoringProblem();
		int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int m = 3; // Number of colors
		Coloring.graphColoring(graph, m);
	}

	private boolean graphColoring(int graph[][], int totalColor) {
		color = new int[V];
		for (int i = 0; i < V; i++) {
			color[i] = 0;
		}

		if (graphColouringUtil(graph, totalColor, color, 0)) {
			printSolution(color);
		} else {
			System.out.println("Solution does not exist");
			return false;
		}
		return true;
	}

	private boolean graphColouringUtil(int graph[][], int totalColor, int[] color, int curVertex) {
		if (curVertex == V) {
			return true;
		}

		for (int curColor = 1; curColor <= totalColor; curColor++) {
			if (isSafe(curVertex, graph, color, curColor)) {
				color[curVertex] = curColor;
				if (graphColouringUtil(graph, totalColor, color, curVertex + 1)) {
					return true;
				}
				color[curVertex] = 0;
			}
		}
		return false;
	}

	private boolean isSafe(int curVertex, int[][] graph, int[] color, int curColor) {
		for (int i = 0; i < V; i++) {
			if (graph[curVertex][i] == 1 && curColor == color[i]) {
				return false;
			}
		}
		return true;
	}

	private void printSolution(int color[]) {
		System.out.println("Solution exist");

		for (int i = 0; i < V; i++) {
			System.out.print(" " + color[i] + " ");
		}
		System.out.println();
	}
}
