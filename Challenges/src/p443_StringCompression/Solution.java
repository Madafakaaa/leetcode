package p443_StringCompression;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * <p>
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * <p>
 * After you are done modifying the input array, return the new length of the array.
 * <p>
 * You must write an algorithm that uses only constant extra space.
 * <p>
 * Example 1:
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * Example 2:
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * Example 3:
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 * Example 4:
 * Input: chars = ["a","a","a","b","b","a","a"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
 * Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character.
 */
class Solution {
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        char tempChar = chars[0];
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == tempChar) {
                count++;
            } else {
                stringBuilder.append(tempChar);
                if (count > 1) {
                    stringBuilder.append(count);
                }
                count = 1;
                tempChar = chars[i];
            }
        }
        stringBuilder.append(tempChar);
        if (count > 1) {
            stringBuilder.append(count);
        }
        stringBuilder.append(count);
        String res = stringBuilder.toString();
        for (int i = 0; i < res.length(); i++) {
            chars[i] = res.charAt(i);
        }
        return stringBuilder.toString().length();
    }
}