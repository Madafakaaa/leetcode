package p042_TrappingRainWater;

class Solution {

    public int trap(int[] height) {
        if(height.length==0) return 0;
        int res = 0;
        int left = 0, right = height.length-1;
        int leftHeight = height[0], rightHeight = height[height.length-1];
        while(left<right){
            if(leftHeight<=rightHeight){
                left++;
                if(height[left]>leftHeight) leftHeight = height[left];
                res+=leftHeight-height[left];
            }else{
                right--;
                if(height[right]>rightHeight) rightHeight = height[right];
                res+=rightHeight-height[right];
            }
        }
        return res;
    }

}