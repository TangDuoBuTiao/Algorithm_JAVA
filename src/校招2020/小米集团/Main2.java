package 校招2020.小米集团;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        //计算
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > 0) {
                sum += arr[i];
                res = Math.max(res, sum);
            } else {
                sum = 0;
            }
        }
        System.out.println(res);
    }
}
