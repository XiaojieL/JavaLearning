class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		if (edges == null || edges.length == 0) return false;
		Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
    for (int[] edge : edges) {
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }

		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (set.contains(curr)) return false;
			for (int e : map.get(curr)) {
				map.get(e).remove(curr);
				queue.add(e);
			}
			set.add(curr);
		}
		return set.size() == n;
	}
}