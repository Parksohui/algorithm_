import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14767_ { // Flow Shop

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dp[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0) {
					if (j == 0) {
						dp[i][j] = arr[i][j];
						continue;
					}
					dp[i][j] = dp[i][j - 1] + arr[i][j];
				} else {
					if (j == 0) {
						dp[i][j] = dp[i - 1][j] + arr[i][j];
					} else {
						if (dp[i][j - 1] < dp[i - 1][j]) {
							dp[i][j] = dp[i - 1][j] + arr[i][j];
						} else {
							dp[i][j] = dp[i][j - 1] + arr[i][j];
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			bw.write(dp[i][m - 1] + " ");
		}
		bw.flush();
	}
}
