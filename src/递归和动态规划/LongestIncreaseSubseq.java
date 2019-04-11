package 递归和动态规划;
/*
 * 给定数组arr,返回arr的最长递增子序列
 */

import java.util.Arrays;

public class LongestIncreaseSubseq {
    /*
     * 时间复杂度O(N^2)的方法
     * 1.生成长度为N的数组dp[]，dp[i]表示在以arr[i]这个数结尾的情况下，arr[0,..,i]中的最大递增子序列
     * 2.对于第一个数，dp[0] = 1,接下来从左向右依次算出以每个位置的数结尾的情况下，最长递增子序列的长度。
     */
    //计算dp数组
    public static int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    //根据dp数组逆序得到决策路径，得到最长递增子序列
    public static int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {   //得到最终递增子序列的长度len,和最大值在arr中的下标index。
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];   //把最大值放在最后一个位置
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    //主方法
    public static int[] lis1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }

    /*
     * 方法二：时间复杂度O(NlogN)，
     * 在构建dp数组上利用二分查找进行优化减少时间复杂度，由dp数组逆序得到最长递增子序列同方法一
     *
     */
    public static int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];   //ends[0,..,right]为有效区
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;  //二分查找的左右游标
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;     //默认下取整
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    //主方法
    public static int[] lis2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp2(arr);
        return generateLIS(arr, dp);
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(Arrays.toString(lis2(a)));
    }
}
