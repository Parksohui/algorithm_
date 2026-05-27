import java.util.*;

class Solution {
	public int[] solution(String[] maps) {

		int[][] arr = new int[maps.length][maps[0].length()];
		boolean visited[][] = new boolean[arr.length][arr[0].length];

		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (maps[i].charAt(j) == 'X') {
					visited[i][j] = true;
				} else {
					arr[i][j] = maps[i].charAt(j) - '0';
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					list.add(bfs(arr, visited, i, j));
				}
			}
		}
		Collections.sort(list);

		int answer[] = { -1 };
		if (list.size() > 0) {
			answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
		}
		return answer;
	}

	private static int bfs(int[][] arr, boolean visited[][], int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		int result = arr[x][y];

		while (!queue.isEmpty()) {
			int position[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x1 = position[0] + dx[i];
				int y1 = position[1] + dy[i];

				if (x1 >= 0 && x1 < visited.length && y1 >= 0 && y1 < visited[0].length && !visited[x1][y1]) {
					visited[x1][y1] = true;
					result += arr[x1][y1];
					queue.add(new int[] { x1, y1 });
				}
			}
		}
		return result;
	}
}