//#388
class LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		int tempLen = 0;
		String[] paths = input.split("\n");
		for (String s : paths) {
			int level = countLevel(s);
			while (stack.size() > level) {
				tempLen -= stack.pop();
			}
			int currLen = s.replace("\t", "").length()+1;
			tempLen += currLen;
			if (s.contains(".")) {
				result = tempLen-1 > result ? tempLen-1 : result;
			}
			stack.add(currLen);
		}
		return result;
	}

	private int countLevel(String s) {
		String r = s.replace("\t", "");
		return s.length() - r.length();
	}
}