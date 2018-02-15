//#246
class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String s){
		if (s == null || s.length() == 0) return false;
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('8', '8');
		map.put('6', '9');
		map.put('9', '6');
		int i = 0;
		int j = s.length() - 1;
		while (i <= j) {
			char left = s.charAt(i);
			char right = s.charAt(j);
			if (!map.containsKey(left) || !map.containsKey(right) || map.get(left) != right) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}