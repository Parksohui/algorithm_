import java.util.*;

class Solution {
	class Info {
		double avg;
		int idx;

		public Info(double avg, int idx) {
			this.avg = avg;
			this.idx = idx;
		}
	}

	public int[] solution(int[][] score) {
		int[] answer = new int[score.length];

		ArrayList<Info> list = new ArrayList<>();

		for (int i = 0; i < score.length; i++) {
			double avg = (double) (score[i][0] + score[i][1]) / 2;
			list.add(new Info(avg, i));
		}

		Collections.sort(list, new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				return Double.compare(o2.avg, o1.avg);
			}
		});

		int rank = 1;
		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i - 1).avg == list.get(i).avg) {
				answer[list.get(i).idx] = answer[list.get(i - 1).idx];
			} else {
				answer[list.get(i).idx] = rank;
			}
			rank += 1;
		}

		return answer;
	}
}