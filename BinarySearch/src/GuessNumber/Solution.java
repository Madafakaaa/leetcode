package GuessNumber;

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        if (n == 1) return 1;
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2; //!!!!!
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}