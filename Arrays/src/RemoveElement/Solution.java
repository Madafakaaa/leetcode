package RemoveElement;

class Solution {

    public int removeElement(int[] nums, int val) {
        int[] temp = new int[nums.length];
        int result = 0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=val){
                temp[result] = nums[i];
                result++;
            }
        }
        for(int i=0;i< result;i++){
            nums[i] = temp[i];
        }
        return result;
    }

}
