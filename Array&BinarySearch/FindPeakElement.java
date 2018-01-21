//#162 ATTN: nums[i] != nums[i+1]
class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (nums[left] > nums[right]) {
			return left;
		}
		return right;
	}
}