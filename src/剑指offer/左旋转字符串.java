package 剑指offer;

public class 左旋转字符串 {

    public static String LeftRotateString(String str, int n) {
        n = n % str.length();
        String res = str.substring(0, n);
        return (str + res).substring(n, n + str.length());
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcqweasd", 3));
    }
}
