//#144
public class BinaryTreePreorderTraversal {
  //iterative
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      res.add(curr.val);
      if (curr.right != null) {
        stack.push(curr.right);
      }
      if (curr.left != null) {
        stack.push(curr.left);
      }
    }
    return res;
  }

  //recursive
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    if (root != null) res.add(root.val);
    res.addAll(preorderTraversal(root.left));
    res.addAll(preorderTraversal(root.right));
    return res;
  }
}
