//#543
class DiameterOfBinaryTree {
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    int rootMax = helper(root.left) + helper(root.right);
    int leftMax = diameterOfBinaryTree(root.left);
    int rightMax = diameterOfBinaryTree(root.right);
    return Math.max(rootMax, Math.max(leftMax, rightMax));
  }
  private int helper(TreeNode node) {
    if (node == null) return 0;
    return 1 + Math.max(helper(node.left), helper(node.right));
  }
}
