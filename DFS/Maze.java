//490
class Maze {
	int[] direction = new int[]{0, 1, 0, -1, 0};
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		return dfs(maze, visited, start, destination);
	}
	private boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
		if (visited[start[0]][start[1]]) return false;
		if (Arrays.equals(start, destination)) return true;
		visited[start[0]][start[1]] = true;

		for (int i = 0; i < direction.length - 1; i++) {
			int[] newStart = roll(maze, start, direction[i], direction[i+1]);
			if (dfs(maze, visited, newStart, destination)) return true;
		}
		return false;
	}
    
  private int[] roll(int[][] maze, int[] start, int row, int col) {
      int[] end = new int[2];
      end[0] = start[0];
      end[1] = start[1];
      while(canRoll(maze, end, row, col)) {
          end[0] += row;
          end[1] += col;
      }
      return end;
  }
  
	private boolean canRoll(int[][] maze, int[] start, int row, int col) {
		if (start[0] + row >= maze.length || start[0] + row < 0 
			|| start[1] + col >= maze[0].length || start[1] + col < 0) {
			return false;
		}
		return maze[start[0] + row][start[1]+col] != 1;
	}
}

}