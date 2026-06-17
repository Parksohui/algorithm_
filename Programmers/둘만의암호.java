class Solution {
	public String solution(String s, String skip, int index) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			int idx = 0;
			while (idx < index) {
				x = (char) (x + 1);
				if (x == 'z' + 1) {
					x = 'a';
				}
				boolean flag = false;

				for (int j = 0; j < skip.length(); j++) {
					if (x == skip.charAt(j)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					idx++;
				}
			}
			answer += x;
		}
		return answer;
	}
}