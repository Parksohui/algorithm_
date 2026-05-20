class Solution {
	public int solution(String[] babbling) {
		int answer = 0;

		for (int i = 0; i < babbling.length; i++) {
			String str = babbling[i];

			int idx = 0;
			char x = ' ';
			while (idx < str.length()) {
				if (str.charAt(idx) == 'a' && x != 'a') {
					if (idx + 2 < str.length() && str.substring(idx, idx + 3).equals("aya")) {
						idx += 3;
						x = 'a';
					} else {
						break;
					}
				} else if (str.charAt(idx) == 'y' && x != 'y') {
					if (idx + 1 < str.length() && str.substring(idx, idx + 2).equals("ye")) {
						idx += 2;
						x = 'y';
					} else {
						break;
					}

				} else if (str.charAt(idx) == 'w' && x != 'w') {
					if (idx + 2 < str.length() && str.substring(idx, idx + 3).equals("woo")) {
						idx += 3;
						x = 'w';
					} else {
						break;
					}

				} else if (str.charAt(idx) == 'm' && x != 'm') {
					if (idx + 1 < str.length() && str.substring(idx, idx + 2).equals("ma")) {
						idx += 2;
						x = 'm';
					} else {
						break;
					}
				} else {
					break;
				}
			}
			if (idx == str.length()) {
				answer += 1;
			}
		}
		return answer;
	}
}