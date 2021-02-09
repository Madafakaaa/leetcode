package ReplaceElements;

class Solution {

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i=arr.length-1;i>=0;i--){
            int tempMax = max;
            if(arr[i]>tempMax){
                tempMax = arr[i];
            }
            arr[i] = max;
            max = tempMax;
        }
        return arr;
    }

}