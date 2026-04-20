import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _13382_ { // Lab

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			double arr[] = new double[n];
			double dp[] = new double[n];
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Double.parseDouble(st.nextToken());
				dp[j] = arr[j];
			}

			double result = 0.0;

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < j - 2; k++) {
					dp[j] = Math.max(dp[j], dp[k] + arr[j]);
				}
				result = Math.max(result, dp[j]);
			}

			bw.write(String.format("%.1f", result) + "\n");
		}
		bw.flush();
	}
}
