public class GuessNumberHigherOrLower {
	public int guessNumber(int n) {
		int left = 1;
		int right = n;
		while (left <= right) {
			int res = left + (right - left)/2;
			if (guess(res) == -1) right = res-1;
			if (guess(res) == 1) left = res+1;
			if (guess(res) == 0) return res;
		}
    return -1;
	}
}