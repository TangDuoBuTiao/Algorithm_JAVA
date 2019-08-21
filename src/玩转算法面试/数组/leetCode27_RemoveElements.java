package 玩转算法面试.数组;
/*
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 */

public class leetCode27_RemoveElements {

    public static int removeElement(int[] nums, int val) {
        int k = 0; //区间[0,k)全为非val元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(arr, 2));
    }
}
