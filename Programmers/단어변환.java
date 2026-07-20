import java.util.*;

class Solution {
	static class Word {
		String word;
		int cnt;

		public Word(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}
	}

	public int solution(String begin, String target, String[] words) {
		int answer = 0;

		Queue<Word> queue = new LinkedList<>();
		queue.add(new Word(begin, 0));

		boolean visited[] = new boolean[words.length];

		while (!queue.isEmpty()) {
			Word word = queue.poll();

			for (int i = 0; i < words.length; i++) {
				if (!visited[i]) {
					int temp = 0;
					for (int j = 0; j < words[i].length(); j++) {
						if (word.word.charAt(j) != words[i].charAt(j)) {
							temp += 1;
						}
					}
					if (temp == 1) {
						if (words[i].equals(target)) {
							answer = word.cnt + 1;
							break;
						}
						visited[i] = true;
						queue.add(new Word(words[i], word.cnt + 1));
					}
				}
			}
			if (answer > 0) {
				break;
			}
		}
		return answer;
	}
}
