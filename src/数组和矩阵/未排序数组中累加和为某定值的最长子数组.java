package 数组和矩阵;
/*
 给定有个无序数组arr,其中元素可正，可负，可0，给定一个整数k,求arr[]所有子数组中累加和为K的最长数组长度
 解法：使用哈希表map, key值记录从arr最左边开始累加过程中出现的sum; value对应的是sum值最早出现的位置。
 */

import java.util.HashMap;

public class 未排序数组中累加和为某定值的最长子数组 {
    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
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
        int a[] = {1, 2, 3, 3};
        System.out.println(maxLength(a,6));
    }
}
