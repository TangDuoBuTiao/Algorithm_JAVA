package 校招2020.转转;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0){
            System.out.println(0);
            return;
        }
        if(n == 1 || n == 2){
            System.out.println(n);
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = 1;
        }
        int[] last = new int[n];
        for (int i = 0; i < n; i++) {
            last[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            pre[i] = arr[i] > arr[i - 1] ? pre[i - 1] + 1 : 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            last[i] = arr[i + 1] > arr[i] ? last[i + 1] + 1 : 1;
        }
        int res = 1;
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, pre[i]);
            res = Math.max(res, last[i]);
            if(arr[i + 1] - arr[i - 1] >= 2){
                res = Math.max(res, (pre[i - 1] + last[i + 1] + 1));
            }
        }
        System.out.println(res);
    }
}
