package MinimumIndexSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        int minIndexSum = Integer.MAX_VALUE;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                if (map1.get(list2[i]) + i < minIndexSum) {
                    minIndexSum = map1.get(list2[i]) + i;
                    list = new ArrayList<String>();
                    list.add(list2[i]);
                } else if (map1.get(list2[i]) + i == minIndexSum) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[0]); // !!!!
    }
}
