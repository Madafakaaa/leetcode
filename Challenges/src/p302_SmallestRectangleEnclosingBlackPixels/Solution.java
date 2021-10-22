package p302_SmallestRectangleEnclosingBlackPixels;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/19 17:36
 */
class Solution {

    public char[][] image;
    public int minX;
    public int maxX;
    public int minY;
    public int maxY;

    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        minX = x;
        minY = y;
        maxX = x;
        maxY = y;
        dfs(x, y);
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    public void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != '1') {
            return;
        }
        image[x][y] = ' ';
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
