import java.util.Stack;

public class DeleteMidElement {

	public static void main(String[] args) {
		int array[] = { 5,4, 3, 2,1 };
		Stack<Integer> stackItem = new Stack<>();
		for (int a : array) {
			stackItem.add(a);
		}
		System.out.println("Original Stack:- " + stackItem);
		int k = (stackItem.size() / 2) + 1;
		delMidElement(stackItem, k);
		System.out.println("After Mid element deletion Stack:- " + stackItem);

	}

	private static void delMidElement(Stack<Integer> stackItem, int k) {
		if (stackItem.size() == 0) {
			return;
		}

		solution(stackItem, k);
	}

	private static void solution(Stack<Integer> stackItem, int k) {
		if (k == 1) {
			stackItem.pop();
			return;
		}

		int temp = stackItem.pop();
		solution(stackItem, k - 1);
		stackItem.push(temp);
		return;
	}

}
