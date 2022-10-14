package leetcode.interview;

/*
    找到位置

 */
public class i_08_10 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //
        image[sr - 1][sc] = newColor;
        image[sr + 1][sc] = newColor;

        return image;
    }
}
