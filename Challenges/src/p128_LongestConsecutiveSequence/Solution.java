package p128_LongestConsecutiveSequence;

import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int res=0,temp=1;
        for(int i=0;i<nums.length-1;i++){
            if (nums[i] != nums[i+1]) {
                if (nums[i] + 1 == nums[i + 1]) {
                    temp++;
                } else {
                    res = Math.max(res, temp);
                    temp = 1;
                }
            }
        }
        return Math.max(res,temp);
    }
}