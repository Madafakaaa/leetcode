package TopKFrequentElements;

import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> frequent = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            frequent.put(nums[i], frequent.getOrDefault(nums[i], 0)+1 );
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(frequent.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(int i=0;i<k;i++){
            result[i] = list.get(i).getKey();
        }
        return result;
    }

}
