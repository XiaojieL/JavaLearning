class MinDistanceBetweenBSTNodes {
  //iterative
  public int minDiffInBST(TreeNode root) {
    if (root == null) return 0;
    int res = Integer.MAX_VALUE;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    TreeNode prev = null;
    while (curr != null || !stack.isEmpty()) {
      if (curr != null) {
        stack.push(curr);
        curr = curr.left;
      } else {
        curr = stack.pop();
        if (prev == null) prev = curr;
        else {
          int diff = curr.val - prev.val;
          res = Math.min(res, diff);
          prev = curr;
        }
        curr = curr.right;
      }
    }
    return res;
  }

  //recursive
  private res = Integer.MAX_VALUE;
  private TreeNode prev = null;
  public int minDiffInBST(TreeNode root) {
    if (root.left != null) minDiffInBST(root.left);
    if (prev != null) res = Math.min(res, root.val - prev.val);
    prev = root;
    if (root.right != null) minDiffInBST(root.right);
    return res;
  }
}
