package 校招2020.五八同城;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //计算
        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[n];
        //先每人分一个
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        //从左向右扫描，
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        //从右向左扫
        for (int i = n - 1; i > 0; i--) {
            if(arr[i] < arr[i - 1] && dp[i] >= dp[i - 1]){
                dp[i - 1] = dp[i] + 1;
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res += dp[i];
        }
        System.out.println(res);
    }
}
