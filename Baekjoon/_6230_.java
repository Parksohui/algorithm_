import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _6230_ { // Buy One Get One Free

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int a[] = new int[n];
		int b[] = new int[m];

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(bf.readLine());
		}

		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(a);
		Arrays.sort(b);

		int idx = 0, result = 0;
		for (int i = 0; i < n; i++) {
			result += 1;
			while (idx < m) {
				if (b[idx] < a[i]) {
					idx += 1;
					result += 1;
				}
				break;
			}
		}
		System.out.println(result);
	}
}
