package 玩转算法面试.复杂度分析;
/*
 * 时间复杂度:O(sqrt(N))
 * 解释：为什么判断素数只需要判断到根号n, 因为如何存在a*b=n,那么a和b两个数必有一个小于等于根号n, 一个大于等于根号n
 */

public class 判断素数 {

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(isPrime(42));
    }
}
