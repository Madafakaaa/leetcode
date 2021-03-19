package p1769_MinimumNumberOperationsMoveAllBallsEachBox;

/**
 * @description: You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 * <p>
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 * <p>
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 * <p>
 * Each answer[i] is calculated considering the initial state of the boxes.
 * <p>
 * Input: boxes = "110"
 * Output: [1,1,3]
 * <p>
 * Input: boxes = "001011"
 * Output: [11,8,5,4,3,4]
 */
class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        int move = 0, num = 0;
        int i;
        for (i = 0; i < boxes.length(); i++) {
            move += num;
            res[i] = move;
            if (boxes.charAt(i) == '1') num++;
        }
        move = 0;
        num = 0;
        for (i = boxes.length() - 1; i >= 0; i--) {
            move += num;
            res[i] += move;
            if (boxes.charAt(i) == '1') num++;
        }
        return res;
    }
}
