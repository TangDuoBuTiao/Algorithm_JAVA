package 校招2020.VIPKID;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        //计算
        DecimalFormat df = new DecimalFormat("######0.00");
        if (k >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(df.format(arr[i]) + " ");
            }
        }
        int i = 0;
        int j = k - 1;
        double res = 0.0;
        while (j < arr.length) {
            if (i == 0) {
                for (int p = i; p <= j; p++) {
                    res += arr[p];
                }
                System.out.print(df.format(res / k) + " ");
                i++;
                j++;
            } else {
                res = res - arr[i - 1];
                res = res + arr[j];
                System.out.print(df.format(res / k) + " ");
                i++;
                j++;
            }
        }
    }
}
