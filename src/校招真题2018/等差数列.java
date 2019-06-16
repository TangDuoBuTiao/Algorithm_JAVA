package 校招真题2018;

/*
 * 问题描述：
 *        小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上做交换任意两个位置的数值的操作,
 *        并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列，
 *        小易需要判别一个数列是否能通过交换操作变成等差数列。
 *
 * 输入：
 *     输入包括两行,第一行包含整数n(2 ≤ n ≤ 50),即数列的长度。第二行n个元素x[i](0 ≤ x[i] ≤ 1000),
 *     即数列中的每个整数。
 * 输出：
 *      如果可以变成等差数列输出"Possible",否则输出"Impossible"。
 */

import java.util.Scanner;
import java.util.Arrays;

public class 等差数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 2) {
            System.out.println("Possible");
        }
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int tmp = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != tmp) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
