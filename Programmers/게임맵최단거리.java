import java.util.*;

class Solution {
	public int solution(int[][] maps) {
		int answer = -1;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1 });

		boolean visited[][] = new boolean[maps.length][maps[0].length];
		visited[0][0] = true;

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		boolean flag = false;

		while (!queue.isEmpty()) {
			int info[] = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = info[0] + dx[i];
				int y = info[1] + dy[i];

				if (x >= 0 && x < maps.length && y >= 0 && y < maps[0].length && maps[x][y] == 1 && !visited[x][y]) {
					if (x == maps.length - 1 && y == maps[0].length - 1) {
						answer = info[2] + 1;
						flag = true;
						break;
					}
					visited[x][y] = true;
					queue.add(new int[] { x, y, info[2] + 1 });
				}
			}
			if (flag) {
				break;
			}
		}
		return answer;
	}
}