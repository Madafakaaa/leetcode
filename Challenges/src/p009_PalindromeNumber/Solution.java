package p009_PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int ori = x;
        int res = 0;
        while (x != 0) {
            int temp = res;
            res = 10 * res + x % 10;
            if (res / 10 != temp) {
                return false;
            }
            x /= 10;
        }
        return res == ori;
    }
}
