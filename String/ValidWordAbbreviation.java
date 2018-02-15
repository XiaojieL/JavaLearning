//#408
class ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
		if (word == null || word.length() == 0) return false;
		int i = 0;
		int j = 0;
		while (i < word.length() && j < abbr.length()) {
			if (Character.isLetter(abbr.charAt(j)) && 
				abbr.charAt(j++) != word.charAt(j++)) {
				return false;
			}
			StringBuilder sb = new StringBuilder();
			while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
				sb.append(abbr.charAt(j));
				j++;
			}
			int len = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 0;
			i += len;
		}
		return i == word.length() && j == abbr.length();

	}
}