package p1405_LongestHappyString;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 3:03
 */
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        while (a + b + c > 0) {
            if ((a > b && a > c && aCount < 2)) {
                sb.append('a');
                a--;
                aCount++;
            } else if ((b > a && b > c && bCount < 2)) {
                sb.append('b');
                b--;
                bCount++;
            } else {
                sb.append('c');
                c--;
                cCount++;
            }
        }
        return sb.toString();
    }
}
