package graph.backtracking;

public class NQueenProblem {
	private static int N = 4;

	public static void main(String[] args) {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		NQueenProblem queenProblem = new NQueenProblem();

		queenProblem.solveNQ(board);
	}

	private boolean solveNQ(int[][] board) {
		boolean result = solveNQUtil(board, 0);

		if (result) {
			printSolution(board);
		} else {
			System.out.println("Solution does not exist");
			return false;
		}
		return true;
	}

	private boolean isSafe(int[][] board, int row, int column) {
		int i, j;

		for (i = 0; i < column; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		for (i = row, j = column; i < N && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	private boolean solveNQUtil(int[][] board, int column) {
		if (column >= N) {
			return true;
		}

		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, column)) {
				board[i][column] = 1;

				if (solveNQUtil(board, column + 1)) {
					return true;
				}

				board[i][column] = 0;
			}
		}

		return false;
	}

	private void printSolution(int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
