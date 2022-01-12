package hashing;

public class IntersectionTwoArray {
	public static void main(String[] args) {
		int a[] = { 10, 20, 10, 30, 20 };
		int b[] = { 20, 10, 10, 40 };

		int result = findIntersection(a, b);

		System.out.println("Distinct intersection:- " + result);
	}

	private static int findIntersection(int a[], int b[]) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}

			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					result++;
					break;
				}
			}
		}
		return result;
	}
}
