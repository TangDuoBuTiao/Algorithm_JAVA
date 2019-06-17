package 校招真题2018.爱奇艺;
/*
  问题描述：牛牛的老师给出了一个区间的定义:对于x ≤ y,[x, y]表示x到y之间(包括x和y)的所有连续整数集合。例如[3,3] = {3}, [4,7] = {4,5,6,7}.牛牛现在有一个长度为n的递增序列,牛牛想知道需要多少个区间并起来等于这个序列。
        例如:
            {1,2,3,4,5,6,7,8,9,10}最少只需要[1,10]这一个区间
            {1,3,5,6,7}最少只需要[1,1],[3,3],[5,7]这三个区间
  输入：输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),
       第二行n个整数a[i](1 ≤ a[i] ≤ 50),表示牛牛的序列,保证序列是递增的。
  输出：输出一个整数,表示最少区间个数。
  Eg:5
     1 3 5 6 7
     3
 */

import java.util.Scanner;

public class 区间表达 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 1;
        if (len == 1) {
            System.out.println(res);
        }
        for (int i = 1; i < len; i++) {
            if (arr[i] - arr[i - 1] != 1) {
                res++;
            }
        }
        System.out.println(res);
    }
}
