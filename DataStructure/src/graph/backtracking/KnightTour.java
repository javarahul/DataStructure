package graph.backtracking;

public class KnightTour {

	private static int N = 8;

	public static void main(String[] args) {
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		int sol[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sol[i][j] = -1;
			}
		}

		solveKnightTour(sol, xMove, yMove);
	}

	private static boolean solveKnightTour(int sol[][], int xMove[], int[] yMove) {
		sol[0][0] = 0;

		boolean result = solveKTUtil(0, 0, 1, sol, xMove, yMove);

		if (result) {
			printSolution(sol);
		} else {
			System.out.println("Solution does not exist");
			return false;
		}
		return true;
	}

	private static boolean solveKTUtil(int x, int y, int totalMove, int[][] sol, int[] xMove, int[] yMove) {
		int k;
		int next_x;
		int next_y;

		if (totalMove == N * N) {
			return true;
		}

		for (k = 0; k < N; k++) {
			next_x = x + xMove[k];
			next_y = y + yMove[k];
			if (isSafe(next_x, next_y, sol)) {
				sol[next_x][next_y] = totalMove;

				if (solveKTUtil(next_x, next_y, totalMove + 1, sol, xMove, yMove)) {
					return true;
				} else {
					sol[next_x][next_y] = -1;
				}
			}

		}
		return false;
	}

	private static boolean isSafe(int x, int y, int[][] sol) {
		if (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1) {
			return true;
		}
		return false;
	}

	private static void printSolution(int sol[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}
}
