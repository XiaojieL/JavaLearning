class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] pre : prerequisites) {
			//c2 is c1's pre
			int c1 = pre[0];
			int c2 = pre[1];
			map.putIfAbsent(c2, new HashSet<>());
			map.get(c2).add(c1);
			indegree[c1]++;			
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int index = 0; index < indegree.length; index++) {
			if (indegree[index] == 0) {
				queue.offer(index);
			}
		}
		if (queue.isEmpty() || queue.size() == 0) return false;
		int taken = 0;
		while (!queue.isEmpty) {
			int curr = queue.poll();
			taken += 1;
			//need to check if curr has any following courses or not
			//otherwise it will through null pointer exception on line 27
			if (map.get(curr) == null) continue;
			for (int i : map.get(curr)) {
				indegree[i]--;
				if (indegree[i] == 0) queue.offer(i);
			}
		}
		return taken == numCourses;
	}
}