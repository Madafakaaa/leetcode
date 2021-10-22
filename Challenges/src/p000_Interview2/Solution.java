package p000_Interview2;

import java.util.Arrays;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/14 14:54
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }

    public boolean winnerOfGame(String colors) {
        if (colors.isEmpty()) {
            return false;
        }
        int aCount = 0;
        int bCount = 0;
        int a = 0;
        int b = 0;
        if (colors.charAt(0) == 'A') {
            a++;
        } else {
            b++;
        }
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                if (a >= 2) {
                    aCount++;
                }
                a++;
                b = 0;
            } else {
                if (b >= 2) {
                    bCount++;
                }
                b++;
                a = 0;
            }
        }
        return aCount > bCount;
    }

}
