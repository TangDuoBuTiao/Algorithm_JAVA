package 栈和队列;
/*
 最大值减去最小值<=num 的子数组的个数
 */

import java.util.LinkedList;

public class 最大值减去最小值小于等于num的子数组数量 {
    public int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();  //存放子数组中的最小值
        LinkedList<Integer> qmax = new LinkedList<>();  //存放子数组中的最大值
        int i = 0, j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {  //动态调整最小值，保持qmin队头到队尾递增
                    qmin.pollLast();  //移除队尾元素
                }
                qmin.addLast(j);  //把更小的添加到队尾
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {  //动态调整最大值，保证qmax队头到队尾递减
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {  //一旦不满足条件，停止j向右扩展
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i) {   //i即将不开头，如果队列里最大值/最小值在i这个位置，就出队。
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += j - i;  //此时arr[i,j]里所有以i下标开头的子数组都满足条件
            i++;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 3, 2, 1};
        最大值减去最小值小于等于num的子数组数量 m = new 最大值减去最小值小于等于num的子数组数量();
        System.out.println(m.getNum(a, 1));
    }


}
