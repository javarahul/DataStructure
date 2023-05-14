package geeksforgeeks.practice.array.string;

import java.util.Stack;

public class ReverseWords1 {

	public static void main(String[] args) {
		String str = " I   am Rahul Kumar Tripathi ";

		String result = getReverseWords(str);

		System.out.println(result);
	}

	public static String getReverseWords(String str) {
		Stack<String> stack = new Stack<>();
		String tempString = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			tempString += String.valueOf(ch);
			if (ch == ' ') {
				stack.push(tempString);
				tempString = "";
			}
		}
		stack.push(String.valueOf(' '));
		stack.push(tempString);
		tempString = "";
		while (!stack.isEmpty()) {
			tempString += stack.pop();
		}
		System.out.println(stack);
		
		return tempString;
	}

}
