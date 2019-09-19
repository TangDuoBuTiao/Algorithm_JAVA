package leetcode;
//找出数组中，元素个数超过数组长度一半的元素

public class num169_求众数 {
    public static int majorityElement(int[] nums) {
        int flag = nums[0];   //候选人
        int count = 1;   //投票
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {  //重新选择候选人
                flag = nums[i];
                count = 1;
            } else {
                if (nums[i] != flag) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr));
    }
}
