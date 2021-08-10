package p011_ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0, temp = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                temp = height[left];
                while (height[left] <= temp && left < height.length - 1) {
                    left++;
                }
            } else {
                temp = height[right];
                while (height[right] <= temp && right > 0) {
                    right--;
                }
            }
        }
        return res;
    }
}
