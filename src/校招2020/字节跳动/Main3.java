package 校招2020.字节跳动;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //计算部分
        if (n == 1) {
            System.out.println(100);
            return;
        } else if (n == 2) {
            if (arr[0] == arr[1]) {
                System.out.println(200);
                return;
            } else {
                System.out.println(300);
                return;
            }
        } else {  // n > 2
            int res = 0;  //记录总的奖金
            int tmp = 0;  //记录前一个人的奖金
            //先判断前两个人
            if (arr[1] > arr[0]) {
                res += 300;
                tmp = 200;
            } else if (arr[1] == arr[0]) {
                res += 200;
                tmp = 100;
            } else {
                res += 300;
                tmp = 100;
            }
            //从第3个人开始遍历
            for (int i = 2; i < n; i++) {
                if (arr[i] > arr[i - 1]) {
                    res += tmp + 100;
                    tmp += 100;
                } else if (arr[i] == arr[i - 1]) {
                    res += tmp;
                } else { //后一个人比前一个人小，后面需要减
                    if (tmp == 100) { //无法减的时候，前面的人全部都加100
                        res += i * 100;
                        tmp += 100;
                    }
                    res += tmp - 100;
                    tmp -= 100;

                }
            }
            System.out.println(res);
            return;
        }
    }
}
