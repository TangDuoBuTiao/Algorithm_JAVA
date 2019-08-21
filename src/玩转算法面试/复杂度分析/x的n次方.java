package 玩转算法面试.复杂度分析;

/*
 * 时间复杂度：O(logn)
 */

public class x的n次方 {

    public static double pow(double x, int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double t = pow(x, n / 2);
        if (n % 2 != 0) {  //除2以后是奇数的话，需要再乘以一个x
            return x * t * t;
        }
        return t * t;
    }

    public static void main(String[] args) {
        System.out.println(pow(2.5, 5));
    }
}
