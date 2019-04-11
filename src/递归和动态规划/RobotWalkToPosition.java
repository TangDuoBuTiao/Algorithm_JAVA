package 递归和动态规划;
/*
 * 给定N个位置，给出机器人初始在M这个位置，机器人每次只能向右向左移动一步，
 * 问：移动K步，最后停在P位置，一共有几种走法？
 */

public class RobotWalkToPosition {

    //方法一：暴力递归求解
    /*
     * parameter N：位置为1~N，（固定参数）
     * parameter cur:当前在cur位置，（可变参数）
     * parameter rest:还剩rest步没有走，（可变参数）
     * parameter p:最终目标位置是p,（固定参数）
     */
    public static int walk(int N, int cur, int rest, int p) {
        //剩余步数为0，如果走到p位置，就返回一种方法，否则返回0
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }
        //如果走到1这个位置，下一步只能向右走，cur+1
        if (cur == 1) {
            return walk(N, cur + 1, rest - 1, p);
        }
        //如果走到N这个位置，下一步只能向左走，cur-1
        if (cur == N) {
            return walk(N, cur - 1, rest - 1, p);
        }
        //如果走到1~N之间的位置，下一步可以向右走，也可向左走，两种不同的走法
        return walk(N, cur + 1, rest - 1, p) + walk(N, cur - 1, rest - 1, p);
    }

    public static int ways1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }


    /*
     * 方法二：动态规划求解
     * 分析：由暴力递归求解可发现，可变参数为cur和rest,由他俩的递推关系，可得到一张二维的dp[][]表
     */
    public static int ways2(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        //dp[rest][cur]
        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;  //剩余0步，走到P位置，就为1
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {      //如果当前在1位置，下次只能向右走（走到2）,rest-1
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) {       ////如果当前在N位置，下次只能向左走（走到N-1）,rest-1
                    dp[i][j] = dp[i - 1][N - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        //打印dp[][]
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.printf("%-4d", dp[i][j]);
            }
            System.out.println();
        }

        return dp[K][M];
    }


    public static void main(String[] args) {
        System.out.println("总方法数："+ways2(7, 4, 9, 5));
    }

}
