package 校招2020.小红书;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        //计算
        arr = bubbleSort(arr);

        int i = 0;
        int res = 0;
        int x = 0;
        int h = 0;
        while (i < n) {
            if (arr[i][0] >= x && arr[i][1] >= h) {
                if (i < n - 1 && (arr[i][0] > arr[i + 1][0] || arr[i][1] > arr[i + 1][0])) {

                } else {
                    x = arr[i][0];
                    h = arr[i][1];
                    res++;
                }
            }
            i++;
        }
        System.out.println(res);
    }

    /* 把最大的数放在最后面
     * param: arr  待排序数组
     * param: n   在数组中的[0,n]区间找到最大的数
     */
    public static void bubble(int[][] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i][0] > arr[i + 1][0]) {
                int tmp = arr[i][0];
                arr[i][0] = arr[i + 1][0];
                arr[i + 1][0] = tmp;
            } else if (arr[i][0] == arr[i + 1][0]) {
                if(arr[i][1] > arr[i + 1][1]){
                    int tmp = arr[i][1];
                    arr[i][1] = arr[i + 1][1];
                    arr[i + 1][1] = tmp;
                }
            }
        }
    }

    //循环调用bubble函数
    public static int[][] bubbleSort(int[][] arr) {
        int n = arr.length;
        for (int i = n; i >= 1; i--) {
            bubble(arr, i);
        }
        return arr;
    }
}
