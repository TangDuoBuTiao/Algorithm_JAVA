package 玩转算法面试.数组;
/*
 * 以二分查找法为例
 */

public class 如何写出正确的代码 {
    //明确变量的含义
    //循环不变量
    //小数据量调试

    public static int binarySearch(int[] arr, int n, int target) {
        int l = 0;
        int r = n - 1;  //在[l,..,r]的范围里寻找target
        while (l <= r) {  //当l==r时，区间[l,..,r]里依然有一个元素
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                l = mid + 1;   //target在[mid+1,..,r]中
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
