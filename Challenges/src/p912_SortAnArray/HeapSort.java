package p912_SortAnArray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/26 18:40
 */
class HeapSort {

    public int[] sortArray(int[] nums) {
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
