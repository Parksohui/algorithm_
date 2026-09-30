class Solution {
	public int solution(String s) {
		int answer = 0;

		String arr[] = s.split(" ");

		int before = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("Z")) {
				answer -= before;
			} else {
				before = Integer.parseInt(arr[i]);
				answer += before;
			}
		}
		return answer;
	}
}