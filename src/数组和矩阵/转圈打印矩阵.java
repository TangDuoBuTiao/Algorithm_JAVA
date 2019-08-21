package 数组和矩阵;
/*    《转圈打印矩阵》
 * 按照顺时针转圈的方式打印矩阵
 * 解法：在矩阵中用左上角的坐标(tR,tC)和右下角的坐标(dR,dC)就可以表示一个子矩阵，
 */

public class 转圈打印矩阵 {
    public void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;   //从0开始，要减1
        int dC = matrix[0].length - 1;  //从0开始，要减1
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {  //两个坐标在同一行，只打印一行
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {  //两个坐标在同一列，只打印一列
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {  //一般情况，需要打印一圈
            int curC = tC;
            int curR = tR;
            while (curC != dC) { //从左到右
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {  //从右到下
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {  //从下到左
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {  //从左到上
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        转圈打印矩阵 s = new 转圈打印矩阵();
        s.spiralOrderPrint(matrix);
    }
}
