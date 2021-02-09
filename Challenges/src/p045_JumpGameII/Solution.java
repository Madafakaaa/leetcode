package p045_JumpGameII;

class Solution {

    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int res = 0;
        int temp = 0;
        while(temp+nums[temp]<nums.length-1){
            if(nums[temp]==0) return 0;
            int maxJump = temp+1+nums[temp+1];
            int nextIndex = temp+1;
            for(int i=temp+2;i<=temp+nums[temp];i++){
                if(i+nums[i]>maxJump){
                    maxJump = i+nums[i];
                    nextIndex = i;
                }
            }
            temp = nextIndex;
            res++;
        }
        return res+1;
    }

}