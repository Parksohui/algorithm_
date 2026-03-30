import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15287_ { // Easy Quest

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[1001];
		ArrayList<Integer> result = new ArrayList<>();
		boolean flag = false;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num >= 0) {
				arr[num] += 1;
			} else {
				if (arr[-num] > 0) {
					arr[-num] -= 1;
				} else if (arr[0] > 0) {
					arr[0] -= 1;
					result.add(-num);
				} else {
					flag = true;
					break;
				}
			}
		}

		if (flag) {
			bw.write("No");
		} else {
			bw.write("Yes\n");

			for (int x : result) {
				bw.write(x + " ");
			}

			while (arr[0] > 0) {
				arr[0] -= 1;
				bw.write("1 ");
			}
		}
		bw.flush();
	}
}
