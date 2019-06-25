package 剑指offer;
/*
 * 问题：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 解法：使用优先队列维护一个小根堆
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class 最小的k个数 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length || k == 0){
            return list;
        }
        //优先队列维护了小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (pq.size() < k) {
                pq.offer(input[i]);
            } else if (pq.peek() > input[i]) {
                pq.poll();
                pq.offer(input[i]);
            }
        }
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> ans;
        ans = GetLeastNumbers_Solution(a, 4);
        System.out.println(ans.toString());

    }
}
