//#643
class MaximumAverageSubarrayI {
	public double findMaxAverage(int[] nums, int k) {
		double subSum = 0.0;
		for (int i = 0; i < k; i++) {
			subSum += nums[i];
		}
		double maxSum = subSum;
		for (int j = k; j < nums.length; j++) {
			subSum += nums[j] - nums[j-k];
			maxSum = Math.max(maxSum, subSum);
		}
		return maxSum/k;
	}
}