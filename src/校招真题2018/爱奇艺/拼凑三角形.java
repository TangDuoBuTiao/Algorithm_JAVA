package 校招真题2018.爱奇艺;

/*
 题目描述：牛牛手中有三根木棍,长度分别是a,b,c。牛牛可以把任一一根木棍长度削短,牛牛的目标是让这三根木棍构成一个三角形,
         并且牛牛还希望这个三角形的周长越大越好。
 输入：输入包括一行,一行中有正整数a, b, c(1 ≤ a, b, c ≤ 100), 以空格分割
 输出：输出一个整数,表示能拼凑出的周长最大的三角形。
 Eg: 1 2 3
     5
 */

import java.util.Scanner;
import java.util.Arrays;

public class 拼凑三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        while (arr[0] + arr[1] <= arr[2]) {
            arr[2]--;
        }
        System.out.println(arr[0] + arr[1] + arr[2]);
    }
}
