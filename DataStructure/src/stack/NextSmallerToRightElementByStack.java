package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerToRightElementByStack {

	public static void main(String[] args) {
		int arr[] = {  4, 5, 2, 10, 8 };
		getNextSmallerToRight(arr);
	}

	public static void getNextSmallerToRight(int[] arr) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (stack.size() == 0) {
				arrayList.add(-1);
			} else if (stack.size() > 0 && stack.peek() < arr[i]) {
				arrayList.add(stack.peek());
			} else if (stack.size() > 0 && stack.peek() > arr[i]) {
				while (stack.size() > 0 && stack.peek() >= arr[i]) {
					stack.pop();
				}

				if (stack.size() == 0) {
					arrayList.add(-1);
				} else {
					arrayList.add(stack.peek());
				}
			}

			stack.push(arr[i]);
		}

		Collections.reverse(arrayList);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arr[i] + ", " + arrayList.get(i));
		}
	}
}
