package 校招真题2018.爱奇艺;
/*
 问题描述: 牛牛举办了一场数字游戏,有n个玩家参加这个游戏,游戏开始每个玩家选定一个数,然后将这个数写在纸上(十进制数,无前缀零),
         然后接下来对于每一个数字将其数位按照非递减顺序排列,得到新的数,新数的前缀零将被忽略。
         得到最大数字的玩家赢得这个游戏。
 输入：输入包括两行,第一行包括一个整数n(1 ≤ n ≤ 50),即玩家的人数
      第二行n个整数x[i](0 ≤ x[i] ≤ 100000),即每个玩家写下的整数。
 输出：输出一个整数,表示赢得游戏的那个玩家获得的最大数字是多少。
 Eg:3
    9638 8210 331
    3689
 */

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class 数字游戏 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.next();
        }
        //去除0
        int[] noZero = new int[len];
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp = Integer.valueOf(arr[i]);
            while (tmp % 10 == 0) {
                tmp = tmp / 10;
            }
            noZero[i] = tmp;
        }

        //找最长
        String strTmp = "";
        int maxLen = -1;
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            strTmp = String.valueOf(noZero[i]);
            if (strTmp.length() > maxLen) {
                if (i != 0) {
                    queue.poll();
                }
                queue.offer(strTmp);
                maxLen = strTmp.length();   //更新最大值
            } else if (strTmp.length() == maxLen) {
                queue.offer(strTmp);
            } else {
                continue;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arrs = new int[maxLen];
        while (!queue.isEmpty()) {
            String s = queue.poll();
            for (int i = 0; i < maxLen; i++) {   //将s转换为整型数组
                arrs[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            Arrays.sort(arrs);

            StringBuilder sb = new StringBuilder();   //旧的由系统自动回收
            for (int i = 0; i < maxLen; i++) {
                sb.append(arrs[i]);
            }
            pq.offer(Integer.valueOf(sb.toString()));
        }
        while (pq.size() > 0) {
            if (pq.size() > 1) {
                pq.poll();
            } else {
                System.out.println(pq.poll());
            }
        }

    }
}
