package leetcode;

import java.util.Arrays;

public class num611_有效三角形的个数 {
    public static int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;   //直接加上可能的个数
                    r--;
                } else {  //说明两个数加起来太小，l指针需要后移
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4};
        System.out.println(triangleNumber(arr));
    }
}
