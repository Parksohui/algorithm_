import java.util.*;

class Solution {
	public int solution(int n, int[][] computers) {
		int answer = 0;

		boolean visited[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				answer += 1;
				visited[i] = true;
				bfs(i, computers, visited);
			}
		}

		return answer;
	}

	private void bfs(int idx, int[][] computers, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(idx);

		while (!queue.isEmpty()) {
			int num = queue.poll();

			for (int i = 0; i < computers.length; i++) {
				if (num == i) {
					continue;
				}
				if (computers[num][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}