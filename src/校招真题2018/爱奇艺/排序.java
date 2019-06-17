package 校招真题2018.爱奇艺;
/*
 * 问题描述：
 *        牛牛有一个长度为n的整数序列,牛牛想对这个序列进行重排为一个非严格升序序列。牛牛比较懒惰,
 *        他想移动尽量少的数就完成重排,请你帮他计算一下他最少需要移动多少个序列中的元素。
 *        (当一个元素不在它原来所在的位置,这个元素就是被移动了的)
 * 输入：输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),即序列的长度
        第二行n个整数x[i](1 ≤ x[i] ≤ 100),即序列中的每个数
   输出：输出一个整数,即最少需要移动的元素个数
   Eg: 3
   *   3 2 1
   *   2
 */

import java.util.Scanner;
import java.util.Arrays;

public class 排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        int[] arr1 = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
            arr1[i] = arr[i];
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < len; i++) {
            if(arr[i] != arr1[i]){
                res++;
            }
        }
        System.out.println(res);
    }
}
