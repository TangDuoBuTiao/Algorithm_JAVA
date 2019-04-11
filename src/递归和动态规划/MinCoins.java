package 递归和动态规划;
/*
 *给定数组arr,其中的值都为整数且不重复，每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim,代表要找的钱，求组成aim的最少货币数。
 */

public class MinCoins {
    //暴力方法求解
    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process(arr, 0, aim);
    }

    /*
     * 递归方法：
     * parameter arr: 传入的面值数组，（固定参数）
     * parameter i: 当前使用arr[i]这个面值，（可变参数）
     * parameter rest: 还剩rest的钱需要找零。（可变参数）
     */
    public static int process(int[] arr, int i, int rest) {
        //base case:如果已经没有面值能考虑，如果此时剩余的钱为0，返回0张，否则返回-1
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        //最少张数，初始值为-1，因为还没有找到有效解
        int ans = -1;
        for (int k = 0; k * arr[i] <= rest; k++) {
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) {
                ans = ans == -1 ? next + k : Math.min(ans, next + k);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 3};
        System.out.println(minCoins1(a, 8));
    }
}
