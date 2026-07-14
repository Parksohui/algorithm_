class Solution {
	static int answer;

	public int solution(int[] numbers, int target) {
		answer = 0;

		dfs(numbers, 0, target, 0);

		return answer;
	}

	private void dfs(int[] numbers, int sum, int target, int idx) {
		if (idx == numbers.length) {
			if (target == sum) {
				answer += 1;
			}
			return;
		}

		dfs(numbers, sum + numbers[idx], target, idx + 1);
		dfs(numbers, sum - numbers[idx], target, idx + 1);

	}
}