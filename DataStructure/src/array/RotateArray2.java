package array;

import java.util.Scanner;

public class RotateArray2 {
	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4,5,6,7};
		
		System.out.println("Array before Rotation");
		print(arr);
		
		System.out.println("Enter steps for rotation");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		rotate(arr, k);

		System.out.println("Array after Rotation");
		print(arr);
	}

	private static void rotate(int[] arr, int k){
		if (arr == null || k < 0){
			throw new IllegalArgumentException("IllegalArgument");
		}		
		for (int i = 0; i < k; i++){
			for (int j = arr.length - 1; j > 0; j--){
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			} 
		}
	}

	private static void print(int[] arr){
		for (int i = 0; i < arr.length; i++){
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}
}
