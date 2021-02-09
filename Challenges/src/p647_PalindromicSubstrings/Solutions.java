package p647_PalindromicSubstrings;

class Solution {

    public static int res=0;

    public int countSubstrings(String s) {
        for(int i=0;i<s.length()-1;i++){
            count(s,i,i);
            count(s,i,i+1);
        }
        return res+1;
    }

    public void count(String s, int left, int right){
        if(left<0||right>=s.length()) return;
        if(s.charAt(left)==s.charAt(right)){
            res++;
            count(s,left-1,right+1);
        }
    }
}