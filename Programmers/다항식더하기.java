class Solution {
	public String solution(String polynomial) {
		String answer = "";

		String[] arr = polynomial.split(" ");

		int x = 0, y = 0;
		for (int i = 0; i < arr.length; i += 2) {
			if (arr[i].charAt(arr[i].length() - 1) == 'x') {
				if (arr[i].length() == 1) {
					x += 1;
				} else {
					x += Integer.parseInt(arr[i].substring(0, arr[i].length() - 1));
				}
			} else {
				y += Integer.parseInt(arr[i]);
			}
		}

		if (x > 0) {
			if (x > 1) {
				answer += Integer.toString(x);
			}
			answer += "x";
		}
		if (y > 0) {
			if (answer.length() > 0) {
				answer += " + ";
			}
			answer += Integer.toString(y);
		}

		return answer;
	}
}