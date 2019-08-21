package 数组和矩阵;
/*             《在数组中找到一个局部最小的位置》
 * 局部最小概念：arr长度为1时，arr[0]是局部最小。arr的长度为N（N > 1）时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 *             如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i]<arr[i-1],
 *             又有arr[i]<arr[i+1],那么arr[i]是局部最小。
 * 问题：给定无序数组arr,已知arr中任意两个相邻的数都不相等。写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */

public class 在数组中找到一个局部最小的位置 {
    //利用二分查找做到时间复杂度O(logN)、额外空间复杂度O(1)
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        //排除数组首尾出现局部最小，中间的用二分查找法
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 8, 8, 2, 4};
        System.out.println(getLessIndex(a));
    }
}
