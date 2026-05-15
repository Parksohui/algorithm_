import java.util.*;

class Solution {
	public int solution(int k, int[] tangerine) {
		int answer = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < tangerine.length; i++) {
			if (!map.containsKey(tangerine[i])) {
				map.put(tangerine[i], 1);
			} else {
				map.replace(tangerine[i], map.get(tangerine[i]) + 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2) - map.get(o1);
			}
		});

		for (int key : list) {
			k -= map.get(key);
			answer += 1;
			if (k <= 0) {
				break;
			}
		}
		return answer;
	}
}