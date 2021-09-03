package p151_ReverseWordsInAString;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/2 23:30
 */
class Solution {
    // TC: O(N)
    // SC: O(N) -> Used for 2 StringBuilders...
    //      -> N = Total no. of chars in string...
    // Although there are two loops, the outer loop is only used for end condition.
    // Only the inner loops iterate over the chars...
    public String reverseWords(String s) {
        int end = s.length(), st = end - 1;
        StringBuilder rev = new StringBuilder();
        // Start iterating from end...
        while (st >= 0) {
            // Removing trailing spaces...
            while (end - 1 >= 0 && s.charAt(end - 1) == ' ')
                --end;

            // After trailing spaces are removed, start will be one position minus the end...
            st = end - 1;
            while (st >= 0 && s.charAt(st) != ' ')
                --st;

            // Append single space between the words...
            // rev.length() > 0 means there are words already in our result...
            // end > 0 is true only when there are more characters to be read...If there are leading spaces, then end will be equal to 0...
            rev.append(" ");

            // st + 1 to end is a word...So, iterate and append to result...
            int i = st + 1;
            while (i < end)
                rev.append(s.charAt(i++));

            end = st;
        }
        return rev.toString().trim();
    }
}

/**
 * class Solution
 * {
 * // TC: O(N)
 * // SC: O(N) -> Used for 2 StringBuilders...
 * //      -> N = Total no. of chars in string...
 * // Although there are two loops, the outer loop is only used for end condition.
 * // Only the inner loops iterate over the chars...
 * public String reverseWords(String s)
 * {
 * int end = s.length(), st = end - 1;
 * StringBuilder rev = new StringBuilder();
 * // Start iterating from end...
 * while(st >= 0)
 * {
 * // Removing trailing spaces...
 * while(end - 1 >= 0 && s.charAt(end - 1) == ' ')
 * --end;
 * <p>
 * // After trailing spaces are removed, start will be one position minus the end...
 * st = end - 1;
 * while(st >= 0 && s.charAt(st) != ' ')
 * --st;
 * <p>
 * // Append single space between the words...
 * // rev.length() > 0 means there are words already in our result...
 * // end > 0 is true only when there are more characters to be read...If there are leading spaces, then end will be equal to 0...
 * if(rev.length() > 0 && end > 0)
 * rev.append(" ");
 * <p>
 * // st + 1 to end is a word...So, iterate and append to result...
 * int i = st + 1;
 * while(i < end)
 * rev.append(s.charAt(i++));
 * <p>
 * end = st;
 * }
 * return rev.toString();
 * }
 * }
 */
