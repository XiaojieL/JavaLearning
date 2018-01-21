class ZigZagLevelOrder {
	public class List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Stack<TreeNode> currStack  = new Stack<>();
		Stack<TreeNode> nextStack = new Stack<>();
		Stack<TreeNode> temp = null;
		currStack.push(root);
		boolean normalOrder = true;
		while (!currStack.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			while (!currStack.isEmpty()) {
				TreeNode curr = currStack.pop();
				level.add(curr.val);
				if (normalOrder) {
					if (curr.left != null) {
						nextStack.push(curr.left);
					}
					if (curr.right != null) {
						nextStack.push(curr.right);
					}
				} else {
					if (curr.right != null) {
						nextStack.push(curr.right);
					}
					if (curr.left != null) {
						nextStack.push(curr.left);
					}
				}
			}
			
			result.add(level);
			temp = currStack;
			currStack = nextStack;
			nextStack = temp;
			normalOrder = !normalOrder;
    }
		return result;
	}
}