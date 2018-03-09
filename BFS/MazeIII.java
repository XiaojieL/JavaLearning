//#499
class MazeIII {
	
	
	// public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
	// 	char[] move = new char[] {'r', 'd', 'u', 'l'};
	// 	int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
	// 	Queue<int[]> queue = new LinkedList<>();
	// 	queue.offer(ball);
	// 	List<String> res = new ArrayList<>();
	// 	while (!queue.isEmpty()) {
	// 		int[] curr = queue.poll();

	// 		for (int i = 0; i < dirs.length; i++) {
	// 			StringBuilder sb = new StringBuilder();

	// 			int x = curr[0] + dir[i][0];
	// 			int y = curr[1] + dir[i][1];
	// 			sb.append(move[i]);
	// 			if (x == hole[0] && y == hole[0]) {
	// 				res.add(sb.toString());
	// 				continue;
	// 			}
	// 			if (x >= 0 && y >=0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
	// 				x += dir[i][0];
	// 				y += dir[i][1];
	// 				if (x == hole[0] && y == hole[0]) {
	// 					res.add(sb.toString());
	// 					continue;
	// 				}
	// 			}
	// 			queue.offer(new int[]{x-dir[i][0], y-dir[i][1]});
	// 		}
	// 	}

	// 	if (res.size() < 1) return "impossible";
	// 	if (res.size() == 1) return res.get(0);
	// 	Collections.sort(res);
	// 	return res.get(0);

	// }
}