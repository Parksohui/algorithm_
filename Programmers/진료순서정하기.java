import java.util.*;

class Solution {
	public int[] solution(int[] emergency) {
		int[] answer = new int[emergency.length];

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < emergency.length; i++) {
			list.add(new int[] { i, emergency[i] });
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});

		for (int i = 0; i < list.size(); i++) {
			answer[list.get(i)[0]] = i + 1;
		}
		return answer;
	}
}