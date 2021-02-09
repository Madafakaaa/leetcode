package p076_MinimumWindowSubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0||t.length()>s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        int[] count = new int[t.length()];
        int cNum=0;
        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                map.putIfAbsent(c, cNum);
                count[cNum] = 1;
                cNum++;
            }else{
                count[map.get(c)]++;
            }
        }
        int left = 0, right = 0, minLength = s.length();
        String res = null;
        while(right<s.length()-2){
            if(Arrays.stream(count).sum()==0){ // contains all characters
                if(map.containsKey(t.charAt(left))) count[map.get(t.charAt(left))]++;
                left++;
                if(right-left<minLength){
                    minLength = right-left;
                    res = s.substring(left,right);
                }
            }else{ // does not contain all characters
                right++;
                if(map.containsKey(t.charAt(right))) count[map.get(t.charAt(right))]--;
            }
        }
        return res;
    }
}