//#28
class StrStr {
	//hello ll
	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) return 0;
		for (int i = 0; i < haystack.length() - needle.length(); i++) {
			for (int j = 0; j <= needle.length(); j++) {
				if(j == needle.length()) return i;
				if (haystack.charAt(i) != needle.charAt(j)) {
					break;
				}
			}
		}
		return -1;
	}
}