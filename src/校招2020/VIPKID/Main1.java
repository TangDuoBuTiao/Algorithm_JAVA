package 校招2020.VIPKID;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        while (n > 0) {
            res++;
            n = n & (n - 1);
        }
        System.out.println(res);
    }
}
