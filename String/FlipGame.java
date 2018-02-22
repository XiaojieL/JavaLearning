//#293
class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<>();

		for (int i = 0; i < s.length() - 1; i++) {
			char[] sChar = s.toCharArray();
			if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
				sChar[i] = '-';
				sChar[i+1] = '-';
				//only when there are valid changes, add into res
				res.add(new String(sChar));
			}
		}
		return res;
	}
}