package 数组和矩阵;

/*    《数组中子数组的最大累乘积》
 *  问题：给定一个double类型的数组arr,其中的元素可正、可负、可0，返回子数组累乘的最大乘积。
 *   Eg: arr=[-2.5, 4, 0, 3, 0.5, 8, -1], 子数组[3, 0.5, 8]累乘可以获得最大乘积12,所有返回12。
 * 解法： 结果=max{以0下标为子数组的累乘积，以1下标为子数组的累乘积，...,以i下标为子数组的累乘积}
 *      以i为结尾的子数组的累乘积分为3种情况：
 *      ① 可能是max*arr[i], max表示以arr[i-1]结尾的最大累乘积
 *      ② 可能是min*arr[i], min表示以arr[i-1]结尾的最小累乘积
 *      ③ 前面i-1个数的子数组的值为0，那么最大累乘积就是arr[i]自己
 */
public class 数组中子数组的最大累乘积 {
    //时间复杂度O(N)、额外空间复杂度O(1)
    public static double maxProduct(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        double max = arr[0];  //记录前i-1个数的最大累乘积
        double min = arr[0];  //记录前i-1个数的最小累乘积
        double res = arr[0];  //记录最终结果（时刻更新最大值）
        double maxEnd = 0;    //记录以i为结尾前面i-1个数的累乘积
        double minEnd = 0;
        for (int i = 1; i < arr.length; i++) {
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
            min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        double[] a = {-2.5, 4, 0, 3, 0.5, 8, -1};
        System.out.println(maxProduct(a));
    }
}
