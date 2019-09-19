package 校招2020.百度;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr1[][] = new int[n][3];
        int arr2[] = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i][0] = sc.nextInt();
            arr1[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        //计算
        Arrays.sort(arr2);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr1[i][1] > arr1[j][1]) {
                    int tmp1 = arr1[i][0];
                    int tmp2 = arr1[i][1];
                    arr1[i][0] = arr1[j][0];
                    arr1[i][1] = arr1[j][1];
                    arr1[j][0] = tmp1;
                    arr1[j][1] = tmp2;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[j][2] == 0 && arr2[i] >= arr1[j][0] && arr2[i] <= arr1[j][1]) {
                    arr1[i][2] = 1;
                    sum++;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

}