//#271
class EncodeAndDecodeString {
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			int len = s.length();
			sb.append(len);
			sb.append('/');
			sb.append(s);
		}
		return sb.toString();
	}
	public List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		int start = 0;
		while (start < s.length()) {
			//Returns the index within this string of the first occurrence 
			//of the specified substring, starting at the specified index.
			int slashIndex = s.indexOf('/', start);
			int len = Integer.valueOf(s.substring(start, slashIndex));
			String sub = s.substring(slashIndex+1, slashIndex+len+1);
			res.add(sub);
			start = slashIndex+len+1;
		}
		return res;
	}
}