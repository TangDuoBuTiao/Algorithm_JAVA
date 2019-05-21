package 剑指offer;
/*
 * 解法： 把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变为0，那么一个整数的二进制中有多少个1，就
 *       可以进行多少次这样的运算。
 */

public class 二进制中1的个数 {
    public static int numberOf1(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(9));
    }
}
