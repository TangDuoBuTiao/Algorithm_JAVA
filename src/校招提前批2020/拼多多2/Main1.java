package 校招提前批2020.拼多多2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        //输入部分
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();  //长度
        int n = sc.nextInt();  //个数
        int[] points = new int[n];  //位置
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        //计算部分
        //先判断珍珠个数的奇偶
        int res = 0;
        if (n % 2 == 0) {
            //先确定最中间的两个，移动他俩到一块
            int lp = points[(n / 2) - 1];  //中间两个珍珠左边的位置
            int rp = points[(n / 2)]; //中间两个珍珠右边的位置
            //判断移动方向
            if (lp < points[(n / 2) - 2]) {  //比它左边的位置小,l--, r++
                while ((rp + l) - lp != 1) {
                    lp--;
                    res++;
                    rp++;
                    res++;
                }
                for (int i = (n / 2) - 2; i >= 0; i--) {  //lp左边的向lp靠拢
                    lp++;  //向左移动一位
                    res += points[i] - lp;
                }
                for (int i = (n / 2) + 1; i < n; i++) { //rp右边的向rp靠拢
                    rp--;
                    res += rp - points[i];
                }
                System.out.println(res);
                return;
            } else {  //比它左边的位置大，l++, r--
                while((rp - lp) != 1){
                    lp++;
                    res++;
                    rp--;
                    res++;
                }
                for (int i = (n / 2) - 2; i >= 0; i--) {  //lp左边的向lp靠拢
                    lp--;  //向左移动一位
                    res += lp - points[i];
                }
                for (int i = (n / 2) + 1; i < n; i++) { //rp右边的向rp靠拢
                    rp++;
                    res += points[i] - rp;
                }
                System.out.println(res);
                return;
            }

        }
    }
}
