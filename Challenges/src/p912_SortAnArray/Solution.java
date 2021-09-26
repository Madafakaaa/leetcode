package p912_SortAnArray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/26 18:40
 */
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        swap(nums, start, start + 2 * (end - start) / 3);
        int base = nums[start];
        int i = start + 1;
        int j = i;
        while (i <= end) {
            if (nums[i] < base) {
                swap(nums, i, j++);
            }
            i++;
        }
        swap(nums, j - 1, start);
        quickSort(nums, start, j - 2);
        quickSort(nums, j, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
