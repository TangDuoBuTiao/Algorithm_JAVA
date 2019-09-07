package 校招2020.途家;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int m = sc.nextInt();
        //计算
        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int min = 10;
            int index = -1;
            for (int j = 0; j < c.length; j++) {
                if (c[j] != '#' && Integer.parseInt(String.valueOf(c[j])) < min) {
                    min = Integer.parseInt(String.valueOf(c[j]));
                    index = j;
                }
            }
            c[index] = '#';
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] != '#') {
                sb.append(c[i]);
            }
        }
        System.out.println(sb.toString());
    }

}
