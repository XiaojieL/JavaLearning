//#769
class MaxChunksToMakeSorted {
	public int maxChunksToSorted(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		int len = arr.length;
		int[] leftMax = new int[len];
		int[] rightMin = new int[len];
		int res = 0;
		leftMax[0] = arr[0];
		for (int i = 1; i < len; i++) {
			leftMax[i] = Math.max(leftMax[i-1], arr[i]);
		}
		rightMin[len-1] = arr[len-1];
		for (int j = len-2; j >= 0; j--) {
			rightMin[j] = Math.min(rightMin[j+1], arr[j]);
		}
		for (int k = 0; k < len-1; k++) {
			if (leftMax[k] < rightMin[k+1]) {
				res++;
			}
		}
		return res+1;
	}
}