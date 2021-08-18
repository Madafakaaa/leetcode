package p171_ExcelSheetColumnNumber;

/**
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * Example 1:
 * Input: columnTitle = "A"
 * Output: 1
 * <p>
 * Example 2:
 * Input: columnTitle = "AB"
 * Output: 28
 * <p>
 * Example 3:
 * Input: columnTitle = "ZY"
 * Output: 701
 * <p>
 * Example 4:
 * Input: columnTitle = "FXSHRXW"
 * Output: 2147483647
 */
class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            res = res * 26 + c - 'A' + 1;
        }
        return res;
    }
}