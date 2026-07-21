import java.util.*;

class Solution {
	public int solution(int n, int[][] edge) {
		int answer = 0;

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < edge.length; i++) {
			list.get(edge[i][0]).add(edge[i][1]);
			list.get(edge[i][1]).add(edge[i][0]);
		}

		int depth[] = new int[n + 1];

		bfs(list, depth);

		int max = 0;
		for (int i = 1; i < n + 1; i++) {
			if (max < depth[i]) {
				max = depth[i];
				answer = 1;
			} else if (max == depth[i]) {
				answer += 1;
			}
		}

		return answer;
	}

	private void bfs(ArrayList<ArrayList<Integer>> list, int[] depth) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		boolean visited[] = new boolean[list.size()];
		visited[1] = true;

		while (!queue.isEmpty()) {
			int num = queue.poll();

			for (int temp : list.get(num)) {
				if (!visited[temp]) {
					visited[temp] = true;
					depth[temp] = depth[num] + 1;
					queue.add(temp);
				}
			}
		}
	}
}