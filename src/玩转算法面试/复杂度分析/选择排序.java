package 玩转算法面试.复杂度分析;
/*
 * 时间复杂度O(N^2)
 * 思想：每次从剩下的未排序的元素中找到最大或最小，放到已排序序列的末尾
 */
import java.util.Arrays;

public class 选择排序 {
    public static void selectSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 2, 8};
        selectSort(arr, 6);
    }
}
