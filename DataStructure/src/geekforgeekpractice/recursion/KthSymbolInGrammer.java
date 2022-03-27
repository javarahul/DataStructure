import java.util.Scanner;

public class KthSymbolInGrammer {

	public static void main(String[] args) {
		System.out.println("Enter value of N:-> ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println("Enter value of K:-> ");
		int K = sc.nextInt();

		int kthSymbol = solution(N, K);

		System.out.println("kthSymbol:-> " + kthSymbol);
	}

	private static int solution(int n, int k) {
		if (n == 1 && k == 1) {
			return 0;
		}

		int mid = (int) Math.pow(2, n - 1) / 2;

		if (k <= mid) {
			return solution(n - 1, k);
		} else {
			int num = ~solution(n - 1, k - mid);
			if (num < 1) {
				num = 2 + num;
			}
			return num;
		}
	}
}
