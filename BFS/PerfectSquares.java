//#279
class PerfectSquares {
	public int numSquares(int n) {
		if (n <= 0) return 0;
		int[] res = new int[n + 1];
		Arrays.fill(res, Integer.MAX_VALUE);
		for (int i = 0; i * i <= n; i++) {
			res[i*i] = 1;
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0; i + j*j <= n; j++) {
				res[i+j*j] = Math.min(res[i] + 1, res[i+j*j]);
			}
		}
		return res[n];
	}
}