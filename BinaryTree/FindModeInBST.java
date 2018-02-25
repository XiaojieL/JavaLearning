//#501
class FindModeInBST {
	public int[] findMode(TreeNode root) {
			List<Integer> res = new ArrayList<>();
		if (root == null) return new int[0];
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (!map.containsKey(curr.val)) {
				map.put(curr.val, 1);
			} else {
				map.put(curr.val, map.get(curr.val)+1);
			}
			max = Math.max(max, map.get(curr.val));
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
		}
		for (int key : map.keySet()) {
			if (map.get(key) == max) {
				res.add(key);
			}
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = res.get(i);
		}
		return result;        
	}
}