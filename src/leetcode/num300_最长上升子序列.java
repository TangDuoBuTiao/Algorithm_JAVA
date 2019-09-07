package leetcode;

public class num300_最长上升子序列 {
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;

        for (int k = 0; k < nums.length; k++) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < nums[k]) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = nums[k];
            if (res == j) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 21, 18};
        System.out.println(lengthOfLIS(arr));
    }

}
