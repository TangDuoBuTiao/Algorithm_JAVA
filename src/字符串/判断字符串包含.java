package 字符串;

public class 判断字符串包含 {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "bf";
        System.out.println(isContain(str1, str2));
    }

    //判断s1是否包含s2, null也算包含
    public static boolean isContain(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int i = 0;
        while (i < c1.length) {
            int cur = i;
            int j = 0;
            while (j < c2.length && cur < c1.length) {
                if (c2[j] == c1[cur]) {
                    cur++;
                    j++;
                } else {
                    i++;
                    break;
                }
            }
            if (j == c2.length) {
                return true;
            }
        }
        return false;
    }
}
