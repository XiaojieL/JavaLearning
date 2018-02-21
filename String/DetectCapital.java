//#520
class DetectCapitalUse {
	public boolean detectCapitalUse(String word) {
		if (word == null || word.length() <= 1) return true;
		char first = word.charAt(0);
		char second = word.charAt(1);
		for (int i = 2; i < word.length(); i++) {
			if (Character.isUpperCase(first)) {
				if (Character.isUpperCase(second)) {
					if (!Character.isUpperCase(word.charAt(i))) return false;
					else continue;
				} else {
					if (Character.isUpperCase(word.charAt(i))) return false;
					else continue;
				}
			} else {
				if (Character.isUpperCase(second)) return false;
				else if (Character.isUpperCase(word.charAt(i))) return false;
                else continue;
			}
		}
		return (Character.isUpperCase(first) == Character.isUpperCase(second)) || 
            (Character.isUpperCase(first) && !Character.isUpperCase(second));
	}
}