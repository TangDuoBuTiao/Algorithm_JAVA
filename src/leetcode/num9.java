package leetcode;
/*
 * 《回文数》
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */

import java.util.Deque;
import java.util.LinkedList;

public class num9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        Deque<Integer> queue = new LinkedList<>();
        while (x != 0) {
            queue.push(x % 10);
            x = x / 10;
        }
        while (queue.size() > 1) {
            if (queue.size() != 1 && queue.pollFirst() != queue.pollLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
