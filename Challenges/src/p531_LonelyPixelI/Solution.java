package p531_LonelyPixelI;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/13 20:58
 */
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int height = picture.length;
        int width = picture[0].length;
        int[] rows = new int[height];
        int[] cols = new int[width];
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (picture[i][j] == 'B' && rows[i] * cols[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
