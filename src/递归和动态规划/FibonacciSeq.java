package 递归和动态规划;
/*
 给定整数n，返回裴波那契数列的第N项
 */

public class FibonacciSeq {

    //递归解法，时间复杂度O(N^2)
    public int fibRecur(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return fibRecur(n - 2) + fibRecur(n - 1);
    }

    //动态规划解法，时间复杂度O(N)
    public int fibDp(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int tmp1 = 1;
        int tmp2 = 2;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans = tmp1 + tmp2;
            tmp1 = tmp2;
            tmp2 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        FibonacciSeq f = new FibonacciSeq();
        System.out.println(f.fibDp(7));
    }
}
