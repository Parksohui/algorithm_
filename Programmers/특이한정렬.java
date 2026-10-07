import java.util.*;

class Solution {
	public int[] solution(int[] numlist, int n) {
		int[] answer = new int[numlist.length];

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < numlist.length; i++) {
			list.add(numlist[i]);
		}

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(n - o1) == Math.abs(n - o2)) {
					return o2 - o1;
				}
				return Math.abs(n - o1) - Math.abs(n - o2);
			}
		});

		for (int i = 0; i < numlist.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}