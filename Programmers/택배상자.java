import java.util.*;

class Solution {
	public int solution(int[] order) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		int idx = 1;
		for (int i = 0; i < order.length; i++) {
			if (order[i] == idx) {
				idx += 1;
				answer += 1;
			} else if (!stack.isEmpty() && stack.peek() == order[i]) {
				stack.pop();
				answer += 1;
			} else {
				while (idx <= order.length && idx != order[i]) {
					stack.add(idx++);
				}
				if (idx == order[i]) {
					idx += 1;
					answer += 1;
				} else {
					break;
				}
			}
		}
		return answer;
	}
}