package 剑指offer;
/*
 * 问题：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */

import java.util.ArrayList;
import java.util.Arrays;

public class 最小的k个数 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int index = 0;
        if (input.length < k) {
            return list;
        }
        for (int i = 0; i < input.length; i++) {
            if (list.size() < k) {
                list.add(input[i]);
                continue;
            } else {
                max = Integer.MIN_VALUE;
                index = 0;
                for (int j = 0; j < k; j++) {
                    if (list.get(j) > max) {
                        max = list.get(j);
                        index = j;
                    }
                }
                if (input[i] < max) {
                    list.remove(index);
                    list.add(input[i]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> ans = new ArrayList<>();
        ans = GetLeastNumbers_Solution(a, 4);
        System.out.println(ans.toString());
//        for (int i = 0; i < ans.size(); i++) {
//            System.out.println()
//        }
    }
}
