//#482
//ATTN: string is immutable, use a new one to make changes
class LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {	
		String S1 = S.replace("-", "");
		S1 = S1.toUpperCase();
		StringBuilder sb = new StringBuilder();
		sb.append(S1);
		int index = S1.length() - K;
		//index should be > 0, if =0, will insert a "-" at beginning
		while (index > 0) {
			sb.insert(index, "-");
			index -= K;
		}
		return sb.toString();
	}