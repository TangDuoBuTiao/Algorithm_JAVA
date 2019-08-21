package 校招提前批2020.贝壳;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[][] matrix = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        float[][] kernel = new float[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                kernel[i][j] = sc.nextFloat();
            }
        }
        //计算
        int[][] res = new int[h - m + 1][w - m + 1];
        for (int i = 0; i < h - m + 1; i++) {
            for (int j = 0; j < w - m + 1; j++) {
                res[i][j] = matmul(matrix, kernel, i, j, m);
            }
        }
        for(int i = 0; i < h - m + 1; i++){
            for(int j = 0; j < w - m + 1; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int matmul(int[][] a, float[][] b, int l1, int l2, int len) {
        float res = 0;
        for (int i = l1; i < l1 + len; i++) {
            for (int j = l2; j < l2 + len; j++) {
                res += a[i][j] * b[i - l1][j - l2];
            }
        }
        return (int)res;
    }
}
