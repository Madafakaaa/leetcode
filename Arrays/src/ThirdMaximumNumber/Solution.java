package ThirdMaximumNumber;

class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Integer firstMax = Integer.MIN_VALUE;
        Integer secondMax = Integer.MIN_VALUE;
        Integer thirdMax = null;
        for(int n : nums){
            if(n>firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = n;
            }else if(n>secondMax){
                if(n==firstMax) continue;
                thirdMax = secondMax;
                secondMax = n;
            }else if(n>thirdMax){
                if(n==firstMax) continue;
                if(n==secondMax) continue;
                thirdMax = n;
            }
        }
        if (thirdMax==null) {
            return firstMax;
        }
        return thirdMax;
    }
}
