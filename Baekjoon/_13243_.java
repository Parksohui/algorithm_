import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _13243_ { // Non-decreasing subsegment

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0, cnt = 1;
		long sum = 0, temp = arr[0];

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] <= arr[i]) {
				cnt += 1;
				temp += arr[i];
			} else {
				if (result < cnt) {
					result = cnt;
					sum = temp;
				}
				cnt = 1;
				temp = arr[i];
			}
		}
		if (result < cnt) {
			result = cnt;
			sum = temp;
		}
		
		bw.write(result+" "+sum);
		bw.flush();
	}
}
