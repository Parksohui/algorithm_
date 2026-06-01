class Solution {
	int solution(int[][] land) {
		int answer = 0;

		int[][] sum = new int[land.length][4];

		for (int i = 0; i < 4; i++) {
			sum[0][i] = land[0][i];
		}

		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < 4; j++) {

				for (int k = 0; k < 4; k++) {
					if (j == k) {
						continue;
					}
					sum[i][j] = Math.max(sum[i][j], land[i][j] + sum[i - 1][k]);
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			answer = Math.max(answer, sum[land.length - 1][i]);
		}

		return answer;
	}
}