package 字符串;
/*   《判断字符数组中是否所有的字符都只出现过一次》
 * 问题：给定一个字符类型的数组chas[], 判断chas中是否所有的字符都只出现过一次，
 * 要求1：时间复杂度为O(N)的方法；
 * 要求2：在保证额外空间复杂度为O(1)的前提下，请实现时间复杂度尽量低的方法。
 */

import java.util.HashSet;

public class 判断字符数组中是否所有字符都只出现过一次 {
    //要求1：使用布尔类型的数组，
    public static boolean isUnique1(char[] chas) {
        if (chas == null) {
            return true;
        }
        boolean[] map = new boolean[256];
        for (int i = 0; i < chas.length; i++) {
            if (map[chas[i]]) {
                return false;
            }
            map[chas[i]] = true;
        }
        return true;
    }

    //要求1：使用HashSet
    public static boolean isUnique11(char[] chas) {
        if (chas == null) {
            return true;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chas.length; i++) {
            if (set.contains(chas[i])) {
                return false;
            }
            set.add(chas[i]);
        }
        return true;
    }

    //要求2：使用迭代方式的堆排序进行排序，然后判断有没有重复字符
//    public boolean isUnique2(char[] chas) {
//        if (chas == null) {
//            return true;
//        }
//        headSort(chas);
//        for (int i = 1; i < chas.length; i++) {
//            if (chas[i] == chas[i - 1]) {
//                return false;
//            }
//        }
//        return true;
//    }

    //堆排序

    public static void main(String[] args) {
        String str = "abcd";
        char[] ch = str.toCharArray();
        System.out.println(isUnique11(ch));
    }
}
