package 数组和矩阵;
/* 《找到无序数组中最小的K个数》
 *  给定一个无序的整型数组arr,找到其中最小的K个数
 * 解法：时间复杂度O(Nlogk)  一直维护一个有k个数的大根堆，这个堆代表目前选出来的K个最小的数，
 *      在堆里面的K个元素中堆顶的元素是最小的K个数里最大的那个
 */

import java.util.Arrays;

public class 找到无序数组中最小的K个数 {
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] kHeap = new int[k];  //堆是一个完全二叉树，这里用数组表示完全二叉树
        for (int i = 0; i != k; i++) {
            heapInset(kHeap, arr[i], i);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }
    //建堆
    public static void heapInset(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {  //一直向上调整，直到根节点
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }
    //调整堆
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;  //index是父节点，计算其左孩子
        int right = index * 2 + 2;  //计算其右孩子
        int largest = index;  //先假设父节点是最大的
        while (left < heapSize) {
            if (arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] num = {16, 4, 9, 31, 6, 7, 10, 5, 14, 3};
        System.out.println(Arrays.toString(getMinKNumsByHeap(num, 3)));
    }
}
