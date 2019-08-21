package 玩转算法面试.数组;
/*
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */

public class leetCode88_merge {
    //使用归并排序
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeArr = new int[m + n];
        int i = 0;  //遍历nums1
        int j = 0;  //遍历nums2
        int index = 0;  //新数组下标
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mergeArr[index++] = nums1[i];
                i++;
            } else {
                mergeArr[index++] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            mergeArr[index++] = nums1[i++];
        }
        while (j < n) {
            mergeArr[index++] = nums2[j++];
        }
        for (int k = 0; k < m; k++) {
            nums1[k] = mergeArr[k];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
}
