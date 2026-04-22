import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6754_ { // Bridge transport

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int w = Integer.parseInt(bf.readLine());
		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < Math.min(4, n); i++) {
			sum += arr[i];
			if (sum > w) {
				System.out.println(i);
				flag = true;
				break;
			}
		}

		if (!flag) {
			if (n < 5) {
				System.out.println(n);
			} else {
				flag = false;
				for (int i = 4; i < n; i++) {
					sum -= arr[i - 4];
					sum += arr[i];

					if (sum > w) {
						System.out.println(i);
						flag = true;
						break;
					}
				}
				if (!flag) {
					System.out.println(n);
				}
			}
		}
	}
}
