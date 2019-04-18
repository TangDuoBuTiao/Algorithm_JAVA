package 字符串;
/*    《KMP算法》
 * 问题：给定两个字符串str和match,长度分别为N和M, 实现一个算法，如果字符串str中含有子串match,则返回match在str中开始的位置，
 *      不含有则返回-1。
 */

public class KMP {
    //计算match字符串的nextArr数组，nextArr[i]的含义是match[i]之前的字符串中，
    // 后缀子串与前缀子串的最大匹配长度是多少
    public int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length){
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}
