package 校招2020.途家;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int m = sc.nextInt();  //最大容量
        int[] w = new int[s];
        int[] v = new int[s];
        for (int i = 0; i < s; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        //计算
        int[] dp = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= s; i++) {
            for (int j = m; j >= w[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
            }
        }
        System.out.println(dp[m]);
    }
}
