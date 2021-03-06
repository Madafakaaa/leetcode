package p026_RemoveDuplicatesFromSortedArray;

class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int res = 1;
        for (int i = 1; i < nums.length; i++) if (nums[i] != nums[i - 1]) nums[res++] = nums[i];
        return res;
    }

}