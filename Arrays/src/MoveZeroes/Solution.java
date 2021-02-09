package MoveZeroes;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;
        for(int read=0;read<nums.length;read++){
            if(nums[read]==0) continue;
            nums[write] = nums[read];
            write++;
        }
        for(int i=write;i< nums.length;i++){
            nums[i] = 0;
        }
    }
}
