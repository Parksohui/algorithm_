import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26934_ { // The Bus Card

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(bf.readLine());

		int arr[] = new int[10001];
		int coins[] = { 100, 200, 500 };

		for (int i = 1; i < 10001; i++) {
			for (int j = 0; j < 3; j++) {
				if (i % 100 == 0 && i - coins[j] >= 0) {
					if (arr[i] == 0) {
						arr[i] = arr[i - coins[j]] + 1;
					} else {
						arr[i] = Math.min(arr[i], arr[i - coins[j]] + 1);
					}
				}
			}
		}

		if (arr[k] == 0) {
			for (int i = k; i < 10001; i++) {
				if (arr[i] > 0) {
					System.out.println(arr[i]);
					break;
				}
			}
		} else {
			System.out.println(arr[k]);
		}
	}
}
