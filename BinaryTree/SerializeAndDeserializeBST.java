//#449
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if (root == null) return "#";
    	String s = root.val + "," + serialize(root.left) + "," + serialize(root.right);
    	return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	String[] dataArray = data.split(",");
    	Queue<String> queue = new LinkedList<>();
    	for (String s : dataArray) {
    		queue.add(s);
    	}
    	return dfs(queue);
    }
    private TreeNode dfs(Queue<String> queue) {
    	String curr = queue.poll();
    	if (curr.equals("#")) return null;
    	TreeNode root = new TreeNode(Integer.valueOf(curr));
    	root.left = dfs(queue);
    	root.right = dfs(queue);
    	return root;
    }
}