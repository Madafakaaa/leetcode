package p085_MaximalRectangle;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        int[][][] dp = new int[matrix.length][matrix[0].length][2];
        int res = 0, temp;
        if(matrix[0][0]=='1'){
            dp[0][0][0] = 1;
            dp[0][0][1] = 1;
            res = 1;
        }
        for(int i=1;i< matrix.length;i++){
            if(matrix[i][0]=='1'){
                dp[i][0][0]=1+dp[i-1][0][0];
                dp[i][0][1]=1;
                res = Math.max(res,dp[i][0][0]*dp[i][0][1]);
            }
        }
        for(int i=1;i< matrix[0].length;i++){
            if(matrix[0][i]=='1'){
                dp[0][i][0]=1;
                dp[0][i][1]=1+dp[0][i-1][1];
                res = Math.max(res,dp[0][i][0]*dp[0][i][1]);
            }
        }
        for(int i=1;i< matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j][0]=1+dp[i-1][j][0];
                    dp[i][j][1]=1+dp[i][j-1][1];
                    res = Math.max(res,dp[i][j][0]*dp[i][j][i]);
                }
            }
        }
        return res;
    }

}