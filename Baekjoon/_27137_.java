import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _27137_ { // Square Designs

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		bw.write("+");
		for (int i = 0; i < m * 2 + 1; i++) {
			bw.write("-");
		}
		bw.write("+");

		bw.write("          ");

		bw.write("+");
		for (int i = 0; i < n * 2 + 1; i++) {
			bw.write("-");
		}
		bw.write("+\n");

		int x = m, y = n;
		boolean flag = false, left = false, right = false;
		while (x > -1 || y > -1) {
			if (flag) {
				left = true;
			}
			if (x == 0 && !flag) {
				if (right) {
					bw.write("\n");
				}
				bw.write("+");
				for (int i = 0; i < m * 2 + 1; i++) {
					bw.write("-");
				}
				bw.write("+");

				flag = true;
				x = -1;
			}
			if (x > 0) {
				if (right) {
					bw.write("\n");
				}
				bw.write("I-");
				for (int j = 0; j < m; j++) {
					bw.write("X-");
				}
				bw.write("I");
				x -= 1;
			}
			if (y > 0) {
				if (left) {
					for (int i = 0; i < m * 2 + 3; i++) {
						bw.write(" ");
					}
				}
				bw.write("          ");
				bw.write("I-");
				for (int j = 0; j < n; j++) {
					bw.write("X-");
				}
				bw.write("I\n");
				y -= 1;
			} else if (y == 0 && !right) {
				if (left) {
					for (int i = 0; i < m * 2 + 3; i++) {
						bw.write(" ");
					}
				}
				bw.write("          ");
				bw.write("+");
				for (int i = 0; i < n * 2 + 1; i++) {
					bw.write("-");
				}
				bw.write("+");
				right = true;
				y = -1;
			}
		}
		bw.flush();
	}
}
