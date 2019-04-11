package 递归和动态规划;
/*
 * 给定数组arr, arr中所有的值都为正数且不重复，每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim, 代表要找的钱数，求换钱有多少种方法。
 */


public class ChangeMoneyNums {
    /*
     * 方法一：暴力递归解法
     */
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int aim) {
        int ans = 0;
        if (index == arr.length) {  //index走到数组末尾，aim为0说明找到了一种换钱的方法。
            ans = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {  //i表示倍数，
                ans += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return ans;

    }

    /*
     * 方法二：记忆化搜索
     * 递归过程中，变化的是index和aim, 用p(index, aim)代表递归过程。事先准备好map,每计算完一个递归过程，就将结果记录到map中。
     * 下次这个递归过程出现的话，直接去map里找到值直接用即可。
     * map里面的值，0表示没有被计算过；-1表示计算过但返回值是0；其它情况下的值表示这个递归过程返回的值。
     */
    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {
        int ans = 0;
        if (index == arr.length) {
            ans = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    ans += mapValue == -1 ? 0 : mapValue;
                } else {
                    ans += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = ans == 0 ? -1 : ans;
        return ans;

    }

    /*
     * 方法三：动态规划方法
     * 生成行数为面值个数N，列数为aim+1的矩阵dp[][],
     */
    public static int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {   //组成钱数为0的方法数，都是1
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {  //第一行是面值为arr[0]时，组成钱数的方法数
            dp[0][arr[0] * j] = 1;                 //只有arr[0]的整数倍才有组成的可能性，并且是1
        }
        int num = 0;
        for (int i = 1; i < arr.length; i++) {  //一行一行的遍历
            for (int j = 1; j <= aim; j++) {   //一列一列遍历
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.printf("%-4d", dp[i][j]);
            }
            System.out.println();
        }
        return dp[arr.length - 1][aim];
    }

    /*
     * 方法三：动态规划方法再优化
     * 生成行数为面值个数N，列数为aim+1的矩阵dp[][],
     */
    public static int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j * arr[0] <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];   //先继承之前面值的方法数
                dp[i][j] += j >= arr[i] ? dp[i][j - arr[i]] : 0;  //j<arr[i]这个面值时，使用arrp[i]这个面值起不到任何作用
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.printf("%-4d", dp[i][j]);
            }
            System.out.println();
        }

        return dp[arr.length - 1][aim];
    }


    public static void main(String[] args) {
        int[] a = {5, 10, 1};
        System.out.println(coins3(a, 12));
    }
}
