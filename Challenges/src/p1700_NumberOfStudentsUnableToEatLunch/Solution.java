package p1700_NumberOfStudentsUnableToEatLunch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/25 18:47
 */
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int student : students) {
            queue.add(student);
        }
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }
        outLoop:
        while (!stack.isEmpty() && !queue.isEmpty()) {
            Integer currSandwich = stack.pop();
            Integer studentSize = queue.size();
            for (int i = 0; i < studentSize; i++) {
                Integer currStudent = queue.poll();
                if (currStudent.equals(currSandwich)) {
                    continue outLoop;
                } else {
                    queue.add(currStudent);
                }
            }
            return queue.size();
        }
        return queue.size();
    }
}
