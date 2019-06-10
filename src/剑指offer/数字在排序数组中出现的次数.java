package 剑指offer;

public class 数字在排序数组中出现的次数 {
    public static int GetNumberOfK(int[] array, int k) {
        int len = array.length;
        int index = binarySearch(array, k, len);
        int left = index;
        int right = index;
        while (array[left] == k) {
            if (left > 0) {
                left--;
            } else {
                break;
            }
        }
        while (array[right] == k) {
            if (right < len - 1) {
                right++;
            } else {
                break;
            }
        }
        return right;
    }

    // 二分查找算法
    public static int binarySearch(int[] arr, int target, int n) {
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 3, 3, 3, 5};
        System.out.println(binarySearch(a, 6, 6));
    }
}
