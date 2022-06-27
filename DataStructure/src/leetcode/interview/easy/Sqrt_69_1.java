package leatcode.interview.easy;

public class Sqrt_69_1 {

	public static void main(String[] args) {
		int x = 8;
		int ans = mySqrt(x);
		System.out.println("SQRT:-> " + ans);
	}

	public static int mySqrt(int x) {
		long ans = 0;
		long l = 0;
		long r = Integer.MAX_VALUE;

		while (l <= r) {
			long mid = l + (r - l) / 2;
			if (mid * mid <= x) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return (int) ans;
	}
}
