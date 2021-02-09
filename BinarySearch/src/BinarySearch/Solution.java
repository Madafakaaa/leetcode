package BinarySearch;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = (left+right)/2;
        while(left<right-2){
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid;
                mid = (left+right)/2;
            }else{
                right = mid;
                mid = (left+right)/2;
            }
        }
        for(int i=left;i<=right;i++){
            if(nums[i]==target) return i;
        }
        return -1;
    }
}