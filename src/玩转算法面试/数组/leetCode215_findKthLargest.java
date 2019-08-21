package 玩转算法面试.数组;
/*
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetCode215_findKthLargest {
    //先排个序
    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    //这个优先队列慢
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>(){
                    public int compare(Integer o1, Integer o2){
                        return o2 - o1;
                    }
                }
        );
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
        }
        int res = 0;
        while(k > 0){
            res = pq.poll();
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4,3};
        System.out.println(findKthLargest2(nums, 2));
    }
}
