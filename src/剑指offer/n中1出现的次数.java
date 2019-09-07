package 剑指offer;

public class n中1出现的次数 {
    //暴力方法
    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += getNum(i);
        }
        return ans;
    }

    public static int getNum(int m) {
        int res = 0;
        while (m != 0) {
            if (m % 10 == 1) {
                res++;
            }
            m = m / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }
}
