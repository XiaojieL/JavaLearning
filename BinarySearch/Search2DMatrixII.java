//#240
class Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == target) return true;
			}
		}
		return false;
	}

	//from left-bottom item, if target > curr, move to right, if curr < target, move to up
	public boolean Search2DMatrix2(int[][] matrix, int target) {
		int row = matrix.length-1;
		int col = 0;
		while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
			int curr = matrix[row][col];
			if (curr > target) {
				col++;
			} else if (curr < target) {
				row--;
			} else {
				return true;
			}
		}
		return false;
	}

}