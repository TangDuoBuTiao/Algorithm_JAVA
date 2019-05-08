package 数组和矩阵;
/*  《不重复打印排序数组中相加和为给定值的所有二元组和三元组》
 * 问题：给定排序数组arr和整数k,不重复打印arr中所有相加和为K的不降序二元组。
 * 例如：arr = {-8,-4,-3,0,1,2,4,5,8,9}, k=10,打印结果：
 *       1,9
 *       2,8
 * 补充问题：打印三元组
 * 例如：arr = {-8,-4,-3,0,1,2,4,5,8,9}, k=10,打印结果：
 *      -4,5,9
 *      -3,4,9
 *      -3,5,8
 *       0,1,9
 *       0,2,8
 *       1,4,5
 */

public class PrintUniquePairTriad {
    //原问题：不重复打印二元组，时间复杂度O(N)
    //解法：定义两个指针，左指针和右指针，分别从数组的头和尾向中间挤压
    public static void printUniquePair(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if ((arr[left] + arr[right]) == k) {
                if (left != 0 && arr[left] != arr[left - 1]) {   //判断是不是重打印
                    System.out.println(arr[left] + ", " + arr[right]);
                }
                left++;
                right--;
            } else if ((arr[left] + arr[right]) < k) {
                left++;
            } else {
                right--;
            }

        }
    }

    //补充问题：不重复打印三元组，时间复杂度为O(N^2)
    //解法：Eg:当三元组的第一个值为-8时，找-8后面的子数组中所有和为18的不重复二元组
    public static void printUniqueTriad(int[] arr, int k) {
        if (arr == null || arr.length < 3) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i] != arr[i - 1]) {   //防止重复打印
                printReset(arr, i, k);
            }
        }
    }

    public static void printReset(int[] arr, int index, int k) {
        if (arr.length - index < 3) {
            return;
        }
        int left = index + 1;
        int right = arr.length - 1;
        while (left < right) {
            if ((arr[left] + arr[right] + arr[index]) == k) {
                //  if (arr[left] != arr[left - 1]) {
                System.out.println(arr[index] + ", " + arr[left] + ", " + arr[right]);
                //   }
                left++;
                right--;
            } else if ((arr[left] + arr[right] + arr[index]) < k) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        //printUniquePair(a, 10);
        printUniqueTriad(a, 10);

    }
}
