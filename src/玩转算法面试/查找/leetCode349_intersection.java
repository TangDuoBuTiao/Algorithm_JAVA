package 玩转算法面试.查找;
/*
 * 给定两个数组，编写一个函数来计算它们的交集。
 */

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class leetCode349_intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for(int i : list){
            res[index++] = i;
        }
        return res;
    }
}
