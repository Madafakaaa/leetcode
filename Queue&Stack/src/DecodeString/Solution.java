package DecodeString;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if((int)c==(int)']'){
                StringBuilder tempSb = new StringBuilder();
                while(stack.peek()!='['){
                    tempSb.append(stack.pop());
                }
                stack.pop(); // pop [
                int digit = 1;
                int times = 0;
                while(!stack.empty()&&(int)stack.peek()>=(int)'0'&&(int)stack.peek()<=(int)'9'){
                    times += digit*((int)stack.pop()-(int)'0');
                    digit *= 10;
                }
                StringBuilder newSb = new StringBuilder();
                tempSb = tempSb.reverse();
                for(int i=0;i<times;i++){
                    newSb = newSb.append(tempSb);
                }
                char[] newChars = newSb.toString().toCharArray();
                for(char t_c : newChars){
                    stack.push(t_c);
                }
            }else{
                stack.push(c);
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}