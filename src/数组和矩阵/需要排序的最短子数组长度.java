package 数组和矩阵;
/* 《需要排序的最短子数组长度》
 *  给定一个无序数组arr,求出需要排序的最短子数组长度
 * Eg: arr = [1,5,3,4,2,6]返回4，因为只有[5,3,4,2]是需要排序的
 */

public class 需要排序的最短子数组长度 {
    public static int getMinLength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        //反向遍历
        int min = arr[arr.length - 1];
        int noMinIndex = -1;
        for (int i = arr.length - 2; i != -1; i--) {
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(arr[i], min);
            }
        }
        if (noMinIndex == -1) {  //说明整体有序
            return 0;
        }
        //正向遍历
        int max = arr[0];
        int noMaxIndex = -1;
        for (int i = 1; i != arr.length; i++) {
            if (arr[i] < max) {
                noMaxIndex = i;
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 3, 4, 2, 6, 7};
        System.out.println(getMinLength(a));
    }
}
