package binarysearch;

import java.util.Scanner;

public class FindElementInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 1, 2 };
		int minElementIndex = findMinElementIndex(nums);

		System.out.println("Enetr a number which you want to search:-> ");
		Scanner sc = new Scanner(System.in);
		int element = sc.nextInt();
		int index1 = binarySearch(nums, element, 0, minElementIndex - 1);
		int index2 = binarySearch(nums, element, minElementIndex, nums.length - 1);

		if (index1 == -1 && index2 == -1) {
			System.out.println(element + " is not available");
		} else {
			int res = (index1 != -1) ? index1 : index2;
			System.out.println(element + " is availabel at position:-> " + res);
		}
	}

	private static int findMinElementIndex(int[] nums) {
		int start = 0;
		int len = nums.length;
		int end = len - 1;

		while (start <= end) {
			if (nums[start] <= nums[end]) {
				return start;
			}

			int mid = start + (end - start) / 2;
			int next = (mid + 1) % len;
			int prev = (mid + len - 1) % len;

			if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
				return mid;
			} else if (nums[mid] >= nums[start]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	private static int binarySearch(int[] nums, int elements, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == elements) {
				return mid;
			} else if (nums[mid] > elements) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
