package p912_SortAnArray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/27 12:23
 */
public class SelectionSort {

    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int[] res = new int[nums.length];
        Integer size = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[size];
            int minIndex = size;
            for (int j = nums.length - 1; j > size; j--) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            res[size] = min;
            swap(nums, minIndex, size);
            size++;
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
