class Solution {
	public int solution(String my_string) {
		int answer = 0;

		String str = "";
		for (int i = 0; i < my_string.length(); i++) {
			if (Character.isDigit(my_string.charAt(i))) {
				str += my_string.charAt(i);
			} else {
				if (str.length() > 0) {
					answer += Integer.parseInt(str);
					str = "";
				}
			}
		}

		if (str.length() > 0) {
			answer += Integer.parseInt(str);
		}

		return answer;
	}
}