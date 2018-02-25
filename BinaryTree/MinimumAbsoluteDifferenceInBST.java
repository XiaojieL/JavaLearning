//#530
//ATTN: when root is null, return Integer.MAX_VALUE instead of 0, in case 0 might
//be used as a current minimum in future recursion
class MinimumAbsoluteDifferenceInBST {
	public int getMinimumDifference(TreeNode root) {
		if (root == null) return Integer.MAX_VALUE;
		int minLeft = root.left != null ? root.val - getMaxOnLeft(root.left) : Integer.MAX_VALUE; 
		int minRight = root.right != null ? getMinOnRight(root.right) - root.val : Integer.MAX_VALUE;
		int minDiff = Math.min(minLeft, minRight);
		return Math.min(minDiff, Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right)));

	}
	private int getMaxOnLeft(TreeNode node) {
		if (node == null) return 0;
		while (node.right != null) {
			node = node.right;
		}
		return node.val;
	}
	private int getMinOnRight(TreeNode node) {
		if (node == null) return 0;
		while (node.left != null) {
			node = node.left;
		}
		return node.val;    
	}
}