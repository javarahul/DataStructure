package recursion;

public class knapsack {

	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {
		if (w == 0 || n == 0) {
			return 0;
		}

		if (wt[n - 1] <= w) {
			return Math.max(val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1), knapSack(w, wt, val, n - 1));
		} else {
			return knapSack(w, wt, val, n - 1);
		}
	}
}
