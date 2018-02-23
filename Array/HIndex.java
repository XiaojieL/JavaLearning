//#274
class HIndex {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) return 0;
		Arrays.sort(citations);
		int res = 0;
		for (int i = 0; i < citations.length; i++) {
			if (citations[citations.length-1-i] > i) {
				res++;
			}
		}
		return res;
	}
}