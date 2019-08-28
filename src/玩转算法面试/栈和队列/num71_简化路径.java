package 玩转算法面试.栈和队列;

import java.util.Stack;

public class num71_简化路径 {

    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    continue;
                }
            } else if (arr[i].equals("") || arr[i].equals(".")) {
                continue;
            } else {
                stack.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());  //每次都
            sb.insert(0, "/");
            }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "/../";
        System.out.println(simplifyPath(s));
    }
}
