package 校招真题2018.爱奇艺;
/*
  问题描述：给4个数，可以对每个数进行加1减1操作，问可以对每个数一共进行多少操作可以4个数相等
  输入：输入包括一行,四个整数a,b,c,d(1 ≤ a,b,c,d ≤ 10^6), 以空格分割
  输出：输出一个整数，最少需要的操作数
  Eg:4 1 5 4
     4
 */

import java.util.Arrays;
import java.util.Scanner;

public class 拼凑正方形 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        //66ms
        Arrays.sort(arr);
        System.out.println((arr[3] - arr[0]) + (arr[2] - arr[1]));
        // 104ms
//        int res = Integer.MAX_VALUE;
//        int tmp = 0;
//        for (int i = 0; i < 4; i++) {
//            tmp = 0;
//            for (int j = 0; j < 4; j++) {
//                tmp = Math.abs(arr[0] - arr[i]) + Math.abs(arr[1] - arr[i]) +
//                        Math.abs(arr[2] - arr[i]) + Math.abs(arr[3] - arr[i]);
//                if (tmp < res) {
//                    res = tmp;
//                }
//            }
//        }
//        System.out.println(res);
    }
}
