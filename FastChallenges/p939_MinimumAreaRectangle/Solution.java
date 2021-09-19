package FastChallenges.p939_MinimumAreaRectangle;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 1:40
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int height = image.length;
        int width = image[0].length;
        Integer left, right, temp;
        for (int i = 0; i < height; i++) {
            left = 0;
            right = width - 1;
            while (left < right) {
                temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = 1 - temp;
                image[i][left] = 1 - image[i][right];
                left++;
                right--;
            }
            if (left.equals(right)) {
                image[i][right] = 1 - image[i][right];
            }
        }
        return image;
    }
}
