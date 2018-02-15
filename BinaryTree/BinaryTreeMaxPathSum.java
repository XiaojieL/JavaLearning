//#124
public class BinaryTreeMaxPathSum{
	private int max;
	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		helper(root);
		return result;
	}
	private int helper(TreeNode root) {
		if (root == null) return 0;
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		max = Math.max(max, left + right + root.val);
		return Math.max(left, right) + node.val;
	}
}