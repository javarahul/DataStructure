package geeksforgeeks.recursion;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("Enter the value of N:- ");
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		System.out.println("Fibonacci of:- " + n + " is:-> " + fib(n));

	}

	private static int fib(int n) {
		if (n <= 1)
			return n;

		return fib(n - 1) + fib(n - 2);
	}
}
