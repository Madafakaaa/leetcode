package p041_FirstMissingPositive;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] check = new int[nums.length + 1];
        for (int i : nums) if (i > 0 && i <= nums.length) check[i] = 1;
        for (int i = 1; i < nums.length + 1; i++) if (check[i] == 0) return i;
        return nums.length + 1;
    }
}