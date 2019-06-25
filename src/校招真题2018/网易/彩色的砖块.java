package 校招真题2018.网易;
/*
 * 题目描述：小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。现在有一个给定的字符串s,
 *          s中每个字符代表小易的某个砖块的颜色。小易想把他所有的砖块排成一行。如果最多存在一对不同颜色的相邻砖块,
 *          那么这行砖块就很漂亮的。请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。
 *          (如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
 *
 *  例如: s = "ABAB",那么小易有六种排列的结果:
 *        "AABB","ABAB","ABBA","BAAB","BABA","BBAA"
 *       其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。
 * 输入：
 *     输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s中的每一个字符都为一个大写字母(A到Z)。
 * 输出：
 *     输出一个整数,表示小易可以有多少种方式。
 *
 * 解法：输入的字母种类只要大于2种，就一定满足不了“只有一对不同颜色的相邻砖块”的条件！！！
 *      如果有一种砖块，输出1；
 *      如果有两种砖块，输出2，只有[A..A][B..B]和[B..B][A..A]这两种情况。
 */

import java.util.Scanner;
import java.util.HashSet;

public class 彩色的砖块 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
            if (set.size() > 2) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(set.size());
    }

}
