package p027_RemoveElement;

class Solution {

    public int removeElement(int[] nums, int val) {
        if(nums.length<2) return nums.length;
        int res = 0;
        for(int i =0;i< nums.length;i++) if(nums[i]!=val) nums[res++] = nums[i];
        return res;
    }

}