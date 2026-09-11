import java.util.*;

class Solution {
	public int solution(int[] array) {
		int answer = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.replace(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2) - map.get(o1);
			}
		});

		if (list.size() > 1 && map.get(list.get(0)) == map.get(list.get(1))) {
			answer = -1;
		} else {
			answer = list.get(0);
		}

		return answer;
	}
}