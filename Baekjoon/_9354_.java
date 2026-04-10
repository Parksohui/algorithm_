import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _9354_ { // It Is Cold

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			int arr[] = new int[n];

			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				char dir = st.nextToken().charAt(0);

				if (dir == 'A') {
					arr[j] = -arr[j];
				}

			}

			long result = 0;
			if (arr[n - 1] > 0) {
				result = arr[n - 1];
			}

			for (int j = n - 2; j >= 0; j--) {
				result += arr[j];

				if (result < 0) {
					result = 0;
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
	}
}
