package 校招提前批2020.字节跳动;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main33 {
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
            //先找到比两边小的位置，填上100
//            int[] res = new int[n];
//            int pre = arr[0];
//            int next = arr[2];
//            for (int i = 1; i < n - 1; i++) {
//                if (arr[i] <= pre && arr[i] <= next) {
//                    res[i] = 100;
//                    if (i + 1 < n - 1) {
//                        next = arr[i + 2];
//                        pre = arr[i];
//                    }
//                }
//            }
            int[] res = new int[n];
            int tmp = 0;  //记录前一个人的奖金
            //先判断前两个人
            if (arr[1] > arr[0]) {
                res[0] = 100;
                res[1] = 200;
                tmp = 200;
            } else if (arr[1] == arr[0]) {
                res[0] = 100;
                res[1] = 100;
                tmp = 100;
            } else {
                res[0] = 200;
                res[1] = 100;
                tmp = 100;
            }
            //从第3个人开始遍历
            for (int i = 2; i < n; i++) {
                if (arr[i] > arr[i - 1]) {
                    res[i] = tmp + 100;
                    tmp += 100;
                } else if (arr[i] == arr[i - 1]) {
                    res[i] = tmp;
                } else { //后一个人比前一个人小，后面需要减
                    if (tmp == 100) { //无法减的时候，前面的人全部都加100
                        int index = i - 1;
                        res[index] += 100;
                        index = i - 2;
                        while (index >= 0 && res[index] != 100) {
                            res[index] += 100;
                            index--;
                        }
                        tmp += 100;
                    }
                    res[i] = tmp - 100;
                    tmp -= 100;
                }
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += res[i];
            }
            System.out.println(sum);
            return;
        }
    }
}
