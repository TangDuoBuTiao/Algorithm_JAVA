package 校招真题2018.爱奇艺;
/*
 * 问题描述：
 * 牛牛又从生物科研工作者那里获得一个任务,这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
      例如:s = AGGTCTA
      序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。
   输入：输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 2000),其中只包含'A','C','G','T'这四种字符。
   输出：输出一个正整数,即最短没有出现在DNA序列s中的DNA片段的长度。
   Eg:AGGTCTA
   *  2
 */

import java.util.Scanner;
import java.util.HashSet;

public class DNA序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int i, j, len = str.length();
        HashSet<String> set = new HashSet<>();
        for (i = 1; i <= len; i++) {
            set.clear();
            for (j = 0; j <= len - i; j++) {
                set.add(str.substring(j, j + i));
            }
            if (set.size() < Math.pow(4, i)) {
                System.out.println(i);
                return;
            }
        }
    }
}
