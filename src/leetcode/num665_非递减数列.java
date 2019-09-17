package leetcode;

public class num665_非递减数列 {
    public static boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
           if(nums[i] >= nums[i - 1]){
               continue;
           }
           count++;
           if(count > 1){
               return false;
           }
           if(i >= 2 && nums[i] <= nums[i - 2]){
               nums[i] = nums[i - 1];
           }else{
               nums[i - 1] = nums[i];
           }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3};
        System.out.println(checkPossibility(arr));
    }
}
