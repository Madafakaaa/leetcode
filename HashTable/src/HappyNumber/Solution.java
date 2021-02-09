package HappyNumber;

import java.util.HashSet;

class Solution {

    public boolean isHappy(int n) {
        HashSet<Integer> nums = new HashSet<>();
        while(true){
            if(nums.contains(n)){
                return false;
            }
            nums.add(n);
            if(n==1){
                return true;
            }
            n = calculate(n);
        }
    }

    public int calculate(int n){
        int sum = 0;
        while (n != 0) {
            int t = n % 10;
            n = n / 10;
            sum += t * t;
        }
        return sum;
    }
}