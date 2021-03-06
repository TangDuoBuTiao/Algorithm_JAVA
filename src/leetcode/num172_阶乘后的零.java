package leetcode;
/*    《阶乘后的零》
 * 问题： 给定一个整数n, 返回n!结果尾数中零的数量
 */

public class num172_阶乘后的零 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        num172_阶乘后的零 num = new num172_阶乘后的零();
        System.out.println(num.trailingZeroes(25));
    }
}
