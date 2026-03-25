import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _9834_ { // Card

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String moves = st.nextToken();

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < m; i++) {
			deque.add(i);
		}

		for (int i = 0; i < moves.length() - 1; i++) {
			if (moves.charAt(i) == 'A') {
				deque.addLast(deque.pollFirst());
			} else {
				int temp = deque.pollFirst();
				deque.addLast(deque.pollFirst());
				deque.addFirst(temp);
			}
		}

		for (int i = 0; i <= k + 1; i++) {
			if (i >= k - 1 && i <= k + 1) {
				bw.write(deque.peekFirst() + " ");
			}
			deque.pollFirst();
		}
		bw.flush();
	}
}
