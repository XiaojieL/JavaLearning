//#20
class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length == 0) return false;
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				stack.add(c);
			} else {
				if (!stack.isEmpty() && map.get(c) == stack.pop()){
					continue;
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}