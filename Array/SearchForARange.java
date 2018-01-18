//#34
class SearchForARange {
  public int[] searchRange(int[] nums, int target) {
  	int[] result = new int[2];
  	if (nums == null || nums.length == 0 
  		|| target < nums[0] || target > nums[nums.length - 1]) {
  		result[0] = -1;
  		result[1] = -1;
  		return result;
  	}
  	result[0] = findLeft(nums, target);
  	result[1] = findRight(nums, target);
  	return result;
  }
  private int findLeft(int[] nums, int target) {
  	int idx = -1;
  	int left = 0;
  	int right = nums.length - 1;
  	while (left + 1< right) {
  		int mid = left + (right - left) / 2;
  		if (nums[mid] < target) {
  			left = mid + 1;
  		} else if (nums[mid] > target) {
  			right = mid - 1;
  		} else {
  			right = mid;
  		}

  		if (nums[left] == target) idx = left;
  		else if (nums[right] == target) idx = right;
  	}
    return idx;
  }

   private int findRight(int[] nums, int target) {
   	int idx = -1;
  	int left = 0;
  	int right = nums.length - 1;
  	while (left + 1 < right) {
  		int mid = left + (right - left) / 2;
  		if (nums[mid] < target) {
  			left = mid;
  		} else if (nums[mid] > target) {
  			right = mid;
  		} else {
  			left = mid;
  		}
  		if (nums[right] == target) idx = right;
  		else if (nums[left] == target) idx = left;
  	}
    return idx;
  }

}