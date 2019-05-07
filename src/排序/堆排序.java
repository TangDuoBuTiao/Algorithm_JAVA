package 排序;

import java.util.Arrays;

public class 堆排序 {
    /*
     * @parameter arr: 数组，相当于一棵完全二叉树
     * @parameter index: 根节点
     * @parameter heapSize: 完全二叉树中节点个数
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;  //左孩子节点在数组中的下标
        int right = index * 2 + 2;  //右孩子节点在数组中的下标
        int largest = index;  //先假设父节点最大
        while (left < heapSize) {
            // 找父节点和孩子节点中的最大值
            if (arr[left] > arr[largest]) {  //保证孩子节点不越界（有孩子节点）
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {  //同上
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {           //如果父节点就是最大的，直接中断while,不然进入死循环。
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    /* 建立大根堆，即实现降序排列
     * @parameter arr: 待排序的乱序数组
     * @parameter n: 数组长度
     */
    public static void build_heap(int[] arr, int n) {
        int last_node = n - 1;
        int parent = (last_node - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] tree = {2, 5, 30, 1, 10, 4};
        build_heap(tree, 6);
        System.out.println(Arrays.toString(tree));
    }
}
