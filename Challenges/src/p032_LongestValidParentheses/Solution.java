package p032_LongestValidParentheses;

class Solution {
    public int longestValidParentheses(String s) {
        int[] len = new int[s.length()];
        int res = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    len[i] = 2;
                    if(i>=2) len[i]+=len[i-2];
                }else if((i-len[i-1]-1)>=0&&s.charAt(i-len[i-1]-1)=='('){
                    len[i] = len[i-1] + 2;
                    if((i-len[i-1]-2)>=0) len[i]+=len[i-len[i-1]-2];
                }
            }
            if(len[i]>res) res = len[i];
        }
        return res;
    }
}