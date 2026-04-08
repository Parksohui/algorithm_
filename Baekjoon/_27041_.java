import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _27041_ { // Leapcow

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int e = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int arr[] = new int[e + 1];

		for (int i = 1; i < e + 1; i++) {
			arr[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < b; i++) {
			int num = Integer.parseInt(bf.readLine());

			arr[num] = -1;
		}

		for (int i = 1; i < e + 1; i++) {
			for (int j = 1; j <= l; j++) {
				if (i - j >= 0 && arr[i - j] >= 0) {
					arr[i] = Math.min(arr[i - j] + 1, arr[i]);
				}
			}
		}

		System.out.println(arr[e]);
	}
}
