//#345
class ReverseVowels {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) return s;
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		int left = 0;
		int right = s.length() - 1;
		char[] sChar = s.toCharArray();
		while (left < right) {
			char leftChar = sChar[left];
			char rightChar = sChar[right];
			if (set.contains(leftChar) && set.contains(rightChar)) {
				char temp = leftChar;
				sChar[left] = rightChar;
				sChar[right] = temp;
				left++;
				right--;
			}
			if (!set.contains(leftChar)) {
				left++;
			} 
			if (!set.contains(rightChar)) {
				right--;
			}
		}
		return new String(sChar);
	}
}