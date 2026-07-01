import java.util.*;

class Solution {
	public int solution(String[] maps) {
		int answer = -1;

		char arr[][] = new char[maps.length][maps[0].length()];
		int s[] = new int[2];
		int l[] = new int[2];
		int e[] = new int[2];

		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length(); j++) {
				arr[i][j] = maps[i].charAt(j);
				if (arr[i][j] == 'S') {
					s[0] = i;
					s[1] = j;
				} else if (arr[i][j] == 'E') {
					e[0] = i;
					e[1] = j;
				} else if (arr[i][j] == 'L') {
					l[0] = i;
					l[1] = j;
				}
			}
		}

		int move1 = bfs(l, s, arr);
		int move2 = bfs(l, e, arr);

		if (move1 != -1 && move2 != -1) {
			answer = move1 + move2;
		}

		return answer;
	}

	private int bfs(int[] start, int[] end, char[][] arr) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { start[0], start[1], 0 });

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		boolean[][] visited = new boolean[arr.length][arr[0].length];
		visited[start[0]][start[1]] = true;

		while (!queue.isEmpty()) {
			int info[] = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = info[0] + dx[i];
				int y = info[1] + dy[i];

				if (x == end[0] && y == end[1]) {
					return info[2] + 1;
				}

				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] != 'X' && !visited[x][y]) {
					queue.add(new int[] { x, y, info[2] + 1 });
					visited[x][y] = true;
				}
			}

		}
		return -1;

	}
}