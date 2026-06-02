import java.util.*;

class Solution {
	public class Plan {
		private String name;
		private int start;
		private int playtime;

		public Plan(String name, int start, int playtime) {
			this.name = name;
			this.start = start;
			this.playtime = playtime;
		}
	}

	public String[] solution(String[][] plans) {
		String[] answer = new String[plans.length];

		PriorityQueue<Plan> queue = new PriorityQueue<>(new Comparator<Plan>() {
			@Override
			public int compare(Plan o1, Plan o2) {
				return o1.start - o2.start;
			}
		});

		for (int i = 0; i < plans.length; i++) {
			int start = Integer.parseInt(plans[i][1].split(":")[0]) * 60 + Integer.parseInt(plans[i][1].split(":")[1]);
			queue.add(new Plan(plans[i][0], start, Integer.parseInt(plans[i][2])));
		}

		Stack<Plan> stack = new Stack<>();
		int idx = 0, now = 0;

		while (!queue.isEmpty()) {
			if (stack.isEmpty()) {
				stack.add(queue.poll());
				now = stack.peek().start;
			} else if (now + stack.peek().playtime > queue.peek().start) {
				stack.peek().playtime -= (queue.peek().start - now);
				stack.add(queue.poll());
				now = stack.peek().start;
			} else {
				now += stack.peek().playtime;
				answer[idx++] = stack.pop().name;
			}
		}

		while (!stack.isEmpty()) {
			answer[idx++] = stack.pop().name;
		}

		return answer;
	}
}