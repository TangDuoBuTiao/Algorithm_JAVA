package 玩转算法面试.复杂度分析;

/*
 *算法复杂度: O(NlogN)  以2为底
 */

public class 二分查找 {

    public static void binarySearch(int[] arr, int n, int target) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                System.out.print("find");
                return;
            } else if (arr[mid] < target) {
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        System.out.println("Not find");
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 9, 12, 23, 36, 57, 66};
        binarySearch(arr, 11, 23);
    }
}
