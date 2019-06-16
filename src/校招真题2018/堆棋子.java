package 校招真题2018;
/*
 * 输入描述：
 *         输入包括三行,第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数
 *         第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
 *         第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)
 *
 * 输出描述：输出n个整数,第i个表示棋盘上有一个格子至少有i个棋子所需要的操作数,以空格分割。行末无空格
           如样例所示:
            对于1个棋子: 不需要操作
            对于2个棋子: 将前两个棋子放在(1, 1)中
            对于3个棋子: 将前三个棋子放在(2, 1)中
            对于4个棋子: 将所有棋子都放在(3, 1)中
 *      Eg: 4
 *          1 2 4 9
 *          1 1 1 1
 *     输出：0 1 3 10
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class 堆棋子 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] x = new int[size];
            int[] y = new int[size];
            for (int i = 0; i < size; i++) {
                x[i] = in.nextInt();
            }
            for (int i = 0; i < size; i++) {
                y[i] = in.nextInt();
            }
            int[] res = minOPs(size, x, y);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < size; i++) {
                result.append(res[i] + " ");
            }
            System.out.println(result.toString().trim());
        }
        in.close();
    }

    public static int[] minOPs(int size, int[] x, int[] y) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {  //枚举所有棋子到每个可能的（x,y）的距离，
                    pq.add(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
                }
                int resI = 0;
                int sum = 0;
                while (!pq.isEmpty()) {
                    sum += pq.poll();
                    res[resI] = Math.min(res[resI], sum);
                    resI++;
                }
            }
        }
        return res;
    }
}

