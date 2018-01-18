//#94
//InOrder: left-root-right
class InOrderTraversal {
  //recursive
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    helper(root, result);
    return result;
  }
  private void helper(TreeNode root, List<Integer> result) {
    if (root != null) {
      helper(root.left, result);
      result.add(root.val);
      helper(root.right, result);
    }
  }


  //iterative
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      if (curr != null) {
        stack.push(curr);
        curr = curr.left;
      } else {
        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
      }
    }
    return result;
  }
}
