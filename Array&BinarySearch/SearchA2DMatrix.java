//#74
class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 
			|| matrix[0] == null || matrix[0].length == 0) {
			return false;
		}
		//starting from the top right corner, if target is bigger than top right,
		//move down, if smaller, move to left
		int row = 0;
		int col = matrix[0].length - 1;

		while (row < matrix.length && col >=0) {
			if (target > matrix[row][col]) {
				row++;
			} else if (target < matrix[row][col]) {
				col--;
			} else {
				return true;
			}
		}
		return false;
	}
}