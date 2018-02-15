//#766
//only needs to compare current cell versus its top left one
//pay attention to edge
class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return false;
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = row-1; i > 0; i--) {
			for (int j = col-1; j > 0; j--) {
				if (matrix[i][j] != matrix[i-1][j-1]) return false;
			}
		}
		return true;
	}
}