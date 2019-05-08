package 数组和矩阵;
/*         《最长的可整合子数组的长度》
 * 问题：给定一个整型数组arr,请返回其中最大可整合子数组的长度，例如：[5,5,3,2,6,4,3]的最大可整合子数组为[5,3,2,6,4],
 * 所以返回5
 * 可整合数组定义：每相邻的两个数差的绝对值都为1
 * 解法：判断一个数组是否是可整合数组，可用(max-min+1==元素个数)来判断
 */

import java.util.HashSet;

public class GetLIL {
    //时间复杂度O(N^2),判断是O(1),找到所有子数组是O(N^2)
    public static int getLIL(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 0;   //记录子数组的最大值
        int min = 0;   //记录子数组的最小值
        int len = 0;   //记录可整合数组的长度
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if ((max - min) == j - i) {
                    len = Math.max(len, j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {5,5,3,2,6,4,3};
        int[] b = {1,2,5,4};
        System.out.println(getLIL(b));
    }
}
