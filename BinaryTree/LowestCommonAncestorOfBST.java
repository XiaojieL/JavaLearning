//Utilize the features of BST
class LowestCommonAncestorOfBST {
  //iterative
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) return root;
    while (root != null) {
      if (root.val > p.val && root.val > q.val) root = root.left;
      else if (root.val < p.val && root.val < q.val) root = root.right;
      else return root;
    }
    return root;
  }

  //recursive
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) return root;
    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor(root.right, p, q);
    }
    return root;
  }
}
