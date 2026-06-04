class Solution {
	public int solution(int n, int m, int[] section) {
		int answer = 0;

		int end = 0;
		for (int i = 0; i < section.length; i++) {
			if (end > section[i]) {
				continue;
			}
			end = section[i] + m;
			answer += 1;

			if (end > n) {
				break;
			}
		}
		return answer;
	}
}