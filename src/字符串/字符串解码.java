package 字符串;

import java.util.Stack;

public class 字符串解码 {
    public static String decodeString(String s) {
        String ans = null;
        int number = 1;   //倍数
        boolean flag = false;
        Stack<Integer> num = new Stack<>();
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num.push(Integer.valueOf(String.valueOf(s.charAt(i))));
            } else {
                st.push(String.valueOf(s.charAt(i)));
            }
        }
        if (num.empty()) {
            return s;
        } else {
            String c = null;
            String str = null;
            while (!st.empty()) {
                number = num.pop();
                if (st.peek() != "]" && st.peek() != "[") {
                    while (st.pop() == "[") {
                        c += st.pop();
                    }
                    for (int i = 0; i < number; i++) {
                        str += c;
                    }
                    ans += str;
                }
                st.pop();
            }

        }
        return ans;
    }

    public static void main(String args[]) {
        String a = "3[a]2[bc]";
        System.out.println(decodeString(a));
    }
}
