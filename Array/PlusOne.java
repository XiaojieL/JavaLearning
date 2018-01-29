//#66
class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) return null;
		//the for loop only continues when there's continues 9, eg. 99
		//if it's non-consecutive 9 appears, it will break at the non 9 position,
	  //eg. 989, will break at 8
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				break;
			} else {
				digits[i] = 0;
			}
		}
		if (digits[0] == 0) {
			int[] res = new int[digits.length+1];
			res[0] = 1;
			return res;
		}
		return digits;
	}
}