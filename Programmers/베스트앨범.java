import java.util.*;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer;

		HashMap<String, Integer> total = new HashMap<>();
		HashMap<String, ArrayList<int[]>> songs = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			if (total.containsKey(genres[i])) {
				total.replace(genres[i], total.get(genres[i]) + plays[i]);
			} else {
				total.put(genres[i], plays[i]);
			}

			if (!songs.containsKey(genres[i])) {
				songs.put(genres[i], new ArrayList<>());
			}
			songs.get(genres[i]).add(new int[] { i, plays[i] });
		}

		ArrayList<String> list = new ArrayList<>(total.keySet());
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return total.get(o2) - total.get(o1);
			}
		});

		ArrayList<Integer> result = new ArrayList<>();
		for (String genre : list) {
			ArrayList<int[]> temp = new ArrayList<>(songs.get(genre));

			Collections.sort(temp, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					return o2[1] - o1[1];
				}

			});

			result.add(temp.get(0)[0]);

			if (temp.size() > 1) {
				result.add(temp.get(1)[0]);
			}
		}

		answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}
}