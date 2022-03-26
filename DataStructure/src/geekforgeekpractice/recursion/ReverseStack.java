import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		int array[] = { 5, 4, 3, 2, 1 };
		Stack<Integer> stackItem = new Stack<>();
		for (int a : array) {
			stackItem.add(a);
		}
		System.out.println("Original Stack:- " + stackItem);
		reverse(stackItem);
		System.out.println("After Reverse element Stack:- " + stackItem);
	}

	private static void reverse(Stack<Integer> stackItem) {
		if (stackItem.size() == 1) {
			return;
		}

		int temp = stackItem.pop();
		reverse(stackItem);
		insertPopedItem(stackItem, temp);
		return;
	}

	private static void insertPopedItem(Stack<Integer> stackItem, int temp) {
		if (stackItem.size() == 0) {
			stackItem.push(temp);
			return;
		}

		int element = stackItem.pop();
		insertPopedItem(stackItem, temp);
		stackItem.push(element);
		return;
	}

}
