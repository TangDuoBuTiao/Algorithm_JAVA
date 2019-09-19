package leetcode;
/*
 * 问题描述：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * Eg:输入: nums = [1,1,1,2,2,3], k = 2
      输出: [1,2]
 说明：
    你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
    你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class num347_前k个高频元素 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        //默认是小根堆，就用小根堆，但是入队的是元素，需要排序的是元素是频次，所以重写比较方法
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (map.get(o1) - map.get(o2)));
        for (int key : map.keySet()) {
            if (pq.size() < k) {   //先把前k个元素加进去
                pq.offer(key);
            } else if (map.get(key) > map.get(pq.peek())) {  //只要比队头元素大，就入队
                pq.poll();  //队首元素出队
                pq.offer(key);
            }
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + "  ");
            res.add(pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-1, -1, -1, 1, 1, 2, 3};
        topKFrequent(a, 2);
    }
}
