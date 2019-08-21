package 动态规划;

public class o1背包 {

    public static void knp(int[] w, int[] v, int capicaty) {
        int dp[][] = new int[w.length][capicaty + 1];
        for (int i = 1; i < w.length; i++) {  //遍历物品
            for (int j = 1; j <= capicaty; j++) {   //遍历背包容量
                if (j < w[i]) {  //装不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[w.length - 1][capicaty]);
    }

    public static void main(String[] args) {
        int[] w = {0, 2, 3, 4, 5};  //第一个补0是为了方便
        int[] v = {0, 3, 4, 5, 6};
        knp(w, v, 8);
    }
}
