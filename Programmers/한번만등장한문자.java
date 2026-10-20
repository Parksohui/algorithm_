import java.util.*;

class Solution {
	public String solution(String s) {
		String answer = "";

		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		ArrayList<Character> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				if (map.get(o1) == map.get(o2)) {
					return o1 - o2;
				}
				return map.get(o1) - map.get(o2);
			}
		});

		for (Character c : list) {
			if (map.get(c) == 1) {
				answer += c;
			}
		}
		return answer;
	}
}