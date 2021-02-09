package FindPivotIndex;

import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            leftSum[i]=sum;
        }
        for(int i=0;i< leftSum.length;i++){
            if(leftSum[i]-nums[i] == leftSum[leftSum.length-1]-leftSum[i]){
                return i;
            }
        }
        return -1;
    }
}