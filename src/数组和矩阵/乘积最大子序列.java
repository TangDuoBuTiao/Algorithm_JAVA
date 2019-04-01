package 数组和矩阵;

public class 乘积最大子序列 {

    public static int solution(int nums[]) {
        int Max = Integer.MIN_VALUE, max = 1, min = 1;  //一个保存最大，一个保存最小
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {    //如果数组的数是负数，那么会导致最小的变大，最大的变小。故交换
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            Max = Math.max(Max, max);
        }

        return Max;
    }

    public static void main(String[] args) {
        int[] b = {2, -3, -2, -4, 2};
        int[] c = {-2, 0, -1};
        System.out.println(solution(b));
    }
}
