//#39
public List<List<Integer> combinationSum(int[] candidates, int target) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	if (candidates == null || candidates.length == 0) return result;
	List<Integer> combination = new ArrayList<Integer>();
	Arrays.sort(candidates);
	helper(candidates, target, result, 0, combination);
	return result;
}

private void helper(int[] candidates, int remainTarget, List<List<Integer>> result, 
	                  int startIndex, List<Integer> combination) {
  if (remainTarget == 0) {
  	//ATTN: new ArrayList<Integer>(combination) -> don't use new List<>(), 
  	//List is abstract interface, cannot be initialized.
  	result.add(new ArrayList<Integer>(combination));
  	return;
  }

  for (int i = startIndex; i < candidates.length; i++) {
  	if (remainTarget < candidates[i]) {
  		break;
  	}

  	combination.add(candidates[i]);
  	helper(candidates, remainTarget-candidates[i], result, i, combination);
  	combination.remove(combination.size()-1);
  }
}