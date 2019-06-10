package 剑指offer;
/*
 * 思路：先把整形数组转化为字符串数组，再对字符串数组进行排序，最后把字符串数组的元素从头到尾拼接起来。
 */

import java.util.Arrays;
import java.util.Comparator;



public class 把数组排成最小的数 {

    public static String PrintMinNumber(int[] number) {
        if (number.length == 0) {
            return "";
        }
        String[] strNumber = new String[number.length];
        for (int i = 0; i < number.length; i++) {
            strNumber[i] = String.valueOf(number[i]);
        }
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                if ((strNumber[i] + strNumber[j]).compareTo(strNumber[j] + strNumber[i]) > 0) {
                    String tmp = strNumber[i];
                    strNumber[i] = strNumber[j];
                    strNumber[j] = tmp;
                }
            }
        }
//        Arrays.sort(strNumber, new Comparator<String>() {
//            public int compare (String s1, String s2){
//                return (s1 + s2).compareTo(s2 + s1);
//            }
//        });
        String ans = "";
        for (int k = 0; k < strNumber.length; k++) {
            ans += strNumber[k];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] a = {3, 32, 321};
        System.out.println(PrintMinNumber(a));
    }
}
