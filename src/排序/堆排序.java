package 排序;

import java.util.Arrays;

public class 堆排序 {
    /*
     * @parameter arr: 数组，相当于一棵完全二叉树
     * @parameter index: 从某个index开始堆化，index为0时，就是从根节点开始堆化
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
            //largest不等于index的话，肯定是和某个孩子节点A交换了，A作为父节点，下面乱了，以A为父节点继续堆化
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    /* 建立大根堆
     * @parameter arr: 待排序的乱序数组
     * @parameter n: 数组长度
     */
    public static void build_heap(int[] arr, int n) {
        int last_node = n - 1;  //从最后一个节点的父节点开始调整
        int parent = (last_node - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    /*
     * 通过建立好的大根堆，进行排序，
     * 思路：每次把最后一个节点和根节点交换，再把最后一个节点拿出来，这样保证每次拿出来的都是目前最大的
     * @parameter arr: 待排序的乱序数组
     * @parameter n: 数组长度
     */
    public static int[] heap_sort(int[] arr, int n) {
        build_heap(arr, n);  //先建一个堆
        int[] res = new int[arr.length];   //保存排序结果
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);  //交换最后一个节点和根节点
            res[index++] = arr[i];  //把最后一个节点（目前最大值）拿出来
            heapify(arr, 0, i);  //重新从根节点开始堆化
        }
        return res;
    }
    //交换函数
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] tree = {2, 5, 30, 1, 10, 4};
        int[] sorted = heap_sort(tree, 6);
        System.out.println(Arrays.toString(sorted));
    }
}
