package 玩转算法面试.数组.滑动窗口;
/*
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 */

public class leetCode209_minSubArrayLen {
    //暴力求解：遍历所有的连续子数组[i,..,j],O(N^3)
    public static int minSubArrayLen1(int s, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= s) {
                    res = Math.min(res, j - i + 1);
                }
                sum = 0;
            }
        }
        return res;
    }

    //还是暴力，优化子数组求和，O(N^2)
    public static int minSubArrayLen2(int s, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res;
    }

    //滑动窗口,O(N)
    public static int minSubArrayLen3(int s, int[] nums) {
        int l = 0;
        int r = -1;  //nums[l,..,r]为滑动的窗口
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {  //因为是前闭后闭区间，只要l能取值，循环就可以继续
            if (r + 1 < nums.length && sum < s) { //下面有r++,所有这里要判断r+1
                r++;
                sum += nums[r];
            } else {
                sum -= nums[r];
                l++;
            }
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen2(11, num));
    }

}
