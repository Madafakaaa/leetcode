package FloodFill;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        int height = image.length;
        int width = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            image[loc[0]][loc[1]] = newColor;
            if (loc[0] > 0 && image[loc[0] - 1][loc[1]] == oldColor) queue.add(new int[]{loc[0] - 1, loc[1]});
            if (loc[0] < height - 1 && image[loc[0] + 1][loc[1]] == oldColor) queue.add(new int[]{loc[0] + 1, loc[1]});
            if (loc[1] > 0 && image[loc[0]][loc[1] - 1] == oldColor) queue.add(new int[]{loc[0], loc[1] - 1});
            if (loc[1] < width - 1 && image[loc[0]][loc[1] + 1] == oldColor) queue.add(new int[]{loc[0], loc[1] + 1});
        }

        return image;
    }

}