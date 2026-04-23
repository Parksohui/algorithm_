import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _6107_ { // Plumbing the Pond

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int arr[][] = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				for (int k = 0; k < 8; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (x >= 0 && x < r && y >= 0 && y < c) {
						if (arr[i][j] == arr[x][y]) {
							set.add(arr[i][j]);
						}
					}
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list.get(0));
	}
}
