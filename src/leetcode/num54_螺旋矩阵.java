package leetcode;

import java.util.ArrayList;
import java.util.List;

public class num54_螺旋矩阵 {

    //左上角坐标（tr, tc）
    //右下角坐标（dr, dc）
    public static List<Integer> spiralOrder(int[][] matrix) {
        int tr = 0;  //top row
        int tc = 0;  //top col
        int dr = matrix.length - 1;  //down row
        int dc = matrix[0].length - 1;  //down col
        List<Integer> res = new ArrayList<>();
        while (tr <= dr && tc <= dc) {
            printEdge(matrix, tr++, tc++, dr--, dc--, res);
        }
        return res;

    }

    public static void printEdge(int[][] m, int tr, int tc, int dr, int dc, List<Integer> res) {
        if (tr == dr) {  //只有一行
            for (int i = tc; i <= dc; i++) {
                res.add(m[tr][i]);
            }
        } else if (tc == dc) {  //只有一列
            for (int i = tr; i <= dr; i++) {
                res.add(m[i][tc]);
            }
        } else {   //行列都有
            for (int i = tc; i <= dc; i++) {  //从左向右
                res.add(m[tr][i]);
            }
            for (int i = tr + 1; i <= dr; i++) {  //从上到下
                res.add(m[i][dc]);
            }
            for (int i = dc - 1; i >= tc; i--) {  //从右向左
                res.add(m[dr][i]);
            }
            for (int i = dr - 1; i >= tr + 1; i--) {
                res.add(m[i][tc]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(arr));
    }
}
