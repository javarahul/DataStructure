package graph.backtracking;

public class RatInMaze {
	private static int N;

	public static void main(String[] args) {
		RatInMaze rat = new RatInMaze();
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

		N = maze.length;
		rat.solveMaze(maze);
	}

	private boolean solveMaze(int maze[][]) {
		int sol[][] = new int[N][N];
		
		boolean result = solveMazeUtil(maze,0,0,sol);
		
		if (result) {
			printSolution(sol);
		}else {
			System.out.println("Solution does not exist");
			return false;
		}
				
		return true;
	}

	private boolean solveMazeUtil(int maze[][], int x, int y, int[][] sol) {
		if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}

		if (isSafe(maze, x, y)) {
			if (sol[x][y] == 1) {
				return false;
			}

			sol[x][y] = 1;

			if (solveMazeUtil(maze, x + 1, y, sol)) {
				return true;
			}

			if (solveMazeUtil(maze, x - 1, y, sol)) {
				return true;
			}

			if (solveMazeUtil(maze, x, y + 1, sol)) {
				return true;
			}

			if (solveMazeUtil(maze, x, y - 1, sol)) {
				return true;
			}

			sol[x][y] = 0;

			return false;
		}
		return false;
	}

	private boolean isSafe(int maze[][], int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1) {
			return true;
		}
		return false;
	}

	private void printSolution(int[][] sol) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}
}
