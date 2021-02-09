package p072_EditDistance;

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;i++) dp[i][0]=i;
        for(int i=0;i<word2.length()+1;i++) dp[0][i]=i;
        for(int i=1;i<word1.length()+1;i++){
            for(int j=1;j<word2.length()+1;j++){
                int down = dp[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)) down++;
                dp[i][j] = Math.min(down, Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
            }
        }
        return  dp[word1.length()][word2.length()];
    }
}