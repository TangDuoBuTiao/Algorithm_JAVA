package 数组和矩阵;
/*  《未排序数组中累加和为给定值的最长子数组系列问题》
 * 问题：给定一个无序数组arr,其中元素可正、可负、可0，给定一个整数K, 求arr所有的子数组中累加和为k的最长子数组长度
 */

import java.util.HashMap;

public class MaxLength {
    /*
     * 时间复杂度O(N),额外空间复杂度O(N)
     * 解法：定义s(i)代表子数组arr[0,.,i]所有元素的累加和，那么子数组arr[j,.,i](0<=j<=i<arr.length)
     *      的累加和为s(i)-s(j-1)
     *      建立map,key代表当前位置的sum和，value代表key的sum最早出现的位置
     */
    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int len = 0;  //记录符合要求的子数组的长度
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 1, 1, 1,};
        System.out.println(maxLength(a, 6));
    }
}
