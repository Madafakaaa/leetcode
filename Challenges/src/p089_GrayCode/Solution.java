package p089_GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/2/18 9:36
 */

class Solution {

    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>((int) Math.pow(2,n));
        int[][] matrix = new int[(int) Math.pow(2,n)][n];
        for(int i=0;i<Math.pow(2,n);i++) {
            res.add(i);
        }
        return res;
    }

}