import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9844_ { // Gecko

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int arr[][] = new int[h][w];
		int dp[][] = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0) {
					dp[i][j] = arr[i][j];
				}
			}
		}

		for (int i = 1; i < h; i++) {
			for (int j = 0; j < w; j++) {
				dp[i][j] = Math.max(dp[i][j], arr[i][j] + dp[i - 1][j]);

				if (j - 1 >= 0) {
					dp[i][j] = Math.max(dp[i][j], arr[i][j] + dp[i - 1][j - 1]);
				}
				if (j + 1 < w) {
					dp[i][j] = Math.max(dp[i][j], arr[i][j] + dp[i - 1][j + 1]);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < w; i++) {
			result = Math.max(result, dp[h - 1][i]);
		}

		System.out.println(result);
	}
}
