package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterToLeftElementByStack {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 4 };
		getNextGreaterToLeft(arr);
	}

	public static void getNextGreaterToLeft(int[] arr) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (stack.size() == 0) {
				arrayList.add(-1);
			} else if (stack.size() > 0 && stack.peek() > arr[i]) {
				arrayList.add(stack.peek());
			} else if (stack.size() > 0 && stack.peek() < arr[i]) {
				while (stack.size() > 0 && stack.peek() <= arr[i]) {
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

//		Collections.reverse(arrayList);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arr[i] + ", " + arrayList.get(i));
		}
	}
}
