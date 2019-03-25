package 动态规划;

public class 爬楼梯 {

    public static int upStairs(int a) {
        /*
        F(n) = F(n-2) + F(n-1)
        递归慢，用动态规划 => 只需要记录前面两个值即可.
         */
        int tmp1 = 1, tmp2 = 2;
        if (a < 1) return 0;
        else if (a < 3) {
            return a;
        } else {
            int ans = 0;
            for (int i = 3; i <= a; i++) {
                ans = tmp1 + tmp2;
                tmp1 = tmp2;
                tmp2 = ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(upStairs(10));
    }
}
