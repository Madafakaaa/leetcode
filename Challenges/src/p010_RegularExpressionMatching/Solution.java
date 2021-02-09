package p010_RegularExpressionMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pat = Pattern.compile(p);
        Matcher mat = pat.matcher(s);
        try{
            while(mat.find()){
                if(mat.group().equals(s)) return true;
            }
        }
        catch(IllegalStateException e){
            return false;
        }
        return false;
    }

    public boolean isMatch2(String s, String p) {
        return s.matches(p);
    }
}