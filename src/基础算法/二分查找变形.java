package 基础算法;

public class 二分查找变形 {
    //查找第一次出现的元素
    public static int binarySearchLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {  //此时的值可能就是最左目标的值，因此需要将当前值继续保留在搜索区间内
                r = mid;
            } else { //如果小于，mid处的值不是最终目标，不需要保留，直接加1
                l = mid + 1;
            }
        }
        if (nums[r] == target) {
            return r;
        }
        return -1;
    }

    //查找最后一次出现的值
    public static int binarySearchRight(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;   //不同之处，在此处计算mid时加1，防止死循环
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (nums[r] == target) {
            return r;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 3};
        System.out.println(binarySearchRight(arr, 2));
    }
}
