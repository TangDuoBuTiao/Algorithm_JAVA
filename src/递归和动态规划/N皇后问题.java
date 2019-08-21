package 递归和动态规划;
/*   《N皇后问题》
 * 问题：在N*N的棋盘上，要摆N个皇后，要求任何两个皇后不同行，不同列，也不在同一条对角线上，
 *      给定一个整数n,返回n皇后的摆法有多少种。
 * 解法：如果在(i,j)位置(第i行第j列)放置了一个皇后，接下来哪些位置不能放？
 *      1.整个第i行都不能放
 *      2.整个第j列都不能放
 *      3.如果位置(a,b)满足|a-i| == |b-j|，说明(a,b)与(i,j)在同一条斜线上，也不能放
 *      建立一个数组record,record[i] = j,表示第i行第j列放置了皇后，
 */

public class N皇后问题 {
    //递归解法：
    public static int num(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);

    }

    public static int process(int i, int[] arr, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(arr, i, j)) {
                arr[i] = j;
                res += process(i + 1, arr, n);
            }
        }
        return res;

    }

    //判断(i,j)这个位置能不能放
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(i - k) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(num(8));
    }

}
