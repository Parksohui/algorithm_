import java.util.*;

class Solution {
	public int solution(int[] rank, boolean[] attendance) {
		int answer = 0;

		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < rank.length; i++) {
			if (attendance[i]) {
				list.add(new int[] { i, rank[i] });
			}
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		answer += 10000 * list.get(0)[0] + 100 * list.get(1)[0] + list.get(2)[0];

		return answer;
	}
}