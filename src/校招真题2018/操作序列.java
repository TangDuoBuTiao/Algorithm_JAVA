package 校招真题2018;
/*
 * 问题描述：小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
             1、将a_i放入b序列的末尾
             2、逆置b序列
           小易需要你计算输出操作n次之后的b序列。
 * 输入：输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
        第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。
     Eg:  4
 *        1 2 3 4
 *  输出：在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
 *   Eg:  4 2 1 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 操作序列 {

    public static void main(String[] args) throws IOException {
        /*
         * 使用BufferedReader 读取 时间将近快了一倍
         */
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(input.readLine());
        String str = input.readLine();
        String[] arr = str.split(" ");
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int[] arr = new int[len];
//        for (int i = 0; i < len; i++) {
//            arr[i] = sc.nextInt();
//        }
        if ((len & 1) == 0) {  //长度为偶数
            for (int i = len - 1; i > 0; i -= 2) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i < len; i += 2) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i = len - 1; i >= 0; i -= 2) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 1; i < len - 2; i += 2) {
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[len - 2]);
        }
    }
}
