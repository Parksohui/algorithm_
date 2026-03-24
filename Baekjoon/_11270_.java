import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11270_ { // Disastrous Downtime

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();

		int num[] = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(num);

		list.add(0);

		for (int i = 0; i < n; i++) {
			boolean flag = false;

			if (list.get(list.size() - 1) < k) {
				list.set(list.size() - 1, list.get(list.size() - 1) + 1);
				queue.add(new int[] { num[i], list.size() - 1 });
				flag = true;
			} else if (queue.peek()[0] + 1000 <= num[i]) {
				int temp[] = queue.poll();
				queue.add(new int[] { num[i], temp[1] });
				flag = true;
			}

			if (!flag) {
				list.add(1);
				queue.add(new int[] { num[i], list.size() - 1 });
			}
		}
		System.out.println(list.size());
	}

}
