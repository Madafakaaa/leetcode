package p912_SortAnArray;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/26 18:40
 */
class HeapSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            heapify(nums, i, nums.length - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, nums.length - 1 - i);
            heapify(nums, 0, nums.length - 2 - i);
        }
    }

    private void heapify(int[] nums, int start, int end) {
        while (start <= end) {
            int l = 2 * start + 1;
            int r = 2 * start + 2;
            int maxIndex = start;
            if (l <= end && nums[l] > nums[maxIndex]) {
                maxIndex = l;
            }
            if (r <= end && nums[r] > nums[maxIndex]) {
                maxIndex = r;
            }
            if (maxIndex == start) {
                return;
            }
            swap(nums, start, maxIndex);
            start = maxIndex;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
























