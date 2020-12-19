package growkking.slidingwindowpattern;

import java.util.Arrays;
import java.util.Scanner;

public class AverageOfSubarrayOfSizeK {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };

		System.out.println("Enter the value of K:-> ");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		double result[] = findAverages(k, arr);

		System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
	}

	private static double[] findAverages(int k, int[] arr) {
		double[] result = new double[arr.length - k + 1];
		for (int i = 0; i <= arr.length - k; i++) {
			double sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += arr[j];
			}
			result[i] = sum / k;
		}
		return result;
	}
}
