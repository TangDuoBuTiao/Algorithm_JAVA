package 校招2020.小米集团;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        //计算
        int res = 0;
        if (arr.length == 0) {
            System.out.println(res);
        }
        int[][] dp = new int[3][arr.length];
        int[] min = new int[3];
        min[0] = arr[0];
        min[1] = arr[0];
        min[2] = arr[0];
        int i = 1;
        while(i < arr.length){
            int j = 1;
            while(j <= 2){
                dp[j][i] = Math.max(dp[j][i - 1], arr[i] - min[j]);
                min[j] = Math.min(arr[i] - dp[j - 1][i - 1], min[j]);
                j++;
            }
            i++;
        }
        res = dp[2][arr.length - 1];
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        if (0 == prices.length) {
            return result;
        }
        int[][] dp = new int[3][prices.length];
        int[] min = new int[3];
        for (int i = 1; i < 3; i++) {
            min[i] = prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min[k]);
                min[k] = Math.min(min[k], prices[i] - dp[k - 1][i - 1]);
            }
        }
        return dp[2][prices.length - 1];
    }

}
