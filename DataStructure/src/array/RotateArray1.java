package array;

import java.util.Scanner;

public class RotateArray1 {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Array item before rotation:- ");
		print(arr);
		System.out.println("Please enter steps:- ");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		rotate(arr, k);

		System.out.println("Array item after " + k + " step rotation");
		print(arr);

	}

	private static void rotate(int[] arr, int k) {
		if (k > arr.length) {
			k = k % arr.length;
		}

		int result[] = new int[arr.length];

		for (int i = 0; i < k; i++) {
			result[i] = arr[arr.length - k + i];
		}

		int j = 0;
		for (int i = k; i < arr.length; i++) {
			result[i] = arr[j++];
		}

		System.arraycopy(result, 0, arr, 0, arr.length);
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}
}
