package 数组和矩阵;
/*    《未排序正数数组中累加和为给定的最长子数组长度》
 * 问题：给定一个数组arr,该数组无序，但每个值均为正值，再给定一个整数K，求arr的所有子数组中所有元素相加为K的最长子数组长度。
 *      Eg: arr = {1,2,1,1,1}, k = 3   和为3的最长子数组为[1,1,1],所以返回3
 * 解法：用两个位置来标记子数组的左右两头，记为left和right，开始left和right都为0，
 *      如果arr[left,.,right]的sum等于k，则更新len= right - left + 1
 *      如果arr[left,.,right]的sum小于k, 则right++, sum += arr[right]
 *      如果arr[left,.,right]的sum大于k, 则left++, sum -= arr[left]
 */

public class 未排序正数数组中累加和为给定的最长子数组长度 {
    public static int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int len = 0;  //记录满足条件子数组的长度
        int sum = arr[0];  //记录子数组所有元素的和
        while (right <= arr.length) {
            if (sum == k) {
                len = Math.max(len, (right - left + 1));
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                left++;
                sum -= arr[left];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 1, 1};
        int[] b = {10, 8, 2, 7, 1, 1, 1};
        System.out.println(getMaxLength(a, 3));
    }
}
