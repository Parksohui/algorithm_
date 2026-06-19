class Solution {
	public int solution(int n) {
		int answer = 0;

		String str = Integer.toBinaryString(n);
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) - '0' == 1) {
				cnt += 1;
			}
		}

		while (answer == 0) {
			n += 1;

			String temp = Integer.toBinaryString(n);
			int cnt2 = 0;
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) - '0' == 1) {
					cnt2 += 1;
				}
			}

			if (cnt == cnt2) {
				answer = n;
			}
		}

		return answer;
	}
}