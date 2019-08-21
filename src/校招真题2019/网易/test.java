package 校招真题2019.网易;

import java.util.PriorityQueue;
import java.util.Comparator;

public class test {
    public static void main(String[] args) {
        int[] a = {4, 2, 6, 4, 8, 5, 9};
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int i = 0; i < a.length; i++) {
            pq.offer(a[i]);
        }
        System.out.println(pq.peek());
    }
}
