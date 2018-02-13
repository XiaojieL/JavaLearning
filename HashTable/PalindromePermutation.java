//#266
class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0) return false;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c)+1);
			}
		}

		int oddCount = 0;
		//ATTN: use map.keySet to get the unique char in S
		for (char key : map.keySet()) {
			if (map.get(key) % 2 != 0) {
				oddCount++;
			}
		}
		if (oddCount > 1) return false;
		return true;
	}
}