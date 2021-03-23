package LargestNumber;

class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int largest = 0, secondLargest = 0;
        int largestIndex = 0, secondLargestIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
                largestIndex = i;
            } else if (nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }
        if (largest != secondLargest && largest >= 2 * secondLargest) {
            return largestIndex;
        }
        return -1;
    }
}