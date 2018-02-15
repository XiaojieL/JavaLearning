//#687
class LongestUnivaluePath {
	public int longestUnivaluePath(TreeNode root) {
		if (root == null) return 0;
		int leftMax = longestUnivaluePath(root.left);
		int rightMax = longestUnivaluePath(root.right);
		int rootMax = helper(root.left, root.val) + helper(root.right, root.val);
		return Math.max(Math.max(leftMax, rightMax), rootMax);
	}
	private int helper(TreeNode root, int val) {
		if (root == null || root.val != val) return 0;
		return 1 + Math.max(helper(root.left, val), helper(root.right, val));
	}
}