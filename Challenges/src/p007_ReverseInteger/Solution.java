package p007_ReverseInteger;

class Solution {
    public int reverse(int x) {
        try {
            if (x > -10 && x < 10) {
                return x;
            }
            boolean positive = true;
            if (x < 0) {
                positive = false;
                x = -x;
            }
            String num = Integer.toString(x);
            StringBuffer sb = new StringBuffer();
            for (int i = num.length() - 1; i >= 0; i--) {
                sb.append(num.charAt(i));
            }
            if (positive) {
                return Integer.parseInt(sb.toString());
            } else {
                return -Integer.parseInt(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
