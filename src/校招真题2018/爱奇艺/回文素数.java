package 校招真题2018.爱奇艺;
/*
  问题描述：
        如果一个整数只能被1和自己整除,就称这个数是素数。
        如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
        如果一个数字既是素数也是回文数,就称这个数是回文素数
        牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。
  输入：输入包括一行,一行中有两个整数(1 ≤ L ≤ R ≤ 1000)
  输出：输出一个整数,表示区间内回文素数个数。
 */

import java.util.Scanner;

public class 回文素数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (IsTrack(i) && IsPrime(i)) {
                res++;
            }
        }
        System.out.println(res);
    }

    //判断是不是回文数
    public static boolean IsTrack(int num) {
        String str = String.valueOf(num);
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    //判断是不是素数
    public static boolean IsPrime(int num) {
        if (num <= 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
