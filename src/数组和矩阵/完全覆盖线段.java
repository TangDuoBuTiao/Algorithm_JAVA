package 数组和矩阵;

import javax.naming.PartialResultException;
import java.util.Arrays;

public class 完全覆盖线段 {

    public static void bubble(int[][] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i][0] > arr[i + 1][0]) {
                int tmp0 = arr[i][0];
                int tmp1 = arr[i][1];
                arr[i][0] = arr[i + 1][0];
                arr[i][1] = arr[i + 1][1];
                arr[i + 1][0] = tmp0;
                arr[i + 1][1] = tmp1;
            }
        }
    }

    public static void bubbleSort(int[][] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            bubble(arr, i);
        }
    }

    public static boolean covert(int[][] s1, int[][] s2) {
        bubbleSort(s1);
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i][0] + " " + s1[i][1]);
        }
        for (int i = 0; i < s2.length; i++) {
            int start = s2[i][0];
            int end = s2[i][1];
            int len = end - start;
            for (int j = 0; j < s1.length; j++) {
                if (s1[j][0] <= start && s1[j][1] >= start) {
                    if (s1[j][1] - s1[j][0] >= len) {
                        break;
                    } else {
                        len = len - (s1[j][1] - s2[i][0]);
                        while (j < s1.length - 1 && s1[j][1] >= s1[j + 1][0]) {
                            len -= s1[j + 1][1] - s1[j + 1][0];
                            j++;
                            if (len <= 0) {
                                break;
                            }
                        }
                        if (len > 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] s1 = {{2, 3}, {1, 2}, {4, 8}, {7, 10}, {9, 10}};
        int[][] s2 = {{1, 3}, {5, 10}};
        System.out.println(covert(s1, s2));
    }
}
