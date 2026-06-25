class Solution {
	public String solution(String X, String Y) {
		String answer = "";
		StringBuilder sb = new StringBuilder();

		int arr1[] = new int[10];
		int arr2[] = new int[10];

		for (int i = 0; i < X.length(); i++) {
			int num = X.charAt(i) - '0';
			arr1[num] += 1;
		}

		for (int i = 0; i < Y.length(); i++) {
			int num = Y.charAt(i) - '0';
			arr2[num] += 1;
		}

		for (int i = 9; i >= 0; i--) {
			int cnt = Math.min(arr1[i], arr2[i]);

			if (sb.length() == 0 && i == 0 && cnt > 0) {
				sb.append("0");
			} else {
				for (int j = 0; j < cnt; j++) {
					sb.append(i);
				}
			}
		}

		answer = sb.toString();

		if (answer.length() == 0) {
			answer = "-1";
		}

		return answer;
	}
}