package p1678_GoalParserInterpretation;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/17 9:31
 */
class Solution {
    public String interpret(String command) {
        String res = command.replace("(al)", "al").replace("()", "o");
        return res;
    }
}