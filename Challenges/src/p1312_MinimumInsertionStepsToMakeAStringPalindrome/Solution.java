package p1312_MinimumInsertionStepsToMakeAStringPalindrome;

/**
 * Given a string s. In one step you can insert any character at any index of the string.
 * <p>
 * Return the minimum number of steps to make s palindrome.
 * <p>
 * A Palindrome String is one that reads the same backward as well as forward.
 * <p>
 * Example 1:
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 * Example 2:
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * Example 3:
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 * Example 4:
 * Input: s = "g"
 * Output: 0
 * Example 5:
 * Input: s = "no"
 * Output: 1
 */
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int start = n - 1; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return n - dp[0][n - 1];
    }
}

/**
 * Here instead of using straight way of finding out how many inserts needed for making the String palindrome, we can use the opposite way, that is,
 * how many character needed to be deleted from the String to make it palindrome.
 * i.e: {original length of string } - {string length after all char is deleted} = deleted characters length = no of character we need to add.
 * The Algo is as follows:
 * We will start from the beginning of the sequence and keep adding one element at time.
 * At every step we will go through all the possible sequence and find the max Length that fulfills our palindrome condition.
 * There will be two pointers startIndex and endIndex of the string and we will select two option:
 * 1. if s[start] == s[end] then dp[start][end] = dp[start+1][end-1]
 * 2. else dp[start][end] will be MAX( dp[start+1][end] OR dp[start][end-1])
 * We will be using DP with Bottom up, so
 * Time Complexity= O(nxn) for 2 for loops
 * Space Complexity = O(nxn) for a 2d matrix for DP memorization
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * class Solution {
 * public int minInsertions(String s) {
 * //the max number is going to be the length of the string itself, since we can just concatenate its mirror image to generate a sure shot palindrome.
 * //checking if palindrome is straightforward.
 * //Apparently this is a DP as well. The hint is not intuitive at all. In fact, if you apply hint2 to "leetcode" we would see that "eee" is a longest palindromic subsequence and its length is 3, so
 * //we need to insert 5 (8-3) chars to make entire string a palindrome. This seems to be correct, except that the solution "leetcodocteel" also inserts an additional e, and "d" is the char
 * //that is not inserted, even though it was not part of the LPS. So that solution is just not intuitive.
 * //instead, lets try a more traditional intuition. That is if the chars at i and j match, then we can say that dp(i,j) = dp(i+1, j-1). Else, dp(i,j) = 1 + min(dp(i+1,j), dp(i,j-1)) since
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both.
 * //finally we return dp(0,n-1). We need to do outer loop from high to low.
 * <p>
 * //we should not need entire dp[n][n] array since the dp step only refers to one row below.
 * char [] sarr = s.toCharArray();
 * int [] dp = new int [sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * int prev = 0;
 * for(int j=i+1; j < sarr.length; j++) {
 * int bottomLeft = prev;
 * prev = dp[j];
 * if(sarr[i]==sarr[j]) {
 * dp[j] = bottomLeft;
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[j] = 1 + Math.min(dp[j], dp[j-1]); // here dp[j] in rhs is from i+1st row, where dp[j-1] is from this same row
 * }
 * }
 * }
 * <p>
 * return dp[sarr.length-1];
 * <p>
 * }
 * <p>
 * public int minInsertions2D(String s) {
 * //lets first use 2D dp to make it simpler
 * char [] sarr = s.toCharArray();
 * int [][] dp = new int [sarr.length][sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * for(int j=i+1; j < sarr.length; j++) {
 * if(sarr[i]==sarr[j]) {
 * dp[i][j] = dp[i+1][j-1];
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
 * }
 * }
 * }
 * <p>
 * return dp[0][sarr.length-1];
 * }
 * }
 * <p>
 * class Solution {
 * public int minInsertions(String s) {
 * //the max number is going to be the length of the string itself, since we can just concatenate its mirror image to generate a sure shot palindrome.
 * //checking if palindrome is straightforward.
 * //Apparently this is a DP as well. The hint is not intuitive at all. In fact, if you apply hint2 to "leetcode" we would see that "eee" is a longest palindromic subsequence and its length is 3, so
 * //we need to insert 5 (8-3) chars to make entire string a palindrome. This seems to be correct, except that the solution "leetcodocteel" also inserts an additional e, and "d" is the char
 * //that is not inserted, even though it was not part of the LPS. So that solution is just not intuitive.
 * //instead, lets try a more traditional intuition. That is if the chars at i and j match, then we can say that dp(i,j) = dp(i+1, j-1). Else, dp(i,j) = 1 + min(dp(i+1,j), dp(i,j-1)) since
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both.
 * //finally we return dp(0,n-1). We need to do outer loop from high to low.
 * <p>
 * //we should not need entire dp[n][n] array since the dp step only refers to one row below.
 * char [] sarr = s.toCharArray();
 * int [] dp = new int [sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * int prev = 0;
 * for(int j=i+1; j < sarr.length; j++) {
 * int bottomLeft = prev;
 * prev = dp[j];
 * if(sarr[i]==sarr[j]) {
 * dp[j] = bottomLeft;
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[j] = 1 + Math.min(dp[j], dp[j-1]); // here dp[j] in rhs is from i+1st row, where dp[j-1] is from this same row
 * }
 * }
 * }
 * <p>
 * return dp[sarr.length-1];
 * <p>
 * }
 * <p>
 * public int minInsertions2D(String s) {
 * //lets first use 2D dp to make it simpler
 * char [] sarr = s.toCharArray();
 * int [][] dp = new int [sarr.length][sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * for(int j=i+1; j < sarr.length; j++) {
 * if(sarr[i]==sarr[j]) {
 * dp[i][j] = dp[i+1][j-1];
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
 * }
 * }
 * }
 * <p>
 * return dp[0][sarr.length-1];
 * }
 * }
 * <p>
 * class Solution {
 * public int minInsertions(String s) {
 * //the max number is going to be the length of the string itself, since we can just concatenate its mirror image to generate a sure shot palindrome.
 * //checking if palindrome is straightforward.
 * //Apparently this is a DP as well. The hint is not intuitive at all. In fact, if you apply hint2 to "leetcode" we would see that "eee" is a longest palindromic subsequence and its length is 3, so
 * //we need to insert 5 (8-3) chars to make entire string a palindrome. This seems to be correct, except that the solution "leetcodocteel" also inserts an additional e, and "d" is the char
 * //that is not inserted, even though it was not part of the LPS. So that solution is just not intuitive.
 * //instead, lets try a more traditional intuition. That is if the chars at i and j match, then we can say that dp(i,j) = dp(i+1, j-1). Else, dp(i,j) = 1 + min(dp(i+1,j), dp(i,j-1)) since
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both.
 * //finally we return dp(0,n-1). We need to do outer loop from high to low.
 * <p>
 * //we should not need entire dp[n][n] array since the dp step only refers to one row below.
 * char [] sarr = s.toCharArray();
 * int [] dp = new int [sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * int prev = 0;
 * for(int j=i+1; j < sarr.length; j++) {
 * int bottomLeft = prev;
 * prev = dp[j];
 * if(sarr[i]==sarr[j]) {
 * dp[j] = bottomLeft;
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[j] = 1 + Math.min(dp[j], dp[j-1]); // here dp[j] in rhs is from i+1st row, where dp[j-1] is from this same row
 * }
 * }
 * }
 * <p>
 * return dp[sarr.length-1];
 * <p>
 * }
 * <p>
 * public int minInsertions2D(String s) {
 * //lets first use 2D dp to make it simpler
 * char [] sarr = s.toCharArray();
 * int [][] dp = new int [sarr.length][sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * for(int j=i+1; j < sarr.length; j++) {
 * if(sarr[i]==sarr[j]) {
 * dp[i][j] = dp[i+1][j-1];
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
 * }
 * }
 * }
 * <p>
 * return dp[0][sarr.length-1];
 * }
 * }
 * <p>
 * class Solution {
 * public int minInsertions(String s) {
 * //the max number is going to be the length of the string itself, since we can just concatenate its mirror image to generate a sure shot palindrome.
 * //checking if palindrome is straightforward.
 * //Apparently this is a DP as well. The hint is not intuitive at all. In fact, if you apply hint2 to "leetcode" we would see that "eee" is a longest palindromic subsequence and its length is 3, so
 * //we need to insert 5 (8-3) chars to make entire string a palindrome. This seems to be correct, except that the solution "leetcodocteel" also inserts an additional e, and "d" is the char
 * //that is not inserted, even though it was not part of the LPS. So that solution is just not intuitive.
 * //instead, lets try a more traditional intuition. That is if the chars at i and j match, then we can say that dp(i,j) = dp(i+1, j-1). Else, dp(i,j) = 1 + min(dp(i+1,j), dp(i,j-1)) since
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both.
 * //finally we return dp(0,n-1). We need to do outer loop from high to low.
 * <p>
 * //we should not need entire dp[n][n] array since the dp step only refers to one row below.
 * char [] sarr = s.toCharArray();
 * int [] dp = new int [sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * int prev = 0;
 * for(int j=i+1; j < sarr.length; j++) {
 * int bottomLeft = prev;
 * prev = dp[j];
 * if(sarr[i]==sarr[j]) {
 * dp[j] = bottomLeft;
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[j] = 1 + Math.min(dp[j], dp[j-1]); // here dp[j] in rhs is from i+1st row, where dp[j-1] is from this same row
 * }
 * }
 * }
 * <p>
 * return dp[sarr.length-1];
 * <p>
 * }
 * <p>
 * public int minInsertions2D(String s) {
 * //lets first use 2D dp to make it simpler
 * char [] sarr = s.toCharArray();
 * int [][] dp = new int [sarr.length][sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * for(int j=i+1; j < sarr.length; j++) {
 * if(sarr[i]==sarr[j]) {
 * dp[i][j] = dp[i+1][j-1];
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
 * }
 * }
 * }
 * <p>
 * return dp[0][sarr.length-1];
 * }
 * }
 * <p>
 * class Solution {
 * public int minInsertions(String s) {
 * //the max number is going to be the length of the string itself, since we can just concatenate its mirror image to generate a sure shot palindrome.
 * //checking if palindrome is straightforward.
 * //Apparently this is a DP as well. The hint is not intuitive at all. In fact, if you apply hint2 to "leetcode" we would see that "eee" is a longest palindromic subsequence and its length is 3, so
 * //we need to insert 5 (8-3) chars to make entire string a palindrome. This seems to be correct, except that the solution "leetcodocteel" also inserts an additional e, and "d" is the char
 * //that is not inserted, even though it was not part of the LPS. So that solution is just not intuitive.
 * //instead, lets try a more traditional intuition. That is if the chars at i and j match, then we can say that dp(i,j) = dp(i+1, j-1). Else, dp(i,j) = 1 + min(dp(i+1,j), dp(i,j-1)) since
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both.
 * //finally we return dp(0,n-1). We need to do outer loop from high to low.
 * <p>
 * //we should not need entire dp[n][n] array since the dp step only refers to one row below.
 * char [] sarr = s.toCharArray();
 * int [] dp = new int [sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * int prev = 0;
 * for(int j=i+1; j < sarr.length; j++) {
 * int bottomLeft = prev;
 * prev = dp[j];
 * if(sarr[i]==sarr[j]) {
 * dp[j] = bottomLeft;
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[j] = 1 + Math.min(dp[j], dp[j-1]); // here dp[j] in rhs is from i+1st row, where dp[j-1] is from this same row
 * }
 * }
 * }
 * <p>
 * return dp[sarr.length-1];
 * <p>
 * }
 * <p>
 * public int minInsertions2D(String s) {
 * //lets first use 2D dp to make it simpler
 * char [] sarr = s.toCharArray();
 * int [][] dp = new int [sarr.length][sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * for(int j=i+1; j < sarr.length; j++) {
 * if(sarr[i]==sarr[j]) {
 * dp[i][j] = dp[i+1][j-1];
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
 * }
 * }
 * }
 * <p>
 * return dp[0][sarr.length-1];
 * }
 * }
 * <p>
 * class Solution {
 * public int minInsertions(String s) {
 * //the max number is going to be the length of the string itself, since we can just concatenate its mirror image to generate a sure shot palindrome.
 * //checking if palindrome is straightforward.
 * //Apparently this is a DP as well. The hint is not intuitive at all. In fact, if you apply hint2 to "leetcode" we would see that "eee" is a longest palindromic subsequence and its length is 3, so
 * //we need to insert 5 (8-3) chars to make entire string a palindrome. This seems to be correct, except that the solution "leetcodocteel" also inserts an additional e, and "d" is the char
 * //that is not inserted, even though it was not part of the LPS. So that solution is just not intuitive.
 * //instead, lets try a more traditional intuition. That is if the chars at i and j match, then we can say that dp(i,j) = dp(i+1, j-1). Else, dp(i,j) = 1 + min(dp(i+1,j), dp(i,j-1)) since
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both.
 * //finally we return dp(0,n-1). We need to do outer loop from high to low.
 * <p>
 * //we should not need entire dp[n][n] array since the dp step only refers to one row below.
 * char [] sarr = s.toCharArray();
 * int [] dp = new int [sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * int prev = 0;
 * for(int j=i+1; j < sarr.length; j++) {
 * int bottomLeft = prev;
 * prev = dp[j];
 * if(sarr[i]==sarr[j]) {
 * dp[j] = bottomLeft;
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[j] = 1 + Math.min(dp[j], dp[j-1]); // here dp[j] in rhs is from i+1st row, where dp[j-1] is from this same row
 * }
 * }
 * }
 * <p>
 * return dp[sarr.length-1];
 * <p>
 * }
 * <p>
 * public int minInsertions2D(String s) {
 * //lets first use 2D dp to make it simpler
 * char [] sarr = s.toCharArray();
 * int [][] dp = new int [sarr.length][sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * for(int j=i+1; j < sarr.length; j++) {
 * if(sarr[i]==sarr[j]) {
 * dp[i][j] = dp[i+1][j-1];
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
 * }
 * }
 * }
 * <p>
 * return dp[0][sarr.length-1];
 * }
 * }
 * <p>
 * class Solution {
 * public int minInsertions(String s) {
 * //the max number is going to be the length of the string itself, since we can just concatenate its mirror image to generate a sure shot palindrome.
 * //checking if palindrome is straightforward.
 * //Apparently this is a DP as well. The hint is not intuitive at all. In fact, if you apply hint2 to "leetcode" we would see that "eee" is a longest palindromic subsequence and its length is 3, so
 * //we need to insert 5 (8-3) chars to make entire string a palindrome. This seems to be correct, except that the solution "leetcodocteel" also inserts an additional e, and "d" is the char
 * //that is not inserted, even though it was not part of the LPS. So that solution is just not intuitive.
 * //instead, lets try a more traditional intuition. That is if the chars at i and j match, then we can say that dp(i,j) = dp(i+1, j-1). Else, dp(i,j) = 1 + min(dp(i+1,j), dp(i,j-1)) since
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both.
 * //finally we return dp(0,n-1). We need to do outer loop from high to low.
 * <p>
 * //we should not need entire dp[n][n] array since the dp step only refers to one row below.
 * char [] sarr = s.toCharArray();
 * int [] dp = new int [sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * int prev = 0;
 * for(int j=i+1; j < sarr.length; j++) {
 * int bottomLeft = prev;
 * prev = dp[j];
 * if(sarr[i]==sarr[j]) {
 * dp[j] = bottomLeft;
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[j] = 1 + Math.min(dp[j], dp[j-1]); // here dp[j] in rhs is from i+1st row, where dp[j-1] is from this same row
 * }
 * }
 * }
 * <p>
 * return dp[sarr.length-1];
 * <p>
 * }
 * <p>
 * public int minInsertions2D(String s) {
 * //lets first use 2D dp to make it simpler
 * char [] sarr = s.toCharArray();
 * int [][] dp = new int [sarr.length][sarr.length];
 * <p>
 * for(int i = sarr.length-1; i>=0; i--) {
 * for(int j=i+1; j < sarr.length; j++) {
 * if(sarr[i]==sarr[j]) {
 * dp[i][j] = dp[i+1][j-1];
 * } else {
 * //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 * dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
 * }
 * }
 * }
 * <p>
 * return dp[0][sarr.length-1];
 * }
 * }
 */


