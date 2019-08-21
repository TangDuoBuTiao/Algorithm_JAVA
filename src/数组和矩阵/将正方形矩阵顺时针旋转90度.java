package 数组和矩阵;

/*        《将正方形矩阵顺时针旋转90°》
 * 给定一个NxN的矩阵matrix,把这个矩阵调整成顺时针转动90°后的形式
 * 要求：额外空间复杂度O(1)
 * 解法：在矩阵中用左上角的坐标(tR,tC)和右下角的坐标(dR,dC)就可以表示一个子矩阵，一个外圈一个外圈的进行调整
 * 在这个外圈中:
 *    1  2  3  4          1,4,16,13为一组，1占据4的位置，4占据16的位置，16占据13的位置，13占据1的位置
 *    5        8          2,8,15,9为一组，2占据8的位置，8占据15的位置，15占据9的位置，9占据2的位置
 *    9        12         3,12,14,5为一组，3占据12，12占据14,14占据5,5占据3
 *    13 14 15 16
 */
public class 将正方形矩阵顺时针旋转90度 {
    public int[][] rotate(int[][] matrix) {  //R:row, C:colum
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
        return matrix;
    }

    public void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dR - tR;  //总的组数
        int tmp = 0;
        for (int i = 0; i != times; i++) { //每一轮循环就是一组的占据
            tmp = m[tR][tC + i];             //左上角给tmp
            m[tR][tC + i] = m[dR - i][tC];   //左下角给左上角
            m[dR - i][tC] = m[dR][dC - i];   //右下角给左下角
            m[dR][dC - i] = m[tR + i][dC];   //右上角给右下角
            m[tR + i][dC] = tmp;             //tmp给右上角
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        将正方形矩阵顺时针旋转90度 r = new 将正方形矩阵顺时针旋转90度();
        int [][] res = r.rotate(matrix);
        //打印看转换结果
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.printf("%4d",res[i][j]);
            }
            System.out.println();
        }
    }

}
