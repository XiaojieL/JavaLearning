//#463
class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					res += 4;
					//only subtract overlapping edges when current cell is 1
					if (i+1 <grid.length && grid[i+1][j] == 1) {
						res -= 2;
					}
					if (j+1 < grid[0].length && grid[i][j+1] == 1) {
						res -=2;
					}
				}
			}
		}
		return res;
	}
}