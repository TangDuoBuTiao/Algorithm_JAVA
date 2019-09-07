package 校招2020.腾讯;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        //计算
        //至少出现a次正面朝上的次数
        int total = (int)Math.pow(2,n);
        int numa = 0;
        for (int i = a; i <= n; i++) {
            numa += combination(n, i);
        }
        System.out.println(numa);
        //至少出现b次反面朝上的次数
        int numb = 0;
        for (int i = b; i <= n; i++) {
            numb += combination(n, i);
        }
        System.out.println(numb);
    }

    private static long factorial(long n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    public static long combination(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }
}
