import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _32813_ { // Oooh I See

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		char arr[][] = new char[r][c];

		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (Character.isAlphabetic(arr[i][j])) {
					continue;
				}
				int cnt = 0;
				for (int k = 0; k < 8; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (x >= 0 && x < r && y >= 0 && y < c) {
						if (arr[x][y] == 'O') {
							cnt += 1;
						}
					}
				}
				if (cnt == 8) {
					list.add(new int[] { i + 1, j + 1 });
				}
			}
		}

		if (list.size() == 0) {
			bw.write("Oh no!");
		} else if (list.size() == 1) {
			bw.write(list.get(0)[0] + " " + list.get(0)[1]);
		} else {
			bw.write("Oh no! " + list.size() + " locations");
		}
		bw.flush();
	}
}
