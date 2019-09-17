package 校招2020.Vivo;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        //计算
        int res = 0;
        int i = 0;
        int j = 0;
        int count1 = 1;
        int count2 = 0;
        while (i < arr.length) {
            if (j + 1 < arr.length && arr[j + 1] != arr[i]) {
                count2 = 1;
            }else{
                count1++;
            }

        }
    }
}
