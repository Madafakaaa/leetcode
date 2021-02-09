package DuplicateZeros;

class Solution {

    public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length];
        int tempIndex = 0;
        for(int i=0;i<arr.length&&tempIndex<arr.length;i++){
            if(arr[i]==0){
                temp[tempIndex]=0;
                tempIndex++;
                if(tempIndex<arr.length){
                    temp[tempIndex]=0;
                }
                tempIndex++;
            }else{
                temp[tempIndex] = arr[i];
                tempIndex++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = temp[i];
        }
    }

}