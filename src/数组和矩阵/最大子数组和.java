package 数组和矩阵;

public class 最大子数组和 {
    public static int solution(int nums[]) {
        int ans = 0, sum = 0, flag = 0, max = -2147367;
        for (int i = 0; i < nums.length; i++){
            if (max < nums[i]){
                max = nums[i];
            }
            if (nums[i] < 0){
                flag++;
            }
            if(sum < 0){
                sum = 0;
            }
            sum += nums[i];
            if( ans < sum){
                ans = sum;
            }
        }
        if(flag == nums.length){
            return max;
        }
        else {
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] b = {1, 2, -5, 4, 5, -7, -1, 100};
        int[] c = {-1,-2};
        System.out.println(solution(c));
    }
}
