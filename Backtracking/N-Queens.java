class N-Queens {
  public List<List<Integer>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    List<List<Integer>> res = new ArrayList<>();
    backtrack(board, 0, res);
    return res;
  }
  private void backtrack(char[][] board, int col, List<List<Integer>> res) {
    if (col == board.length) {
      res.add(construct(board));
      return;
    }
    if (col > board.length) return;
    for (int i = 0; i < board.length; i++) {
      if (validate(board, i, col)) {
        board[i][col] = 'Q';
        backtrack(board, col+1, res);
        board[i][col] = '.';
      }
    }
  }

  private boolean validate(char[][] board, int x, int y) {
    for (int i = 0)
  }
}
