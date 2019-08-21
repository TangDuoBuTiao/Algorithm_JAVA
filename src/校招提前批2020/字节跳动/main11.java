package 校招提前批2020.字节跳动;

import java.util.Scanner;

public class main11 {
    public static void main(String[] args) {
        //输入部分
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();  //闹钟的数量
        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int x = sc.nextInt();
        int hour = sc.nextInt();
        int mi = sc.nextInt();
        //计算部分
        int xh = -1;
        int xm = -1;
        if (x >= 60) {  //把x换成小时分钟
            xh = 1;
            xm = x - 60;
        } else {
            xh = 0;
            xm = x;
        }
        int resIndex = -1;
        for (int i = 0; i < num; i++) {
            //计算闹钟加路程的时间，
            int h = 0;
            int m = 0;

            //判断是否有进位
            if (arr[i][1] + xm >= 60) {
                h = arr[i][0] + xh + 1;
                m = arr[i][1] + xm - 60;
            } else {
                h = arr[i][0] + xh;
                m = arr[i][1] + xm;
            }

            if (h < hour) {
                if (resIndex == -1) {
                    resIndex = i;
                } else if (arr[i][0] > arr[resIndex][0] || (arr[i][0] == arr[resIndex][0] && arr[i][1] > arr[resIndex][1])) {
                    resIndex = i;
                }


            }
            if (h == hour) {
                if (m <= mi) {
                    if (resIndex == -1) {
                        resIndex = i;
                    } else if (arr[i][0] > arr[resIndex][0] || (arr[i][0] == arr[resIndex][0] && arr[i][1] > arr[resIndex][1])) {
                        resIndex = i;
                    }
                }
            }
        }
        System.out.println(arr[resIndex][0] + " " + arr[resIndex][1]);

    }
}

