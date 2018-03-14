class SubsetsII {
  public List<List<Integer>> subsetsII(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null) return res;
    Arrays.sort(nums);
    backtrack(nums, 0, new ArrayList<>(), res);
    return res;
  }
  private void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
    res.add(new ArrayList<>(temp));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i-1]) continue;
      temp.add(nums[i]);
      backtrack(nums, i+1, temp, res);
      temp.remove(temp.size()-1);
    }
  }
}
