package MaxConsecutiveOnes;

class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = Integer.MIN_VALUE;
        int local = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                local++;
            }else{
                result = result > local ? result : local;
                local = 0;
            }
        }
        result = result > local ? result : local;
        return result;
    }

}
