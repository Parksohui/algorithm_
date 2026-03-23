import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _9780_ { // Range Sum Query

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());
		long arr[];

		for (int i = 0; i < t; i++) {
			bf.readLine();

			st = new StringTokenizer(bf.readLine());

			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			arr = new long[n];
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				if (j > 0) {
					arr[j] += arr[j - 1];
				}
			}

			for (int j = 0; j < q; j++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (a > 0) {
					bw.write(arr[b] - arr[a - 1] + "\n");
				} else {
					bw.write(arr[b] + "\n");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
