//#136
class SingleNumber {
	public int SingleNumber(int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
    	//when nums[i] occurs first time, add into the set
      if (!set.contains(nums[i])) {
      	set.add(nums[i]);
      } else {
      	//when nums[i] occurs second time, remove it from the set
      	set.remove(nums[i]);
      }
    }
    //the only remaining object in the set is the one occurs once
    //ATTN: iterator.next() returns an object, needs to be convert to int
    Iterator iterator = set.iterator();
    return (int)iterator.next();
	}
}