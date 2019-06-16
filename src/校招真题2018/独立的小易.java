package 校招真题2018;
/*
 * 问题描述： 小易每天都要吃一个水果，每天还要支付房租x元，现在小易手里已经有f个水果和d元钱，
 *          水果店里一个水果卖p元，求小易最多能生活几天。
 *
 * 输入：包括一行,四个整数x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9),以空格分割
 * 输出：输出一个整数, 表示小易最多能独立生活多少天。
 * Eg：输入：3 5 100 10
 *     输出：11
 */

import java.util.Scanner;

public class 独立的小易 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }
        int x = arr[0];  //房租
        int f = arr[1];  //水果个数
        int d = arr[2];  //现在有多少钱
        int p = arr[3];  //水果单价

        if(f >= d / x){   //水果足够多的情况，租房天数就是结果
            System.out.println(d / x);
            return;
        }

        int res = 0;
        for (int i = 0; i < d; i += p) {
            if (f + i / p <= (d - i) / x) {
                res = f + i / p;
            } else {
                System.out.println(res);
                return;
            }
        }
    }
}
