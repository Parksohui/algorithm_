import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _5059_ { // Shopaholic

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			Integer arr[] = new Integer[n];

			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, Collections.reverseOrder());

			int sum = 0;
			for (int j = 0; j < n; j += 3) {
				if (j + 2 >= n) {
					break;
				}
				sum += arr[j + 2];
			}

			bw.write(sum + "\n");
		}
		bw.flush();
	}
}
