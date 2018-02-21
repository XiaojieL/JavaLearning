//#257
class BinaryTreePaths {
	//DFS, iterative, stack
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<String> strStack = new Stack<>();
		nodeStack.push(root);
		strStack.push("");
		while (!nodeStack.isEmpty() && !strStack.isEmpty()) {
			TreeNode currNode = nodeStack.pop();
			String currStr = strStack.pop();
			if (currNode.left == null && currNode.right == null) {
				res.add(currStr+currNode.val);
			}
			if (currNode.left != null) {
				nodeStack.push(currNode.left);
				strStack.push(currStr+currNode.val+"->");
			}
			if (currNode.right != null) {
				nodeStack.push(currNode.right);
				strStack.push(currStr+currNode.val+"->");
			}
		}
		return res;
	}

	//BFS, iterative, queue
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<String> strQueue = new LinkedList<>();
		nodeQueue.add(root);
		strQueue.add("");
		while (!nodeQueue.isEmpty() && !strQueue.isEmpty()) {
			TreeNode currNode = nodeQueue.poll();
			String currStr = strQueue.poll();
			if (currNode.left == null && currNode.right == null) {
				res.add(currStr+currNode.val);
			}
			if (currNode.left != null) {
				nodeQueue.add(currNode.left);
				strQueue.add(currStr+currNode.val+"->");
			}
			if (currNode.right != null) {
				nodeQueue.add(currNode.right);
				strQueue.add(currStr+currNode.val+"->");
			}
		}
		return res;
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) return res;
		if (root.left == null && root.right == null) {
      res.add(""+root.val);
      return res;
    }
		for (String s : binaryTreePaths(root.left)) {
			res.add(""+root.val+"->"+s);
		}
		for (String r : binaryTreePaths(root.right)) {
			res.add(""+root.val+"->"+r);
		}
		return res;
	}

}