package graph.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class coloringProblemBFS {

	public static void main(String[] args) {
		int n = 4;
		int[][] graph = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 } };
		int m = 3; // Number of colors

		ArrayList<Node> nodes = new ArrayList<Node>();

		for (int i = 0; i < n + 1; i++) {
			nodes.add(new Node());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] > 0) {
					nodes.get(i).edges.add(i);
					nodes.get(j).edges.add(j);
				}
			}
		}

		System.out.println(canPaint(nodes, n, m));
	}

	private static int canPaint(ArrayList<Node> nodes, int n, int m) {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) {
			visited.add(0);
		}

		int maxColor = 1;
		for (int v = 1; v <= n; v++) {
			if (visited.get(v) > 0) {
				continue;
			}

			visited.set(v, 1);

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(v);

			while (!queue.isEmpty()) {
				int top = queue.peek();
				queue.remove();
				
				for (int it: nodes.get(top).edges) {
					if (nodes.get(top).color == nodes.get(it).color) {
						nodes.get(it).color+=1;
					}
					
					maxColor = Math.max(maxColor, Math.max(nodes.get(top).color, 
							nodes.get(it).color));
					
					if (maxColor>m) {
						return 0;
					}
					
					if (visited.get(it)==0) {
						visited.set(it, 1);
						queue.remove(it);
					}
				}
			}
		}
		return 1;
	}

}

class Node {
	int color = 1;
	Set<Integer> edges = new HashSet<Integer>();
}
