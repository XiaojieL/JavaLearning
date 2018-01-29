//#686
class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		int count = 1;
		StringBuilder sb = new StringBuilder(A);
		while (sb.length() < B.length()) {
			sb.append(A);
			count++;
		}
		if (sb.indexOf(B) >= 0) return count;
		if (sb.append(A).indexOf(B) >= 0) return count+1;
		return -1;
	}
}