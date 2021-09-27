package p912_SortAnArray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/26 18:40
 */
class QuickSort {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        // if the start index is larger or equal to the end index, the sort of the subarray is finished
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        // recursively sort the subarray
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    /**
     * This function takes last element as pivot, places the pivot element at its correct position in sorted array,
     * and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
     **/
    public int partition(int[] nums, int start, int end) {
        // choose the number in the middle as the base and swap it with the first number in the subarray
        swap(nums, start, start + (end - start) / 2);
        int base = nums[start];
        // swap every number that is less than the base to the front of the subarray
        int i = start + 1;
        int j = i;
        while (i <= end) {
            if (nums[i] < base) {
                swap(nums, i, j++);
            }
            i++;
        }
        // after the iteration the numbers from index start+1 to index j-1 are less than the base
        // swap the number on index j-1 with the base
        // the first j-2 numbers are less than the base
        // the number on index j-1 is the base
        // numbers after index j-1 are larger or equal to the base
        swap(nums, j - 1, start);
        return j - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
