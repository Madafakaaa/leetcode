package MergeSortedArray;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m+n];
        int mIndex=0, nIndex=0;
        while(mIndex<m&&nIndex<n){
            if(nums1[mIndex]<nums2[nIndex]){
                merged[mIndex+nIndex] = nums1[mIndex];
                mIndex++;
            }else{
                merged[mIndex+nIndex] = nums2[nIndex];
                nIndex++;
            }
        }
        while(mIndex<m){
            merged[mIndex+nIndex] = nums1[mIndex];
            mIndex++;
        }
        while(nIndex<n){
            merged[mIndex+nIndex] = nums2[nIndex];
            nIndex++;
        }
        for(int i=0;i<m+n;i++){
            nums1[i] = merged[i];
        }
    }

}