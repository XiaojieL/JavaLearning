//#139
class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) return false;
		boolean[] canBreak = new boolean[s.length+1];
		canBreak[0] = true;
		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j < i; j++) {
				canBreak[i] = canBreak[j] && wordDict.contains(s.subString(j, i));
			}
		}
		return canBreak[s.length()];
	}
}