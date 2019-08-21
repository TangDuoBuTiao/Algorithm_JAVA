package 校招真题2019.网易;
/*
 * 题目描述：小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
           并且小Q对于能否被3整除这个性质很感兴趣。
           小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
   输入描述：输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
   输出：输出一个整数, 表示区间内能被3整除的数字个数。
   Eg: 2 5
       3
   说明：区间[2,5]内，其中12, 123, 12345能被3整除。
 */

import java.util.Scanner;

public class 被3整除 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextInt();   // !!!!!!!!注意使用long类型 ！！！！！！！！
        long r = sc.nextInt();

        int res = 0;
        for (long i = l; i <= r; i++) {
            long sum = (1 + i) * i / 2;
            if (sum % 3 == 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}
