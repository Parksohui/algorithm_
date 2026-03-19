import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _18295_ { // Ants

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String temp = bf.readLine();

			if (temp.length() >= 8) {
				continue;
			}

			int num = Integer.parseInt(temp);

			if (num >= 0) {
				list.add(num);
			}
		}

		Collections.sort(list);

		int result = 0;
		for (int x : list) {
			if (x != result) {
				break;
			}
			result += 1;
		}

		System.out.println(result);
	}
}
