public class SerializeAndDeserializeBinaryTree {
	public String serialize(TreeNode root) {
		if (root == null) return "#";
		String s = String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
		return s;
	}

	public TreeNode deserialize(String data){
		if (data == "#") return null;
		String[] dataArray = data.split(",");
		Queue<String> queue = new LinkedList<>();
		for (String s : dataArray) {
			queue.add(s);
		}
		return dfs(queue);
	}

	private TreeNode dfs(Queue<String> queue) {
		if (queue.isEmpty) return null;
		String curr = queue.poll();
		if (curr.equals("#")) return null;
		TreeNode root = new TreeNode(Integer.valueOf(curr));
		root.left = dfs(queue);
		root.right = dfs(queue);
		return root;
	}
}