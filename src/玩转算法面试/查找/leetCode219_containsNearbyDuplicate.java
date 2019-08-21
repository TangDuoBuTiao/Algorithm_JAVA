package 玩转算法面试.查找;

import java.util.HashSet;

//时间复杂度；O(n)
//空间复杂度：O(k)
public class leetCode219_containsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            //保持set中的元素最多有k个
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
