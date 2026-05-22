import java.util.*;

class Solution {
	public int solution(String[][] book_time) {
		int answer = 0;

		Arrays.sort(book_time, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {

				int h1 = Integer.parseInt(o1[0].split(":")[0]);
				int m1 = Integer.parseInt(o1[0].split(":")[1]);

				int h2 = Integer.parseInt(o2[0].split(":")[0]);
				int m2 = Integer.parseInt(o2[0].split(":")[1]);

				if (h1 == h2) {
					return m1 - m2;
				}
				return h1 - h2;
			}
		});

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}

		});

		for (int i = 0; i < book_time.length; i++) {
			int h1 = Integer.parseInt(book_time[i][0].split(":")[0]);
			int m1 = Integer.parseInt(book_time[i][0].split(":")[1]);

			int h2 = Integer.parseInt(book_time[i][1].split(":")[0]);
			int m2 = Integer.parseInt(book_time[i][1].split(":")[1]);

			if (!queue.isEmpty()) {
				if (queue.peek()[0] == h1) {
					if (queue.peek()[1] <= m1) {
						queue.poll();
					}
				} else if (queue.peek()[0] < h1) {
					queue.poll();
				}
			}
			m2 += 10;
			if (m2 >= 60) {
				m2 -= 60;
				h2 += 1;
			}
			queue.add(new int[] { h2, m2 });
			answer = Math.max(answer, queue.size());
		}

		return answer;
	}
}