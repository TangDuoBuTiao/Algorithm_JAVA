package 基础算法;
/*
 * 以《找无序数组最小的K个数》为例，介绍大根堆的使用。
 */

import java.util.Arrays;

public class 大根堆 {

    /* 大根堆的插入函数
     * 参数arr：维护大根堆的数组
     * 参数value：要插入大根堆的元素值
     * 参数index：要插入大根堆的位置
     */
    public static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;   //找到要插入节点的父节点
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    //交换函数
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //调整堆
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[index]) {
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

    //得到数组中前K小的元素
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k > arr.length || k < 1) {
            return arr;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(kHeap, arr[i], i);
        }
        for (int i = k; i < arr.length; i++) {  //和堆中元素进行比较
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1, 2};
        System.out.println(Arrays.toString(getMinKNumsByHeap(arr, 3)));
    }

}
