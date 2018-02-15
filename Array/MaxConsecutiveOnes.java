//#485
class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int left = 0;
		int right = 0;
		int max = 0;
		while (left < nums.length && right < nums.length) {
			while (left < nums.length && nums[left] != 1) {
				left++;
			}
			right = left;
			while (right < nums.length && nums[right] != 0) {
				right++;
			}
			max = Math.max(max, (right - left));
			while (right < nums.length && nums[right] != 1) {
				right++;
			}
			left = right;
		}
		return max;
	}
}