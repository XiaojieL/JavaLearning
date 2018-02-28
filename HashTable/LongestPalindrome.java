class LongestPalindrome {
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0) return 0;
		Map<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int odd = 0;
		int res = 0;
		for (char key : map.keySet()) {
      int count = map.get(key);
			if (count % 2 == 0) {
				res += count;
			} else {
				//if count is 1, 1-1 = 0, won't add into res
				//if count is 3, could use two of them, thus add count-1
        res += count-1;
        odd++;
			}
		}
		//if odd num is more than 0, could add 1 more at the end as middle
    if (odd != 0) return res+1;
		return res;  
	}
}