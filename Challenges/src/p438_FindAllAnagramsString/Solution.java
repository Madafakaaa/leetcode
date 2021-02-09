package p438_FindAllAnagramsString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length()==0||p.length()>s.length()) return res;
        int[] pCount = new int[26], sCount = new int[26];
        for(int i=0;i<p.length();i++){
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length()-p.length();i++){
            if(Arrays.equals(pCount,sCount)) res.add(i);
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+p.length())-'a']++;
        }
        if(Arrays.equals(pCount,sCount)) res.add(s.length()-p.length());
        return res;
    }

}