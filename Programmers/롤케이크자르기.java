class Solution {
	public int solution(int[] topping) {
		int answer = 0;

		int arr1[] = new int[10001];
		int arr2[] = new int[10001];

		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < topping.length; i++) {
			if (arr1[topping[i]] == 0) {
				cnt1 += 1;
			}
			arr1[topping[i]] += 1;
		}

		for (int i = 0; i < topping.length; i++) {
			arr1[topping[i]] -= 1;
			if (arr1[topping[i]] == 0) {
				cnt1 -= 1;
			}

			if (arr2[topping[i]] == 0) {
				cnt2 += 1;
			}
			arr2[topping[i]] += 1;

			if (cnt1 == cnt2) {
				answer += 1;
			}
		}
		return answer;
	}
}