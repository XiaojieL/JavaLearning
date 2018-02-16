//#747
class LargestNumberAtLeastTwiceOfOthers {
	public int dominantIndex(int[] nums){
		if (nums == null || nums.length == 0) return -1;
		if (nums.length == 1) return 0;
		int maxIndex = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != max && nums[i] * 2 > max) {
				return -1;
			}
		}
		return maxIndex;
	}
}