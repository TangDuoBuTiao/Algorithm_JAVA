package 递归和动态规划;
/*
 一次可以爬1层楼梯，也可以爬2层楼梯，求爬到第N层时有多少种爬法。
 */

public class 爬楼梯 {
    //递归方法求解
    public int cliRecur(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return cliRecur(n - 2) + cliRecur(n - 1);
    }

    //动态规划求解
    public int cliDp(int n) {
        if (n < 0) {
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

}
