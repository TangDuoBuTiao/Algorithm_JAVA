package 玩转算法面试.数组.对撞指针;
/*
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 */

import java.util.Arrays;

public class leetCode167_twoSum {
    //暴力求解
    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
    }

    //利用有序数组的特点，使用二分查找
    public static int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int k = target - numbers[i];
            int l = i + 1;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == k) {
                    res[0] = i;
                    res[1] = mid;
                    return res;
                } else if (numbers[mid] < k) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return res;
    }

    //对撞指针法
    public static int[] twoSum3(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }else if(numbers[i] + numbers[j] < target){
                i++;
            }else{
                j--;
            }
        }
        throw new RuntimeException("wrong");
    }

    public static void main(String[] args) {
        int[] nums = {5, 25, 75};
        System.out.println(Arrays.toString(twoSum3(nums, 100)));
    }
}
