package leetcode;
/*
 * 《用队列实现栈》
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class num225 {
    //用两个队列实现栈
    Queue<Integer> q1 = new LinkedList<>();  //LinkedList类实现了Queue
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.offer(x);
        } else if (!q1.isEmpty()) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }

    public int pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new RuntimeException("your stack is empty.");
        } else if (q1.isEmpty()) {
            while (q2.size() != 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        } else {
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        }
    }

    public int top() {   //每次取完top后，要把top值移除队列，加到另一个队列中。
        int ans = 0;
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new RuntimeException("your stack is empty.");
        } else if (q1.isEmpty()) {
            while (q2.size() != 1) {
                q1.offer(q2.poll());
            }
            ans = q2.peek();
            q1.offer(q2.poll());
            return ans;
        } else {
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }
            ans = q1.peek();
            q2.offer(q1.poll());
            return ans;
        }
    }

    public boolean empty() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return true;
        }
        return false;
    }

    //    Deque<Integer> deq = new LinkedList<>();
//
//    public void push(int x) {
//        deq.offerLast(x);
//    }
//
//    public int pop() {
//        if (deq.isEmpty()) {
//            throw new RuntimeException("Your stack is empty.");
//        }
//        return deq.pollLast();
//    }
//
//    public int top() {
//        if (deq.isEmpty()) {
//            throw new RuntimeException("Your stack is empty.");
//        }
//        return deq.peekLast();
//    }
//
//    public boolean empty() {
//        if (deq.isEmpty()) {
//            return true;
//        }
//        return false;
//    }
    public static void main(String[] args) {

    }
}
