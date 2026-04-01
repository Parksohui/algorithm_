import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _30337_ { // Linas ir mandarinai

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int d = Integer.parseInt(bf.readLine());
			queue.add(d);
		}

		int day = 1, temp = 0, result = 0;

		while (!queue.isEmpty()) {
			if (day <= queue.peek()) {
				temp += 1;
				result += 1;
				queue.poll();
			} else {
				queue.poll();
			}
			if (temp == k) {
				temp = 0;
				day += 1;
			}
		}
		System.out.println(result);
	}
}
