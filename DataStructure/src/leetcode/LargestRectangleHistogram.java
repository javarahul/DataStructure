package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleHistogram {

	class Pair {
		int element;
		int index;

		public Pair(int element, int index) {
			this.element = element;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + getMaxArea(hist));
	}

	private static int getMaxArea(int[] hist) {
		int maxArea = 0;
		Object left[] = getNearestSmallerLeft(hist);
		Object right[] = getNearestSmallerRight(hist);
		int width[] = new int[hist.length];
		for (int i = 0; i < hist.length; i++) {
			width[i] = (int) right[i] - (int) left[i] - 1;
		}
		for (int i = 0; i < hist.length; i++) {
			maxArea = Math.max(maxArea, width[i] * hist[i]);
		}
		return maxArea;
	}

	private static Object[] getNearestSmallerLeft(int[] hist) {
		ArrayList<Integer> left = new ArrayList<Integer>();
		int psudoIndex = -1;
		Stack<Pair> stack = new Stack<LargestRectangleHistogram.Pair>();

		for (int i = 0; i < hist.length; i++) {
			if (stack.size() == 0) {
				left.add(psudoIndex);
			}

			else if (stack.size() > 0 && stack.peek().element < hist[i]) {
				left.add(stack.peek().index);
			} else if (stack.size() > 0 && stack.peek().element >= hist[i]) {
				while (stack.size() > 0 && stack.peek().element >= hist[i]) {
					stack.pop();
				}
				if (stack.size() == 0) {
					left.add(psudoIndex);
				} else {
					left.add(stack.peek().index);
				}
			}
			stack.push(new LargestRectangleHistogram().new Pair(hist[i], i));
		}
		return left.toArray();
	}

	private static Object[] getNearestSmallerRight(int[] hist) {
		ArrayList<Integer> right = new ArrayList<Integer>();
		int psudoIndex = hist.length;
		Stack<Pair> stack = new Stack<LargestRectangleHistogram.Pair>();

		for (int i = hist.length - 1; i >= 0; i--) {
			if (stack.size() == 0) {
				right.add(psudoIndex);
			} else if (stack.size() > 0 && stack.peek().element < hist[i]) {
				right.add(stack.peek().index);
			} else if (stack.size() > 0 && stack.peek().element >= hist[i]) {
				while (stack.size() > 0 && stack.peek().element >= hist[i]) {
					stack.pop();
				}
				if (stack.size() == 0) {
					right.add(psudoIndex);
				} else {
					right.add(stack.peek().index);
				}
			}
			stack.push(new LargestRectangleHistogram().new Pair(hist[i], i));
		}
		Collections.reverse(right);
		return right.toArray();
	}
}
