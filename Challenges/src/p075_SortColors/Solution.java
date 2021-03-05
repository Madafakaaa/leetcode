package p075_SortColors;

class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 2 && nums[right] == 0) {
                nums[left] = 0;
                nums[right] = 2;
                left++;
                right--;
            } else if (nums[left] == 2) {
                right--;
            } else if (nums[right] == 0) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 1 && nums[right] == 0) {
                nums[left] = 0;
                nums[right] = 1;
                left++;
                right--;
            } else if (nums[left] == 1) {
                right--;
            } else if (nums[right] == 0) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 2 && nums[right] == 1) {
                nums[left] = 1;
                nums[right] = 2;
                left++;
                right--;
            } else if (nums[left] == 2) {
                right--;
            } else if (nums[right] == 1) {
                left++;
            } else {
                left++;
                right--;
            }
        }
    }
}