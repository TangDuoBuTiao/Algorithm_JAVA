package leetcode;
/*
 * 《整数反转》
 * Eg: 123 -> 321 ;  -123 -> -321 ;  120 -> 21 ;
 * 反转后溢出就返回0
 */

public class num7 {
    public static int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(15342));
    }
}
