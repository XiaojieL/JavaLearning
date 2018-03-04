class BinaryTreeNode {
	boolean isValidTree(TreeNode[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		Set<TreeNode> set = new HashSet<>();
		for (TreeNode node : arr) {
			TreeNode left = node.left;
			TreeNode right = node.right;
			if (left != null){
				if (set.contains(left)) return false;
				set.add(left);
			}
			if (right != null) {
				if (set.contains(right)) return false;
				set.add(right);
			}
		}
		return set.size() == arr.length - 1;
	}
}