/**
 * class Solution {
 *     public int minInsertions(String s) {
 *         //the max number is going to be the length of the string itself, since we can just concatenate its mirror image to generate a sure shot palindrome.
 *         //checking if palindrome is straightforward.
 *         //Apparently this is a DP as well. The hint is not intuitive at all. In fact, if you apply hint2 to "leetcode" we would see that "eee" is a longest palindromic subsequence and its length is 3, so
 *         //we need to insert 5 (8-3) chars to make entire string a palindrome. This seems to be correct, except that the solution "leetcodocteel" also inserts an additional e, and "d" is the char
 *         //that is not inserted, even though it was not part of the LPS. So that solution is just not intuitive.
 *         //instead, lets try a more traditional intuition. That is if the chars at i and j match, then we can say that dp(i,j) = dp(i+1, j-1). Else, dp(i,j) = 1 + min(dp(i+1,j), dp(i,j-1)) since
 *         //we have to add at least either ith char or jth char to make whole string a palindrome, if not both.
 *         //finally we return dp(0,n-1). We need to do outer loop from high to low.
 *
 *         //we should not need entire dp[n][n] array since the dp step only refers to one row below.
 *         char [] sarr = s.toCharArray();
 *         int [] dp = new int [sarr.length];
 *
 *         for(int i = sarr.length-1; i>=0; i--) {
 *             int prev = 0;
 *             for(int j=i+1; j < sarr.length; j++) {
 *                 int bottomLeft = prev;
 *                 prev = dp[j];
 *                 if(sarr[i]==sarr[j]) {
 *                     dp[j] = bottomLeft;
 *                 } else {
 *                     //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 *                     dp[j] = 1 + Math.min(dp[j], dp[j-1]); // here dp[j] in rhs is from i+1st row, where dp[j-1] is from this same row
 *                 }
 *             }
 *         }
 *
 *         return dp[sarr.length-1];
 *
 *     }
 *
 *     public int minInsertions2D(String s) {
 *         //lets first use 2D dp to make it simpler
 *         char [] sarr = s.toCharArray();
 *         int [][] dp = new int [sarr.length][sarr.length];
 *
 *         for(int i = sarr.length-1; i>=0; i--) {
 *             for(int j=i+1; j < sarr.length; j++) {
 *                 if(sarr[i]==sarr[j]) {
 *                     dp[i][j] = dp[i+1][j-1];
 *                 } else {
 *                     //we have to add at least either ith char or jth char to make whole string a palindrome, if not both. So...
 *                     dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
 *                 }
 *             }
 *         }
 *
 *         return dp[0][sarr.length-1];
 *     }
 * }
 */
