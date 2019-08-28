package 玩转算法面试.栈和队列;

import java.util.Stack;

public class num20_有效的括号 {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] sar = s.toCharArray();
        for(int i = 0; i < sar.length; i++){
            if(sar[i] == '(' || sar[i] == '[' || sar[i] == '{'){
                stack.push(sar[i]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char match;
                if(sar[i] == ')'){
                    match = '(';
                }else if(sar[i] == ']'){
                    match = '[';
                }else if(sar[i] == '}'){
                    match = '{';
                }else{
                    throw new RuntimeException("invalid input!");
                }
                if(match != stack.pop()){
                    return false;
                }
            }
        }
        return true;
    }
}
