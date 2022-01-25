package hashing;

public class UnionForUnsortedArray {

	public static void main(String[] args) {
		int a[] = { 10, 30, 10, 18, 30, 20 };
		int b[] = { 5, 10, 5, 15 };

		int result = getDistUnion(a, b);

		System.out.println("Union of 2 unsorted Arrays: " + result);
	}

	private static int getDistUnion(int a[], int b[]) {
		int result = 0;
		int dist[] = new int[a.length + b.length];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			boolean flag = false;
			for (int j = 0; j < dist.length; j++) {
				if (a[i] == dist[j]) {
					flag = true;
					break;
				}
			}

			if (flag) {
				continue;
			} else {
				result++;
				dist[k] = a[i];
				k++;
			}
		}

		for (int i = 0; i < b.length; i++) {
			boolean flag = false;
			for (int j = 0; j < dist.length; j++) {
				if (b[i] == dist[j]) {
					flag = true;
					break;
				}
			}

			if (flag) {
				continue;
			} else {
				result++;
				dist[k] = b[i];
				k++;
			}
		}

		/*
		 * for (int i = 0; i < dist.length; i++) { System.out.print(dist[i] + ", "); }
		 */
		return result;
	}
}
