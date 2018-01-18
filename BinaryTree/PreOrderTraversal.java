//#144
//PreOrder: root-left-right
class PreOrderTraversal {
  //recursive
  public List<Integer> preOrderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    result.add(root.val);
    result.addAll(preOrderTraversal(root.left));
    result.addAll(preOrderTraversal(root.right));
    return result;
  }
  //iterative
  public List<Integer> preOrderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root != null) {
      stack.push(root);
    }
    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      result.add(curr.val);
      if (curr.right != null) {
        stack.push(curr.right);
      }
      if (curr.left != null) {
        stack.push(curr.left);
      }
    }
    return result;
  }
}
