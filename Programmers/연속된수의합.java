class Solution {
	public int[] solution(int num, int total) {
		int[] answer = new int[num];

		int start = -100, end = -100 + num;
		int sum = 0;

		for (int i = start; i < end; i++) {
			sum += i;
		}

		while (sum != total) {
			sum -= start++;
			sum += end++;
		}

		for (int i = start; i < end; i++) {
			answer[i - start] = i;
		}

		return answer;
	}
}