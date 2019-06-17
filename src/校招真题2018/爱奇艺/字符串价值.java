package 校招真题2018.爱奇艺;
/*
 * 问题描述：有一种有趣的字符串价值计算方式:统计字符串中每种字符出现的次数,然后求所有字符次数的平方和作为字符串的价值
           例如: 字符串"abacaba",里面包括4个'a',2个'b',1个'c',于是这个字符串的价值为4 * 4 + 2 * 2 + 1 * 1 = 21
           牛牛有一个字符串s,并且允许你从s中移除最多k个字符,你的目标是让得到的字符串的价值最小。
   输入：输入包括两行,第一行一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),其中只包含小写字母('a'-'z')。
        第二行包含一个整数k(0 ≤ k ≤ length),即允许移除的字符个数。
   输出：输出一个整数,表示得到的最小价值
   eg: aba
   *   1
   *   2
 */

import java.util.Scanner;
import java.util.HashMap;

public class 字符串价值 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;   //记录字母次数数组的长度
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                len++;
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        int[] nums = new int[len];
        int index = 0;
        for (char key : map.keySet()) {
            nums[index++] = map.get(key);
        }
        while (k > 0 && getMax(nums) != -1) {
            nums[getMax(nums)]--;
            k--;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += nums[i] * nums[i];
        }
        System.out.println(res);
    }

    //返回数组中的最大值的位置
    public static int getMax(int[] arr) {
        int res = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= res) {
                res = arr[i];
                index = i;
            }
        }
        return index;
    }
}
