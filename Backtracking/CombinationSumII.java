public List<List<Integer>> combinationSum2(int[] candidates, int target) {
  List<List<Integer>> res = new ArrayList<>();
  Arrays.sort(candidates);
  backtrack(candidates, target, 0, new ArrayList<>(), res);
  return res;
}
private void backtrack(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> res) {
  if (target == 0) {
    res.add(new ArrayList<>(temp));
    return;
  }
  if (target < 0) return;
  for (int i = start; i < candidates.length; i++) {
    //reduce duplicate
    if (i > start && candidates[i] == candidates[i-1]) continue;
    temp.add(candidates[i]);
    backtrack(candidates, target-candidates[i], i+1, temp, res);
    temp.remove(temp.size()-1);
  }
}
