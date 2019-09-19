package 校招2020.爱奇艺;

import java.util.Arrays;
import java.util.Scanner;

public class wu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //计算
        Arrays.sort(arr);
        if (arr[n - 1] >= arr[0] + arr[1]) {
            System.out.println(arr[n - 1]);
        }else{
            System.out.println(arr[0] + arr[1]);
        }
    }
}
