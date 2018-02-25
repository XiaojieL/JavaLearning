//#652
//since the map stores serialized subtree, add TreeNode to res in helper function
class FindDuplicateSubtrees {
 	Map<String, Integer> map = new HashMap<>();
  List<TreeNode> res = new ArrayList<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		if (root == null) return res;
		dfs(root);
		return res;
	}

	private String dfs(TreeNode root) {
		if (root == null) return "#";
		String s = root.val + "," + dfs(root.left) + "," + dfs(root.right);
		map.put(s, map.getOrDefault(s, 0) + 1);
    if (map.get(s) == 2) {
      res.add(root);
    }
		return s;
  }
}