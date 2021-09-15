package 剑指Offer.剑指Offer11_旋转数组的最小数字;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 14:20
 */
class Solution {


    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

}
