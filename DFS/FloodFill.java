//#733
class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image == null || image.length == 0 || sr >= image.length || sr < 0 ||
			sc >= image[0].length || sc < 0) return image;
		int color = image[sr][sc];
	  //This helps avoid stackoverflow
	  if (color == newColor) return image;
	  helper(image, color, sr, sc, newColor);
	  return image;
	}
	private void helper(int[][]image, int color, int sr, int sc, int newColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length 
			|| image[sr][sc] != color) return;

		image[sr][sc] = newColor;
		
		helper(image, color, sr - 1, sc, newColor);
		helper(image, color, sr + 1, sc, newColor);
		helper(image, color, sr, sc - 1, newColor);
		helper(image, color, sr, sc + 1, newColor);
	}
}