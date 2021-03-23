package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String sortedStr = sortStr(strs[i]);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(strs[i]);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(sortedStr, newList);
                // map.getOrDefault() !!!!!
            }
        }
        return new ArrayList<>(map.values());
    }

    public String sortStr(String string) {
        char[] arrayCh = string.toCharArray();
        Arrays.sort(arrayCh);
        return Arrays.toString(arrayCh);
    }
}
