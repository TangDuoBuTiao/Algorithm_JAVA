package 校招2020.拼多多2;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //输入部分，第一行是一个N，第二行是n个整数，用数组保存
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //计算部分
        //先排序
        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        double res = var(a, b, c);
        for (int i = 3; i < n; i++) {
            a = b;
            b = c;
            c = arr[i];
            res = Math.min(res, var(a, b, c));
        }
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");

        System.out.println(df.format(res));
    }

    public static double var(int a, int b, int c) {
        double mean = (a + b + c) / 3;
        return (Math.pow((a - mean), 2) + Math.pow((b - mean), 2) + Math.pow((c - mean), 2)) / 3;
    }
}
