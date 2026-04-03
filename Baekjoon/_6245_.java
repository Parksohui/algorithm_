import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6245_ { // Cow Solitaire

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[][] = new int[n][n];
		int dp[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				String str = st.nextToken();

				if (Character.isDigit(str.charAt(0))) {
					arr[i][j] = str.charAt(0) - '0';
				} else {
					if (str.charAt(0) == 'A') {
						arr[i][j] = 1;
					} else if (str.charAt(0) == 'T') {
						arr[i][j] = 10;
					} else if (str.charAt(0) == 'J') {
						arr[i][j] = 11;
					} else if (str.charAt(0) == 'Q') {
						arr[i][j] = 12;
					} else if (str.charAt(0) == 'K') {
						arr[i][j] = 13;
					}
				}
			}
		}

		dp[n - 1][0] = arr[n - 1][0];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (j - 1 >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + arr[i][j]);
				}
				if (i + 1 < n) {
					dp[i][j] = Math.max(dp[i][j], dp[i + 1][j] + arr[i][j]);
				}
			}
		}

		System.out.println(dp[0][n - 1]);
	}
}
