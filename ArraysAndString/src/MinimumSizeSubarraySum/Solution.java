package MinimumSizeSubarraySum;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            int index = i;
            while(sum<s&&index<nums.length){
                sum += nums[index];
                index++;
            }
            if(sum>=s&&(index-i)<min){
                min = (index-i);
            }
        }
        if(min>0&&min!=Integer.MAX_VALUE){
            return min;
        }
        return 0;
    }
}