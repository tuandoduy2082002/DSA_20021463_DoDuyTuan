package Week5;

import java.util.Stack;

public class BalancedBrackets {
	public static String isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					if (c == ']' && stack.pop() != '[') {
						return "NO";
					} else if (c == ')' && stack.pop() != '(') {
						return "NO";
					} else if (c == '}' && stack.pop() != '{') {
						return "NO";
					}
				} else {
					return "NO";
				}
			}
		}
		return stack.isEmpty() ? "YES" : "NO";
	}
}
