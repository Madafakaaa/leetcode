package p912_SortAnArray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/26 18:40
 */
class BubbleSort {

    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
