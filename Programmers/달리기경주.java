import java.util.*;

class Solution {
	public String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];

		HashMap<String, Integer> map = new HashMap<>();
		HashMap<Integer, String> rank = new HashMap<>();

		for (int i = 0; i < players.length; i++) {
			map.put(players[i], i + 1);
			rank.put(i + 1, players[i]);
		}

		for (int i = 0; i < callings.length; i++) {
			String name1 = callings[i];
			String name2 = rank.get(map.get(name1) - 1);
			int num = map.get(name1);

			map.put(name1, num - 1);
			map.put(name2, num);

			rank.put(num, name2);
			rank.put(num - 1, name1);
		}

		for (int i = 0; i < players.length; i++) {
			answer[i] = rank.get(i + 1);
		}

		return answer;
	}
}