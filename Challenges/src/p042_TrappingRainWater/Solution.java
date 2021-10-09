package p042_TrappingRainWater;

class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int tempMax = 0;
        for (int i = 0; i < height.length; i++) {
            tempMax = Math.max(tempMax, height[i]);
            leftMax[i] = tempMax;
        }
        tempMax = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            tempMax = Math.max(tempMax, height[i]);
            rightMax[i] = tempMax;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}
