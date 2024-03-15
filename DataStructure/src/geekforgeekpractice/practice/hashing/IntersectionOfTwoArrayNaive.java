package geeksforgeeks.hashing;

public class IntersectionOfTwoArrayNaive {

	public static void main(String[] args) {
		int a[] = { 10, 20, 30 };
		int b[] = { 10, 30 };

		printIntersection(a, b);
	}

	private static void printIntersection(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			boolean flag = false;
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println(a[i] + " ");
			}
		}
	}
}
