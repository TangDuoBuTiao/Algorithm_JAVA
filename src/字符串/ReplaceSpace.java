package 字符串;
/*            《字符串的调整与替换》
 * 问题：给定一个字符数组chas[]，chas的右半区全为空字符，左半区不含有空字符，现在想把左半区中所有的空格字符都替换为“20%”
 *      假设右半区足够大，可以满足所需的空间，完成替换函数。
 * 补充问题：给定一个字符数组chas[]，其中只含有数字字符和"*"字符，现在想把所有的"*"字符挪到chas[]的左边，数字字符挪到chas的右边。请完成调整函数
 */

import java.util.Arrays;

public class ReplaceSpace {
    //替换为20%
    public static void replace(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int num = 0; //空格的数量
        int len = 0; //左半区的长度
        for (len = 0; len < chas.length && chas[len] != 0; len++) {
            if (chas[len] == ' ') {
                num++;
            }
        }
        int j = len + num * 2 - 1;
        for (int i = len - 1; i > -1; i--) {
            if (chas[i] != ' ') {
                chas[j--] = chas[i];
            } else {
                chas[j--] = '0';
                chas[j--] = '2';
                chas[j--] = '%';
            }
        }
        System.out.println(Arrays.toString(chas));
    }

    // 补充问题：
    public static void modify(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int j = chas.length - 1;
        for (int i = chas.length - 1; i >= 0; i--) {
            if (chas[i] != '*') {
                chas[j--] = chas[i];
            }
        }
        for (; j >= 0; j--) {
            chas[j] = '*';
        }
        System.out.println(Arrays.toString(chas));
    }

    public static void main(String[] args) {
        char[] chas = {'a', ' ', 'b', ' ', ' ', 'c', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0',};
        char[] cham = {'1', '*', '*', '2', '3'};
        modify(cham);
        //replace(chas);
    }

}
