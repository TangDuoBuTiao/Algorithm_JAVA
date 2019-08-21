package 字符串;
/*  《找到指定的新类型字符》
 * 新类型字符定义如下：
 * 1.字符长度为1或者2的字符串
 * 2.表现形式可以为仅是小写字母，Eg: "a", 也可以是大写字母+小写字母，Eg: "Ab", 还可以是大写字母+大写字母，Eg: "AB"。
 * 先给定一个字符串str, str一定是若干新类型字符的正确组合结果， 再给一个整数k, 代表str中的位置,返回k位置指定的新类型字符串。
 * 解法：找到k位置之前有多少个连续的大写字母，根据奇偶数判断。
 */

public class 找到指定的新类型字符 {
    public static String pointNewChar(String str, int k) {
        if (str == null || str.equals("") || k < 0 || k > str.length()) {
            return "";
        }
        char[] chas = str.toCharArray();
        int uNum = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (!Character.isUpperCase(chas[i])) {  //如果不是大写字母
                break;  //遇到小写字母就停止
            }
            uNum++;  //统计k位置左边连续大写字母出现的个数
        }
        if ((uNum & 1) == 1) {   //如果uNum是奇数
            return str.substring(k - 1, k + 1);
        }
        if (Character.isUpperCase(chas[k])) { //如果uNum是偶数，并且k位置是大写字母
            return str.substring(k, k + 2);
        }
        return String.valueOf(chas[k]);
    }

    public static void main(String[] args) {
        String str = "aaABCDEcBCg";
        System.out.println(pointNewChar(str, 10));
    }
}
