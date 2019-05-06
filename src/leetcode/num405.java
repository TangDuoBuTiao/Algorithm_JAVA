package leetcode;
/*
 * 《数字转换为十六进制数》
 */
public class num405 {
    public static String toHex(int num) {
        String ans = "";
        if (num > 0) {
            ans = posNumtoHex(num);
        } else if (num < 0) {
            if (num == -1) {
                return "ffffffff";
            }
            String neg1 = "ffffffff";
            String sub = posNumtoHex(Math.abs(num + 1));
            String str = "";
            int res = 0;
            for (int i = 0; i < sub.length(); i++) {
                if (Character.isDigit(sub.charAt(i))) {
                    res = 15 - (Integer.valueOf(sub.charAt(i)) - 48);
                } else {
                    res = neg1.charAt(8 - sub.length() + i) - sub.charAt(i);
                }
                str += posNumtoHex(res);
            }
            ans = neg1.substring(0, 8 - sub.length()) + str;
        } else {
            return String.valueOf(0);
        }
        return ans;
    }

    public static String posNumtoHex(int num) {   //非负数转十六进制
        if (num == 0) {
            return String.valueOf(0);
        }
        StringBuilder sb = new StringBuilder(8);
        String ans;
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0) {
            sb = sb.append(b[num % 16]);
            num = num / 16;
        }
        ans = sb.reverse().toString();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(toHex(88));
    }
}
