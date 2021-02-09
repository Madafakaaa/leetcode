package IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet set1 = new HashSet();
        HashSet set2 = new HashSet();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }
        Iterator ite = set2.iterator();
        ArrayList intersection = new ArrayList();
        while(ite.hasNext()){
            int temp = (int)ite.next();
            if(set1.contains(temp)){
                intersection.add(temp);
            }
        }
        int[] result = new int[intersection.size()];
        for(int i=0;i<intersection.size();i++){
            result[i] = (int)intersection.get(i);
        }
        return result;
    }
}
