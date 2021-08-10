package p004_MedianOfTwoSortedArrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2]) {
                nums[i1 + i2] = nums1[i1];
                i1++;
            } else {
                nums[i1 + i2] = nums2[i2];
                i2++;
            }
        }
        while (i1 < nums1.length) {
            nums[i1 + i2] = nums1[i1];
            i1++;
        }
        while (i2 < nums2.length) {
            nums[i1 + i2] = nums2[i2];
            i2++;
        }
        if (nums.length % 2 == 1) {
            return nums[(nums.length - 1) / 2];
        } else {
            return (double) (nums[(nums.length - 1) / 2] + nums[nums.length / 2]) / 2;
        }
    }

}

