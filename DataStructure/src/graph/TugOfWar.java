package graph;

public class TugOfWar {
	private int minDiff;

	public static void main(String[] args) {
		int arr[] = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
		TugOfWar a = new TugOfWar();
		a.tugOfWar(arr);
	}

	void tugOfWar(int arr[]) {
		int n = arr.length;

		boolean currElements[] = new boolean[n];
		boolean soln[] = new boolean[n];

		minDiff = Integer.MAX_VALUE;

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			currElements[i] = soln[i] = false;
		}

		TOWUtil(arr, n, currElements, 0, soln, sum, 0, 0);

		System.out.print("The First Subset is: ");
		for (int i = 0; i < n; i++) {
			if (soln[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.print("\nThe Second Subset is: ");
		for (int i = 0; i < n; i++) {
			if (!soln[i]) {
				System.out.print(arr[i] + " ");
			}
		}
	}

	private void TOWUtil(int[] arr, int n, boolean[] currElements, int noOfSelEle, boolean[] soln, int sum, int curSum,
			int curPos) {
		if (curPos == n) {
			return;
		}

		if ((n / 2 - noOfSelEle) > (n - curPos)) {
			return;
		}

		TOWUtil(arr, n, currElements, noOfSelEle, soln, sum, curSum, curPos + 1);

		noOfSelEle++;
		curSum = curSum + arr[curPos];
		currElements[curPos] = true;

		if (noOfSelEle == n / 2) {
			if (Math.abs(sum / 2 - curSum) < minDiff) {
				minDiff = Math.abs(sum / 2 - curSum);

				for (int i = 0; i < n; i++) {
					soln[i] = currElements[i];
				}
			}
		} else {
			TOWUtil(arr, n, currElements, noOfSelEle, soln, sum, curSum, curPos + 1);
		}
		currElements[curPos] = false;
	}
}
