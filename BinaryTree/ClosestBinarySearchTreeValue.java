//#270
class ClosestBSTValue {
	//iterative
	public int closestValue(TreeNode root, double target) {
		if (root.left == null && root.right == null) return root.val;
		int closestVal = root.val;
		while (root != null) {
			closestVal = Math.abs(target - root.val) < Math.abs(target - closestVal) 
			             ? root.val : closestVal;
			if (closestVal == target) {
				return closestVal;
			} 
			root = root.val > target ? root.left : root.right;
		}
		return closestVal;     
	}

  //recursive
  public int closestValue(TreeNode root, double target) {
  	return helper(root, target, root.val);
  }
  private int helper(TreeNode node, double target, int val) {
  	if (node == null) return val;
  	if (Math.abs(node.val - target) < Math.abs(val - target)) {
  		val = node.val;
  	}
  	if (val == target) return val;
  	if (node.val > target) return helper(node.left, target, val);
  	if (node.val < target) return helper(node.right, target, val);
  	return val;
  }

}