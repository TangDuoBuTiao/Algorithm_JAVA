package 玩转算法面试.栈和队列;

import javafx.scene.layout.Priority;

import java.util.*;

public class num347_前K个高频元素 {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        //<元素，频次>保存在hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        //维护K个元素的优先队列,自定义排序规则,虽然队列里是kay,但是依照value排序
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);  //按照自然序
            }
        });
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        //遍历hashmap
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(key);
            } else {
                if (map.get(key) > map.get(pq.peek())) {
                    pq.poll();
                    pq.offer(key);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {10, 10, 10, 20, 30, 30, 30, 30, 30, 40};
        List<Integer> ans = topKFrequent(a, 2);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}
