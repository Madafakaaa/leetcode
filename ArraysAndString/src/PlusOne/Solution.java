package PlusOne;

class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        int extra = 1;
        for(int i = digits.length-1;i>=0;i--){
            result[i] = (digits[i]+extra)%10;
            extra = (digits[i]+extra)/10;
        }
        if(extra==1){
            int[] extraResult = new int[digits.length+1];
            extraResult[0] = 1;
            for(int i=0;i<digits.length;i++){
                extraResult[i+1] = result[i];
            }
            return extraResult;
        }
        return result;
    }
}
