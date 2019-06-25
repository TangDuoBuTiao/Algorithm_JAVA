package 校招真题2018.爱奇艺;
/*
 问题描述：牛牛选择了一个正整数X,然后把它写在黑板上。然后每一天他会擦掉当前数字的最后一位,直到他擦掉所有数位。
         在整个过程中,牛牛会把所有在黑板上出现过的数字记录下来,然后求出他们的总和sum.
         例如X = 509, 在黑板上出现过的数字依次是509, 50, 5, 他们的和就是564.
         牛牛现在给出一个sum,牛牛想让你求出一个正整数X经过上述过程的结果是sum.
  输入：输入包括正整数sum(1 ≤ sum ≤ 10^18)
  输出：输出一个正整数,即满足条件的X,如果没有这样的X,输出-1。
  Eg: 564
      509
 */

import java.util.Scanner;

public class 最后一位 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        //二分法
        long l = 0;
        long r = n;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (getSum(mid) > n) {
                r = mid - 1;
            } else if (getSum(mid) == n) {
                System.out.println(mid);
                return;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(-1);
    }

    public static long getSum(long num) {
        long sum = num;
        while (num != 0) {
            sum += num / 10;
            num = num / 10;
        }
        return sum;
    }
}
