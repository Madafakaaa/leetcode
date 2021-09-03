package p186_ReverseWordsInAStringII;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/3 11:20
 */
class Solution {

    char[] s;

    public void reverseWords(char[] s) {
        this.s = s;
        reverse(0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(start, i - 1);
                start = i + 1;
            }
        }
        reverse(start, s.length - 1);
    }

    public void reverse(int start, int end) {
        Character temp = null;
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

}
