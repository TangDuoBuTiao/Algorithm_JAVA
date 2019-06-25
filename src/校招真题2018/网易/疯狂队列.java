package 校招真题2018.网易;
/*
 * 问题描述：给定一个数组，堆数组内的元素进行排列，使得相邻元素差的绝对值总和最大。
 * 输入：输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
        第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高
   输出：输出一个整数,表示n个学生列队可以获得的最大的疯狂值。
      Eg: 5
          5 10 25 40 25
      如样例所示:
      当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。这是最大的疯狂值了。
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class 疯狂队列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        if (size == 1) {
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        Deque<Integer> dq = new LinkedList<>();
        int left = 0;
        int right = size - 1;
        boolean flag = true;
        while (left < right) {
            if (flag) {
                dq.offerFirst(arr[right--]);
                dq.offerLast(arr[left++]);
                flag = false;
            } else {
                dq.offerFirst(arr[left++]);
                dq.offerLast(arr[right--]);
                flag = true;
            }
        }
        if ((size & 1) != 0) {  //如果是奇数个数，最后把最终间的数入队，队尾队头一样
            int mid = arr[(size + 1) / 2];  //判断中间的数，放在队尾还是队头
            if (Math.abs(mid - dq.peekFirst()) > Math.abs(mid - dq.peekLast())) {
                dq.offerFirst(arr[(size + 1) / 2]);
            }
            dq.offerLast(arr[(size + 1) / 2]);
        }
        //排好序后，计算最大差值
        int res = 0;
        int tmp = 0;
        while (dq.size() > 1) {
            tmp = dq.pollFirst();
            res += Math.abs(tmp - dq.peekFirst());
        }
        System.out.println(res);
    }
}
