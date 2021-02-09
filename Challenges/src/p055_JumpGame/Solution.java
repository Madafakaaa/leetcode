package p055_JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        if(nums[0]==0) return false;
        int res = 0;
        int temp = 0;
        while(temp+nums[temp]<nums.length){
            int maxJump = 0;
            int nextIndex = 0;
            for(int i=temp+1;i<=temp+nums[temp];i++){
                if(i+nums[i]>maxJump){
                    maxJump = i+nums[i];
                    nextIndex = i;
                }
            }
            if(maxJump==0) return false;
            temp = nextIndex;
            res++;
        }
        return true;
    }
}