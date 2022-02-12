package geeksforgeeks.recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("Enter the value of N:- ");
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("Factorial of " + n + " is:- " + fact(n));
	}

	private static int fact(int n) {
		if (n == 0)
			return 1;

		return n * fact(n - 1);
	}
}
