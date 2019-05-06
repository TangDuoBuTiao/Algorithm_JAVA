package leetcode;
/*
 * 《最大三角形面积》
 */

public class num812 {
    public static double largestTriangleArea(int[][] points) {
        int len = points.length;
        double s = 0;
        double area = 0;
        for (int a = 0; a < len; a++) {   //A点
            for (int b = 0; b < len; b++) {   //B点
                for (int c = 0; c < len; c++) {   //C点
                    area = 1.0 / 2 * (points[a][0] * points[c][1] + points[c][0] * points[b][1] + points[b][0] * points[a][1]
                            - points[a][0] * points[b][1] - points[b][0] * points[c][1] - points[c][0] * points[a][1]);
                    s = Math.max(s, area);
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[][] p = {{0, 0}, {0, 1}, {1, 0}, {0, 3}, {2, 0}};
        System.out.println(largestTriangleArea(p));
    }
}
