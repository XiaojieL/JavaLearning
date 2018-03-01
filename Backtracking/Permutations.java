//#46 distinct numbers all possible permutation
class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    List<Integer> sample = new ArrayList<>();
    helper(nums, res, sample);
    return res;
  }
  private void helper(int[] nums, List<List<Integer>> res, List<Integer> sample) {
    if (sample.size() == nums.length) {
      res.add(new ArrayList<Integer> (sample));
      return;
    }
    for (int i = 0 ; i < nums.length; i++) {
      if (sample.contains(nums[i])) {
        continue;
      }
      sample.add(nums[i]);
      helper(nums, res, sample);
      sample.remove(sample.size()-1);
    }
  }
}
