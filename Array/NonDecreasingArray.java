//665
class NonDecreasingArray {
  //modify original array: 
  public boolean checkPossibility(int[] nums) {
    if (nums == null || nums.length == 0) return true;
    int count = 0;
    for (int i = 0; i + 1 < nums.length; i++) {
      if (nums[i] > nums[i+1]) {
        count++;
        if (count > 1) {
          return false;
        }
        if (i > 0 && nums[i+1] <nums[i-1]) {
          nums[i+1] = nums[i];
        } else {
          nums[i] = nums[i+1];
        }
      }
    }
    return true;
  }
}
