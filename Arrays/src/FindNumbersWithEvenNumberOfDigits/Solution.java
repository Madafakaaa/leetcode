package FindNumbersWithEvenNumberOfDigits;

class Solution {

    public int findNumbers(int[] nums) {
        int result = 0;
        for(int n : nums){
            result += isEven(n);
        }
        return result;
    }

    public int isEven(int num){
        String str = Integer.toString(num);
        if(str.length()%2==0){
            return 1;
        }
        return 0;
    }

}