//#389
class FindDiff {
	public char findTheDifference(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c)+1);
			}
		}
		for (char d : t.toCharArray()) {
			if (!map.containsKey(d) || map.get(d) == 0) {
				return d;
			} else {
				map.put(d, map.get(d)-1);
			}
		}
		return '-'; //error case
	}
}