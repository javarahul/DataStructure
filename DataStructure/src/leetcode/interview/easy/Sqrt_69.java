package leatcode.interview.easy;

public class Sqrt_69 {

	public static void main(String[] args) {
		int x = 8;
		int ans = mySqrt(x);
		System.out.println("SQRT:-> " + ans);
	}

	public static int mySqrt(int x) {
		long ans = 0;
		while (ans * ans <= x) {
			ans++;
		}
		return (int)(ans - 1);
	}
}
