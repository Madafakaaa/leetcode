package p763_PartitionLabels;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for(int i=0;i<S.length();i++) lastIndex[S.charAt(i)-'a']=i;
        int last = 0, prevLast=0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            last = Math.max(last,lastIndex[S.charAt(i)-'a']);
            if(last == i){
                res.add(i-prevLast+1);
                prevLast = i+1;
            }
        }
        return res;
    }

}