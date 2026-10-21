import java.util.*;

class Solution {
	public int[] solution(int n) {
		int[] answer = {};

		HashSet<Integer> set = new HashSet<>();

		while (n > 1) {
			for (int i = 2; i <= n; i++) {
				if (n % i == 0) {
					set.add(i);
					n = n / i;
					break;
				}
			}
		}

		answer = new int[set.size()];
		int i = 0;
		for (int num : set) {
			answer[i++] = num;
		}

		Arrays.sort(answer);
		return answer;
	}
}