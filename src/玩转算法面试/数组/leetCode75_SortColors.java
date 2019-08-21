package 玩转算法面试.数组;
/*
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
   此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */


public class leetCode75_SortColors {
    //数组中元素个数有限，考虑使用计数排序
    //时间复杂度O(N)
    //空间复杂度O(K)
    public void sortColors1(int[] nums) {
        int count[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > 2) {
                throw new RuntimeException("nums is wrong");
            }
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            int num = 0;
            while (num < count[i]) {
                nums[index++] = i;
                num++;
            }
        }
    }

    //三路快排的思想，用两个变量维护3个区间，分布保存0,1,2
    //时间复杂度O(N)
    //空间复杂度O(1)
    public void sortColors2(int[] nums) {
        int zero = -1;           //维持nums[0,..,zero]区间全是0
        int two = nums.length;   //维持nums[two,..,n-1]区间全是2
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;  //直接判断下一个元素
            } else if (nums[i] == 2) {
                two--;  //扩充区间
                swap(nums[i], nums[two]);  //two这个位置的元素还没有被判断，和i位置交换，再判断它
            } else {
                if (nums[i] != 0) {
                    throw new RuntimeException("nums is wrong");
                }
                zero++;  //扩充区间
                swap(nums[zero], nums[i]);  //因为0要占据1的位置，所以交换位置
                i++;
            }
        }
    }

    public void swap(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
    }

}
