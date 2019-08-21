package 玩转算法面试.查找;
/*
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等
 * （需要考虑元组的顺序）。
   找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
   Eg：输入: [[0,0],[1,0],[2,0]]
      输出:  2
      解释:
      两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */

import java.util.HashMap;

public class leetCode447_numberOfBoomerangs {
    public static int numberOfBoomerangs(int[][] points) {
        //map<距离, 距离的次数>
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            //遍历每一个i,建立i其它点的距离
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                int dist = distance(points[i], points[j]);
                if (map.containsKey(dist)) {
                    map.put(dist, map.get(dist) + 1);
                } else {
                    map.put(dist, 1);
                }
            }
            //遍历map
            for (int key : map.keySet()) {
                if (map.get(key) >= 2) {
                    res += map.get(key) * (map.get(key) - 1);
                }
            }
        }
        return res;
    }

    public static int distance(int[] a, int[] b) {
        int d1 = a[0] - b[0];
        int d2 = a[1] - b[1];
        int dis = d1 * d1 + d2 * d2;
        return dis;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(a));
    }
}
