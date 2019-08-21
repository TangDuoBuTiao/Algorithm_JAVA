package leetcode;

public class num121_买卖股票的最佳时机 {

    public static int maxProfit(int[] prices) {
        int res = 0;
        int buy = prices[0];
        int sold = -1;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < buy){
                buy = prices[i];
            }
            if(prices[i] > sold){
                sold = prices[i];
            }
            if(sold > buy){
                sum = sold - buy;
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}
