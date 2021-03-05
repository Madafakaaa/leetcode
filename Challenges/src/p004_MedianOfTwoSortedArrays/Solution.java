package p004_MedianOfTwoSortedArrays;

import java.util.ArrayList;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Double> nums = new ArrayList<Double>();
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                nums.add((double) nums1[index1]);
                index1++;
            } else {
                nums.add((double) nums2[index2]);
                index2++;
            }
        }
        while (index1 < nums1.length) {
            nums.add((double) nums1[index1]);
            index1++;
        }
        while (index2 < nums2.length) {
            nums.add((double) nums2[index2]);
            index2++;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return nums.get((nums1.length + nums2.length - 1) / 2);
        } else {
            return (nums.get((nums1.length + nums2.length) / 2 - 1) + nums.get((nums1.length + nums2.length) / 2)) / 2;
        }
    }

}

