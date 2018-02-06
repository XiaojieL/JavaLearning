//#290
class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
			return false;
		}
		String[] strArr = str.split(" ");
		if (pattern.length() != strArr.length) return false;
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < strArr.length; i++) {
			char currChar = pattern.charAt(i);
			String currWord = strArr[i];
			if (!map.containsKey(currChar)) {
        if (map.containsValue(currWord)) {
        	return false;
        } else {
        	map.put(currChar, currWord);
        }
			} else {
				//ATTN: use .equals() to compare string -> tests for value equality
				// == tests for reference equality
				if (!map.get(currChar).equals(currWord)) {
					return false;
				}
			}
		}
		return true;
	}
}