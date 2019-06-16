package 校招真题2018;
/*
 * 问题：有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 */

import java.util.Scanner;

public class 大整数相乘 {

    public static void main(String[] args) {
        //接收两个字符串
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        System.out.println(multiply(num1, num2));

    }

    public static String multiply(String num1, String num2){
        //把两个大整数用数组逆序存储，数组长度等于两整数长度之和
        int len1 = num1.length();
        int len2 = num2.length();
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];
        for (int i = 0; i < len1; i++) {
            arr1[i] = num1.charAt(len1 - 1 - i) - '0';
        }
        for (int i = 0; i < len2; i++) {
            arr2[i] = num2.charAt(len2 - 1 - i) - '0';
        }
        //构建result数组，长度为两整数长度之和
        int[] res = new int[len1 + len2];
        //嵌套循环，整数2的每一位依次与整数1的所有位相乘，并把结果累加
        for (int i = 0; i < len2; i++) {    //外层循环是整数2
            for (int j = 0; j < len1; j++) { //内层循环是整数1
                //整数2的某一位和整数1的所有位相乘
                res[i + j] += arr2[i] * arr1[j];
                //如果result某一位大于10，则进位，进位数是除以10的商
                if(res[i + j] >= 10){
                    res[i+ j + 1] += res[i + j] / 10;
                    //res[i+j]取余是等于，而不是加等，是因为前面res[i+j]已经有值了，现在是为了覆盖它，而且以后此位置不会再有值
                    res[i + j] = res[i + j] % 10;
                }
            }
        }
        //把res数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        //是否找到大整数的最高有效位,因为res数组预留的长度大于最后相乘的结果，翻转后，前面会有若干个0
        boolean findFirst = false;
        for(int i = res.length - 1; i >= 0; i--){
            if(!findFirst){
                if(res[i] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
