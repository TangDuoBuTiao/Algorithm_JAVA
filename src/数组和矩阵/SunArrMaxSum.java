package 数组和矩阵;

/*    《子数组最大和问题》
 *  给定一个数组arr,返回子数组的最大累加和
 * 要求：时间复杂度O(N),额外空间复杂度O(1)
 */
public class SunArrMaxSum {
    public static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {   //如果累加到当前的和为负值，说明再往右加，当前这部分提供的是负收益，直接舍去
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(maxSum(a));
    }
}
