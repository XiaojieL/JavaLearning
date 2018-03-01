class UniquePathII {
  public int uniquePathII(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] == 1) return 0;
    int[][] res = new int[m][n];
    res[0][0] = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (obstacleGrid[i][j] == 1) res[i][j] = 0;
        if (i == 0 && j != 0 && obstacleGrid[i][j] != 1) res[i][j] = res[i][j-1];
        if (j == 0 && i != 0 && obstacleGrid[i][j] != 1) res[i][j] = res[i-1][j];
        if (i != 0 && j != 0 && obstacleGrid[i][j] != 1) res[i][j] = res[i-1][j] + res[i][j-1];
      }
    }
    return res[m-1][n-1];
  }
}
