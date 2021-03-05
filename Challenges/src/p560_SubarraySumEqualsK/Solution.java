package p560_SubarraySumEqualsK;

class Solution {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) res++;
            }
        }
        return res;
    }

}