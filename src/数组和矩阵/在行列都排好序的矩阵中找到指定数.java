package 数组和矩阵;
/*        《在行列都排好序的矩阵中找到指定数》
 * 给定一个NxM的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的，实现一个函数，判断K是否在matrix中。
 * 要求：时间复杂度O(N+M), e额外空间复杂度O(1)
 */

public class 在行列都排好序的矩阵中找到指定数 {
    public static boolean isContains(int[][] arr, int k) {
        int row = 0;
        int col = arr[0].length - 1;
        while (row < arr.length && col != -1) {
            if (arr[row][col] == k) {
                return true;
            } else if (arr[row][col] < k) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {5, 7, 7, 9}};
        System.out.println(isContains(a, 7));

    }
}
