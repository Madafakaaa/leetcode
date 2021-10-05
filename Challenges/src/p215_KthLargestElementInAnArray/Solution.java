package p215_KthLargestElementInAnArray;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    public int quickSort(int[] nums, int start, int end, int k) {
        swap(nums, end, start + (end - start) / 2);
        int base = nums[end];
        int i = start;
        int j = start;
        while (i < end) {
            if (nums[i] > base) {
                swap(nums, i, j++);
            }
            i++;
        }
        if (j + 1 == k) {
            return base;
        }
        swap(nums, j, end);
        if (j + 1 < k) {
            return quickSort(nums, j + 1, end, k);
        } else {
            return quickSort(nums, start, j - 1, k);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
