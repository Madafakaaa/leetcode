package p033_SearchInRotatedSortedArray;

class Solution {

    public int search(int[] nums, int target) {
        int rotateIndex = findRotateIndex(nums);
        int left = 0, right = rotateIndex-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        left = rotateIndex;
        right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }

    public int findRotateIndex(int[] nums){
        int left = 0, right = nums.length-1;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(nums[mid]>=nums[0]){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(right==nums.length-1&&nums[right]>=nums[0]) return 0;
        return right;
    }

}