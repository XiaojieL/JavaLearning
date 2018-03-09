class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] pair : prerequisites) {
			int c1 = pair[0];
			int c2 = pair[1];
			map.putIfAbsent(c2, new HashSet<>());
			//there might exist duplicates, only when c1 doesn't appear in c2's set,
			//we increase c1's indegree
			if (!map.get(c2).contains(c1)) {
				map.get(c2).add(c1);
			  indegree[c1]++;
		  }
		}

		List<Integer> res = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		if (queue.isEmpty() || queue.size() == 0) return new int[];

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			res.add(curr);
			if (!map.containsKey(curr) || map.get(curr) == null) continue;
			for (int course : map.get(curr)) {
				indegree[course]--;
				if (indegree[course] == 0) {
					queue.offer(course);
				}
			}
		}
		if (res.size() != numCourses) return new int[];
		int[] result = new int[numCourses];
		result = res.toArray(result);
		return result;
	}
}