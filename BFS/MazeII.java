//#505

class MazeII {
	public int shortestPath(int[][] maze, int[] start, int[] destination) {
		int[][] steps = new int[maze.length][maze[0].length];
		for (int i = 0; i < steps.length; i++) {
			Arrays.fill(steps[i], Integer.MAX_VALUE);
		}
		steps[start[0]][start[1]] = 0;
		int[][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int[] dir : dirs) {
        int step = steps[curr[0]][curr[1]];
        int x = curr[0] + dir[0];
        int y = curr[1] + dir[1];
        while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
            x += dir[0];
            y += dir[1];
            step++;
        }
        if (step < steps[x - dir[0]][y - dir[1]]) {
            queue.offer(new int[]{x-dir[0], y-dir[1]});
            steps[x-dir[0]][y-dir[1]] = step;
        }
			}
		}
		return steps[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : steps[destination[0]][destination[1]];  
	}
}