package stack;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {

	class Pair {
		int element;
		int index;

		public Pair(int element, int index) {
			this.element = element;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		int price[] = { 10, 4, 5, 90, 120, 80 };
		Object stockSpan[] = calculateStockSpan(price);
		for (int i = 0; i < stockSpan.length; i++) {
			System.out.print(stockSpan[i] + " ");
		}
	}

	private static Object[] calculateStockSpan(int[] price) {
		ArrayList<Integer> stockSpan = new ArrayList<Integer>();
		Stack<Pair> stack = new Stack<StockSpanProblem.Pair>();

		for (int i = 0; i < price.length; i++) {
			if (stack.size() == 0) {
				stockSpan.add(-1);
			} else if (stack.size() > 0 && stack.peek().element > price[i]) {
				stockSpan.add(stack.peek().index);
			} else if (stack.size() > 0 && stack.peek().element <= price[i]) {
				while (stack.size() > 0 && stack.peek().element <= price[i]) {
					stack.pop();
				}

				if (stack.size() == 0) {
					stockSpan.add(-1);
				} else if (stack.size() > 0 && stack.peek().element > price[i]) {
					stockSpan.add(stack.peek().index);
				}
			}
			stack.push(new StockSpanProblem().new Pair(price[i], i));
		}
		Object stockSpan1[] = stockSpan.toArray();
		for (int i = 0; i < stockSpan.size(); i++) {
			stockSpan1[i] = i - (int) stockSpan1[i];
		}
		return stockSpan1;
	}
}
