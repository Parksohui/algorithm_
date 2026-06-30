import java.util.*;

class Solution {
	public int solution(int x, int y, int n) {
		int answer = -1;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, 0 });

		boolean visited[] = new boolean[y + 1];
		visited[x] = true;

		if (x == y) {
			answer = 0;
		} else {
			while (!queue.isEmpty()) {
				int info[] = queue.poll();

				if (info[0] + n == y || info[0] * 2 == y || info[0] * 3 == y) {
					answer = info[1] + 1;
					break;
				}

				if (info[0] + n < y && !visited[info[0] + n]) {
					queue.add(new int[] { info[0] + n, info[1] + 1 });
					visited[info[0] + n] = true;
				}
				if (info[0] * 2 < y && !visited[info[0] * 2]) {
					queue.add(new int[] { info[0] * 2, info[1] + 1 });
					visited[info[0] * 2] = true;
				}
				if (info[0] * 3 < y && !visited[info[0] * 3]) {
					queue.add(new int[] { info[0] * 3, info[1] + 1 });
					visited[info[0] * 3] = true;
				}
			}
		}
		return answer;
	}
}