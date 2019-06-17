package 校招真题2018.爱奇艺;
/*
 * 题目描述：对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,
 *          例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 *          牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 * 输入：输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割
 * 输出：如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
 * Eg: 1010 3 101010 2
 *     Equal
 */

import java.util.Scanner;

public class 循环数比较 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x1 = sc.next();
        int k1 = sc.nextInt();
        String x2 = sc.next();
        int k2 = sc.nextInt();

        if (x1.length() * k1 < x2.length() * k2) {
            System.out.println("Less");
            return;
        }
        if (x1.length() * k1 > x2.length() * k2) {
            System.out.println("Greater");
            return;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < k1; i++) {
            sb1.append(x1);
        }
        for (int i = 0; i < k2; i++) {
            sb2.append(x2);
        }
        //长度一致的情况，从高到低逐位比较
        for (int i = 0; i < sb1.length(); i++) {
            if (Integer.parseInt(String.valueOf(sb1.charAt(i))) > Integer.parseInt(String.valueOf(sb2.charAt(i)))) {
                System.out.println("Greater");
                return;
            }
            if (Integer.parseInt(String.valueOf(sb1.charAt(i))) < Integer.parseInt(String.valueOf(sb2.charAt(i)))) {
                System.out.println("Less");
                return;
            }
        }
        System.out.println("Equal");
    }
}
