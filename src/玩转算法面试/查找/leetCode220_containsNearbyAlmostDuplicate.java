package 玩转算法面试.查找;

import java.util.HashSet;

public class leetCode220_containsNearbyAlmostDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.isEmpty() && abs(set, nums[i], t)) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static boolean abs(HashSet<Integer> set, int target, int t) {
        for (int x : set) {
            if (Math.abs(x - target) > t) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
