package 玩转算法面试.贪心;

import java.util.Arrays;
import java.util.Comparator;

public class num435_无重叠区间 {
    public static void eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return a1[1] - a2[1];   //升序排列
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(intervals[i][0] + " " + intervals[i][1]);
            System.out.println();
        }


    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {2, 4}, {3, 3}};
        eraseOverlapIntervals(arr);
    }
}
