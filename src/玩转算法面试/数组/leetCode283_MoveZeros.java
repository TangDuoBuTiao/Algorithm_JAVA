package 玩转算法面试.数组;
/*
 * 给定一个数组nums,写一个函数，将数组中所有的0挪到数组的末尾，而维持其他所有非0元素的相对位置
 */

import java.util.Arrays;

public class leetCode283_MoveZeros {
    //把非零元素拿出来，放到另一个新数组，新数组后面补0
    //时间复杂度O(N)
    //空间复杂度O(N)
    public static void moveZeros1(int[] arr) {
        int[] newArray = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArray[index++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(newArray));
    }

    //把非0数字前移
    //时间复杂度O(N)
    //空间复杂度O(1)
    public static void moveZeros2(int[] arr) {
        //设置变量k,表示[0,k)区间的数字都是非0元素
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k] = arr[i];
                k++;
            }
        }
        for (int i = k; i < arr.length; i++) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    //把非0元素和0交换位置,保证区间[k,i]里面都是0
    public static void moveZeros3(int[] nums) {
        int k = 0;   //k始终指向数组中的第一个0元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, k, i);
                    k++;
                } else {
                    k++;
                }

            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 0, 12, 5};
        moveZeros3(arr);
    }
}
