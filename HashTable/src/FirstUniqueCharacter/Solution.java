package FirstUniqueCharacter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> once = new HashMap<>();
        HashSet<Character> twice = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(once.containsKey(s.charAt(i))){
                once.remove(s.charAt(i));
                twice.add(s.charAt(i));
            }else if(twice.contains(s.charAt(i))){
                continue;
            }else{
                once.put(s.charAt(i), i);
            }
        }
        if(once.isEmpty()){
            return -1;
        }
        Collection<Integer> c = once.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return (int)obj[0];
    }
}
