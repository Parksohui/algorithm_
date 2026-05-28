class Solution {
	public int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];

		char arr[][] = new char[park.length][park[0].length()];
		int x = -1, y = -1;
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[0].length(); j++) {
				arr[i][j] = park[i].charAt(j);

				if (arr[i][j] == 'S') {
					x = i;
					y = j;
				}
			}
		}

		for (int i = 0; i < routes.length; i++) {
			char dir = routes[i].split(" ")[0].charAt(0);
			int num = Integer.parseInt(routes[i].split(" ")[1]);
			boolean flag = false;

			if (dir == 'N') {
				for (int j = 1; j <= num; j++) {
					if (x - j < 0 || arr[x - j][y] == 'X') {
						flag = true;
						break;
					}
				}
				if (!flag) {
					x -= num;
				}

			} else if (dir == 'S') {
				for (int j = 1; j <= num; j++) {
					if (x + j >= arr.length || arr[x + j][y] == 'X') {
						flag = true;
						break;
					}
				}
				if (!flag) {
					x += num;
				}

			} else if (dir == 'W') {
				for (int j = 1; j <= num; j++) {
					if (y - j < 0 || arr[x][y - j] == 'X') {
						flag = true;
						break;
					}
				}
				if (!flag) {
					y -= num;
				}

			} else {
				for (int j = 1; j <= num; j++) {
					if (y + j >= arr[0].length || arr[x][y + j] == 'X') {
						flag = true;
						break;
					}
				}
				if (!flag) {
					y += num;
				}
			}
		}

		answer[0] = x;
		answer[1] = y;

		return answer;
	}
}