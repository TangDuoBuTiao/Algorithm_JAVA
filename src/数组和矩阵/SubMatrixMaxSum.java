package 数组和矩阵;
/*   《子矩阵的最大累加和》
 * 给定一个矩阵matrix, 其中的值有正、有负、有0， 返回子矩阵的最大累加和
 */

public class SubMatrixMaxSum {
    /*
     * 解法：把不同组合的行，对应位置相加，形成一个一维数组，求解最大子矩阵的和转换为求解最大子数组的和
     * 如果矩阵为N*N, 时间复杂度O(N^3)
     */
    public static int maxSum(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int[] tmp = null; //累加数组
        int sum = 0;    //记录每次的累加和
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            tmp = new int[mat[0].length];                //清0
            for (int j = i; j < mat.length; j++) {
                sum = 0;
                for (int k = 0; k < tmp.length; k++) {
                    tmp[k] += mat[j][k];
                    sum += tmp[k];
                    if (sum < 0) {
                        sum = 0;
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] m = {{-90, 48, 78}, {64, -40, 64}, {-81, -7, 66}};
        System.out.println(maxSum(m));
    }
}
