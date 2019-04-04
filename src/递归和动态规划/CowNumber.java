package 递归和动态规划;
/*
 *农场中成熟的母牛每年只会生出一头小母牛，并且永远都不会死。第一年农场有一只成熟的母牛，从第二年开始，母牛开始生小牛
 * 每只小母牛3年之后成熟又可以生小母牛。
 * 给定整数N，求出N年后牛的数量
 */

public class CowNumber {
    //递归 c(n) = c(n-1) + c(n-3)   c(n-1)是n-1年的牛正常活到n年，c(n-3)是n-3年的牛都会生出n-3个牛
    public int cowNumberRecur(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return cowNumberRecur(n - 3) + cowNumberRecur(n);
    }

    //动态规划
    public int cowNumberDp(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int ans = 0;
        int tmp1 = 1;
        int tmp2 = 2;
        int tmp3 = 3;
        for (int i = 4; i <= n; i++) {
            ans = tmp1 + tmp3;
            tmp1 = tmp2;
            tmp2 = tmp3;
            tmp3 = ans;
        }
        return ans;

    }

    public static void main(String[] args){
        CowNumber c = new  CowNumber();
        System.out.println(c.cowNumberDp(6));
    }

}
