import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _15407_ { // How to Eat at a Buffet

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		int area = Integer.parseInt(bf.readLine());

		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int v = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			list.add(new int[] { v, a });
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o2[0] - o1[0];
			}
		});

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (area == 0) {
				break;
			}
			if (area >= list.get(i)[1]) {
				area -= list.get(i)[1];
				result += list.get(i)[0] * list.get(i)[1];
			} else {
				result += list.get(i)[0] * area;
				area = 0;
			}
		}
		System.out.println(result);
	}

}
