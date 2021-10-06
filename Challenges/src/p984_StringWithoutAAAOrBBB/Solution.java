package p984_StringWithoutAAAOrBBB;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/7 0:45
 */
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int tempA = 0, tempB = 0;
        while (a + b > 0) {
            if (a > b) {
                if (tempA >= 2) {
                    sb.append('b');
                    tempA = 0;
                    tempB++;
                    b--;
                } else {
                    sb.append('a');
                    tempB = 0;
                    tempA++;
                    a--;
                }
            } else if (a < b) {
                if (tempB >= 2) {
                    sb.append('a');
                    tempB = 0;
                    tempA++;
                    a--;
                } else {
                    sb.append('b');
                    tempA = 0;
                    tempB++;
                    b--;
                }
            } else {
                if (tempA < 2) {
                    sb.append('a');
                    tempB = 0;
                    tempA++;
                    a--;
                } else {
                    sb.append('b');
                    tempA = 0;
                    tempB++;
                    b--;
                }
            }
        }
        return sb.toString();
    }
}





















