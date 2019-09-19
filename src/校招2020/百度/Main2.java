package 校招2020.百度;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a1 = sc.nextInt();
        long a2 = sc.nextInt();
        long a3 = sc.nextInt();
        long a4 = sc.nextInt();
        int n = sc.nextInt();
        long[] arr = new long[1000];
        arr[1] = a1;
        arr[2] = a2;
        arr[3] = a3;
        arr[4] = a4;
        //计算
        for (int i = 5; i <= n + 5; i++) {
            arr[i] = ((arr[i - 1] + arr[i - 3]) % 1000000007 + arr[i - 4]) % 1000000007;
        }
        System.out.println(arr[n]);
    }
}
