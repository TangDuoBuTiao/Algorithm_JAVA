package 玩转算法面试.复杂度分析;
/*
 * 时间复杂度O(logN) 以10为底
 * 思路：遍历数字，数字每次对10取余加上‘0’,这得到的是ascii码，需要在前面加(char),
 *      数字再对10取整，直到数字为0。
 */

public class 整型转字符串 {

    public static void intToString(int num) {
        String str = "";
        if (num == 0) {
            System.out.print("0");
        }
        if (num < 0) {
            str = int2String(-num);
            System.out.println("-" + str);
        }else{
            System.out.print(int2String(num));
        }
    }
    //只处理正数
    public static String int2String(int num){
        StringBuilder str = new StringBuilder();
        while (num != 0) {
            str.append((char) ('0' + num % 10));
            num = num / 10;
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 0;
        intToString(num);
    }
}
