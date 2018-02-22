//#521
class LongestUncommonSubsequence {
	public int findLUSlength(String a, String b) {
		if (a == null && b == null) return -1;
		return Math.max(a.length(), b.length());
	}
}