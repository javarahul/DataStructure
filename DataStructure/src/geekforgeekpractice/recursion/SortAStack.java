import java.util.LinkedList;
import java.util.Stack;

public class SortAStack {

	public static void main(String[] args) {
		int array[] = { 1, 5, 0, 2 };
		Stack<Integer> stackItem = new Stack<>();
		for (int a : array) {
			stackItem.add(a);
		}
		sort(stackItem);
		System.out.println(stackItem);
	}

	private static void sort(Stack<Integer> stack) {
		if (stack.size() == 1) {
			return;
		}

		int topItem = stack.peek();
		stack.pop();
		sort(stack);
		insert(stack, topItem);
	}

	private static void insert(Stack<Integer> stack, int topItem) {
		if (stack.size() == 0 || stack.peek() <= topItem) {
			stack.push(topItem);
			return;
		}

		int val = stack.peek();
		stack.pop();
		insert(stack, topItem);
		stack.push(val);
	}
}
