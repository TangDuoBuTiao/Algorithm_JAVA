package 校招2020.爱奇艺;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n == 0) {
            System.out.printf("%.5f", (double) n);
        }

        int[] arr = new int[n + m];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        ArrayList<String> list = Permutation(arr);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            for (int j = 0; j < s.length(); j++) {
                if (j % 3 == 0 && s.charAt(j) == '0') {
                    sum++;
                    break;
                }
                if (j % 3 == 1 && s.charAt(j) == '0') {
                    break;
                }
            }

        }
        System.out.printf("%.5f", (double) sum / list.size());

    }

    public static ArrayList<String> Permutation(int[] arr) {
        ArrayList<String> list = new ArrayList<>();
        if (arr.length == 0) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        permutation(sb.toString().toCharArray(), list, 0);
        return list;
    }

    public static void permutation(char[] c, ArrayList<String> list, int index) {
        if (index == c.length - 1) {
            if (!list.contains(new String(c))) {
                list.add(new String(c));
            }
        } else {
            for (int i = index; i < c.length; i++) {
                if (i % 3 == 1) {

                }
                swap(c, index, i);
                permutation(c, list, index + 1);
                swap(c, index, i);
            }
        }

    }

    public static void swap(char[] c, int i, int j) {
        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;
    }
}
