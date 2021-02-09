package p139_WordBreak;

import java.util.List;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<=s.length();i++) if(dp[i]) for(String w : wordDict) if(s.length()>=(i+w.length())&&s.substring(i,i+w.length()).equals(w)) dp[i+w.length()]=true;
        return dp[s.length()];
    }

}