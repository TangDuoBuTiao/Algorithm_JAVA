package 剑指offer;

public class 裴波那契数列 {
    public static int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int tmp1 = 0;
        int tmp2 = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = tmp1 + tmp2;
            tmp1 = tmp2;
            tmp2 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
    }
}
