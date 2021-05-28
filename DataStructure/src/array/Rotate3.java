package array;

import java.util.Scanner;

public class Rotate3 {
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
	
	private static void rotate(int arr[], int k){
		if (arr == null || arr.length <= 0 || k < 0){
			throw new IllegalArgumentException("Illegal Exception");
		}
		if (k > arr.length){
			k = k % arr.length;
		}

		int arrayWithoutKItem = arr.length - k;

		reverse(arr, 0, arrayWithoutKItem - 1);
		reverse(arr, arrayWithoutKItem, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}

	private static void reverse(int arr[], int left, int right){
		if (arr == null || arr.length == 1){
			return;
		}

		while (left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	private static void print(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}
}
