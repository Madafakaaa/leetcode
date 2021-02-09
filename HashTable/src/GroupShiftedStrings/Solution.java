package GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String key = getPattern(strings[i]);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strings[i]);
        }
        return new ArrayList<>(map.values());
    }

    public String getPattern(String str){
        StringBuffer result = new StringBuffer("0");
        for(int i=1;i<str.length();i++){
            result.append('-');
            result.append((str.charAt(i)-str.charAt(i-1)+26)%26);
        }
        return result.toString();
    }
}