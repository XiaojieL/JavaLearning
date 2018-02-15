//#298
class BinaryTreeLongestConsecutiveSequence {
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		dfs(root, null, 0);
		return maxLen;
	}
	private void dfs(TreeNode node, TreeNode parent, int curLen) {
		if (node == null) return;
		curLen = (parent != null && node.val == parent.val+1) ? curLen + 1 : 1;
	    maxLen = Math.max(maxLen, curLen);
	    dfs(node.left, node, curLen);
	    dfs(node.right, node, curLen);  
	}
}