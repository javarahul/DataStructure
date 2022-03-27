public class ToweOfHanoi {

	public static void main(String[] args) {
		int n = 3;
		towerOfHanoi(n, 1, 3, 2);
	}

	private static void towerOfHanoi(int n, int s, int d, int h) {
		if (n == 1) {
			System.out.println("Moving plate " + n + " from " + s + " to " + d);
			return;
		}
		towerOfHanoi(n - 1, s, h, d);
		System.out.println("Moving plate " + n + " from " + s + " to " + d);
		towerOfHanoi(n - 1, h, d, s);
	}
}
