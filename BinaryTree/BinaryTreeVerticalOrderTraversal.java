//#314
class BinaryTreeVerticalOrderTraversal {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Queue<TreeNode> nodeQ = new LinkedList<>();
    nodeQ.add(root);
    Queue<Integer> colQ = new LinkedList<>();
    colQ.add(0);
    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;
    while (!nodeQ.isEmpty()) {
      TreeNode currNode = nodeQ.poll();
      int currCol = colQ.poll();
      if (currCol < minCol) minCol = currCol;
      if (currCol > maxCol) maxCol = currCol;
      if (!map.containsKey(currCol)) {
        List<Integer> currList = new ArrayList<>();
        currList.add(currNode.val);
        map.put(currCol, currList);
      } else {
        List<Integer> temp = map.get(currCol);
        temp.add(currNode.val);
        //ATTN: directly put the new list to the map, with same key
        map.put(currCol, temp);
      }

      if (currNode.left != null) {
        nodeQ.add(currNode.left);
        colQ.add(currCol-1);
      }
      if (currNode.right != null) {
        nodeQ.add(currNode.right);
        colQ.add(currCol+1);
      }
    }
    for (int i = minCol; i <= maxCol; i++) {
      res.add(map.get(i));
    }
    return res;
  }
}
