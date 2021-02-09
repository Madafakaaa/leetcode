package TwoSumIII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class TwoSum {

    List<Integer> list;

    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<Integer>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            if(set.contains(value-list.get(i))){
                return true;
            }
            set.add(list.get(i));
        }
        return false;
    }
}
