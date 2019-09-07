package 校招2020.当当;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] str = s.split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int i = 0;
        int j = arr.length - 1;
        int k = 0;
        while (k < j){
            if (arr[k] == 2) {
                while (arr[j] == 2 && j > k) {
                    j--;
                }
                if (j > k) {
                    swap(arr, k, j);
                }
            }
            if (arr[k] == 0) {
                while(arr[i] == 0 && i < k){
                    i++;
                }
                if(i < k){
                    swap(arr, i, k);
                }
            }
            if(arr[k] == 1 || k == i){
                k++;
            }
        }

        for (int q = 0; q < arr.length; q++) {
            if (q == arr.length - 1) {
                System.out.print(arr[q]);
            } else {
                System.out.print(arr[q] + ",");
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmk = arr[i];
        arr[i] = arr[j];
        arr[j] = tmk;
    }

}
