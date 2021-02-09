package p078_Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        add(new ArrayList<>(), new ArrayList<Integer>(nums));
        return res;
    }

    public void add(List<Integer> list,int[] nums){

    }

}