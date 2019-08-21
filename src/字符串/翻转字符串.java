package 字符串;
/*             《翻转字符串》
 * 问题：给定一个字符类型的数组chas, 请在单词间做逆序调整，只要做到单词的顺序逆序即可，对空格位置没有要求。
 *     Eg: "dog loves pig", 调整后为"pig loves dog";
 * 补充问题：给定一个字符类型的数组chas和一个整数size, 请把大小为size的左半区整体移到右半区，右半区整体移到左半区。
 *      Eg:"ABCDE" size = 3, 翻转后的结果是DEABC
 */

import java.util.Arrays;

public class 翻转字符串 {
    //翻转字符串:先整体翻转，再每个词进行翻转
    public static void rotateWords(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chas = str.toCharArray();
        reverse(chas, 0, chas.length - 1);         //先整体翻转
        int l = -1;
        int r = -1;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ' ') {
                l = i == 0 || chas[i - 1] == ' ' ? i : l;
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
            }
            if (l != -1 && r != -1) {    //再局部翻转，每次l、r改变后才翻转
                reverse(chas, l, r);
                l = -1;
                r = -1;
            }
        }
        System.out.println(chas);
    }

    public static void reverse(char[] chas, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
    }

    //补充问题：先把chas[0,.,size-1]翻转，再把chas[size,.,length-1]翻转，最后再把chas整体翻转
    public static void rotatel(String str, int size) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chas = str.toCharArray();
        reverse(chas, 0, size - 1);
        reverse(chas, size, chas.length - 1);
        reverse(chas, 0, chas.length - 1);
        System.out.println(chas);
    }


    public static void main(String[] args) {
        String str = "dog loves pig";
        String str1 = "ABCDEFG";
        // reverse(str.toCharArray(), 0, str.length() - 1);
        //rotateWords(str);
        rotatel(str1, 5);
    }
}
