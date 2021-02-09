package FindMinimumInRotatedSortedArray;

class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int left = 0, right = nums.length-1;
        if (nums[left] < nums[right])
            return nums[0];

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return nums[pivot + 1];
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return nums[0];
    }
}